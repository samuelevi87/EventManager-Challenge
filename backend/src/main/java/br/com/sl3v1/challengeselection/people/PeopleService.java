package br.com.sl3v1.challengeselection.people;

import br.com.sl3v1.challengeselection.coffee.Coffee;
import br.com.sl3v1.challengeselection.coffee.CoffeeService;
import br.com.sl3v1.challengeselection.room.Room;
import br.com.sl3v1.challengeselection.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    private PeopleRepository repository;
    private RoomService roomService;
    private CoffeeService coffeeService;

    @Autowired
    public PeopleService(PeopleRepository repository, RoomService roomService, CoffeeService coffeeService) {
        this.repository = repository;
        this.roomService = roomService;
        this.coffeeService = coffeeService;
    }

    public List<People> findAll() {
        return (List<People>) repository.findAll();
    }

    public People findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<People> findByRoomId(Long roomId) {
        return repository.findByRoomId(roomId);
    }

    public List<People> findByCoffeeId(Long coffeeId) {
        return repository.findByCoffeeId(coffeeId);
    }

    public People save(People people) throws Exception {
        List<Room> rooms = roomService.findAll();
        if (rooms == null || rooms.isEmpty()) {
            throw new Exception("Não existem Salas cadastradas");
        }
        List<Coffee> coffee = coffeeService.findAll();
        if (coffee == null || coffee.isEmpty()) {
            throw new Exception("Não existem Salas de café cadastrados");
        }

        Room roomSmallerLotation = rooms.stream()
                .min(Comparator.comparing(Room::getLotation))
                .get(); //Retornando a sala com menor lotação

        if (roomSmallerLotation.getLotation() < roomSmallerLotation.getCapacity()) {
            people.setRoomId(roomSmallerLotation.getId()); //Se a capacidade da sala for menor que a lotação, há espaço para outra pessoa.
            people.setCoffeeId(roomSmallerLotation.getId());
        } else {
            throw new Exception("Todas as salas estão lotadas!");
        }

        Coffee coffeeSmallerLotation = coffee.stream()
                .min(Comparator.comparing(Coffee::getLotation))
                .get(); //Retornando o espaço de cafe com menor lotação
        if (coffeeSmallerLotation.getLotation() < coffeeSmallerLotation.getCapacity()) {
            people.setCoffeeId(coffeeSmallerLotation.getId()); //Se a capacidade da sala for menor que a lotação, há espaço para outra pessoa.
        } else {
            throw new Exception("Todas as salas de café estão lotadas!");
        }


        return this.repository.save(people);
    }

    public People update(People people, Long id) throws Exception {
        Optional<People> peopleOptional = repository.findById(id);

        if (peopleOptional.isPresent()) {
            People peopleDb = peopleOptional.get();
            peopleDb.setName(people.getName());
            peopleDb.setSurname(people.getSurname());
            repository.save(peopleDb);
        } else {
            throw new Exception("Pessoa com o id informado não encontrado: " + id);
        }
        return people;
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

}	

