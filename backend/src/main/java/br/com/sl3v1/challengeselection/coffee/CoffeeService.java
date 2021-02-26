package br.com.sl3v1.challengeselection.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService {
    private CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public List<Coffee> findAll() {
        return (List<Coffee>) coffeeRepository.findAll();
    }

    public Coffee findById(Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    public Coffee save(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    public void update(Coffee coffee, Long id) throws Exception {

        Optional<Coffee> coffeeOptional = coffeeRepository.findById(id);

        if (coffeeOptional.isPresent()) {
            Coffee coffeeDb = coffeeOptional.get();
            coffeeDb.setName(coffee.getName());
            coffeeDb.setCapacity(coffee.getCapacity());
            coffeeRepository.save(coffeeDb);
        } else {
            throw new Exception("Espaço do café com o id " + id + " não encontrado");
        }
    }

    public void delete(Long id) {
        coffeeRepository.deleteById(id);
    }

    public Coffee getMinLotation() {
        return coffeeRepository.getMinLotation();
    }
}
