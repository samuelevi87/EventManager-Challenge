package br.com.sl3v1.challengeselection.people;

import br.com.sl3v1.challengeselection.room.Room;
import br.com.sl3v1.challengeselection.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PeopleService {

    private PeopleRepository repository;
    private RoomService roomService;

    @Autowired
    public PeopleService(PeopleRepository repository, RoomService roomService) {
        this.repository = repository;
        this.roomService = roomService;
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

        try {
        Room roomSmallerLotation = rooms.stream()
                .min(Comparator.comparing(Room::getLotation))
                .get(); //Retornando a sala com menor lotação

            if (roomSmallerLotation.getCapacity() < roomSmallerLotation.getLotation()) {
                people.setRoomId(roomSmallerLotation.getId()); //Se a capacidade da sala for menor que a lotação, há espaço para outra pessoa.
                roomSmallerLotation.setLotation() = roomSmallerLotation.getLotation() + 1;
            } else {
                throw new Exception("Todas as salas estão lotadas!");
            }
        }catch (NullPointerException e){
            people.setRoomId(1L);
        }

        return this.repository.save(people);
    }

    public void update(People people, Long id) {
        this.repository.save(people);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

}	

