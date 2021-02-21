package br.com.sl3v1.challengeselection.coffee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CoffeeService {
	private CoffeeRepository repository;
	
	@Autowired
	public CoffeeService(CoffeeRepository repository) {
		this.repository = repository;
	}
	
	public List<Coffee> findAll() {
        return (List<Coffee>) repository.findAll();
    }

    public Coffee findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Coffee save(Coffee coffee) {
        return repository.save(coffee);
    }

    public void update(Coffee coffee, Long id) {
        repository.save(coffee);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
