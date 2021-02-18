package br.com.sl3v1.challengeselection.people;

import java.util.List;

																																				import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

    private PeopleRepository repository;

    @Autowired
    public PeopleService(PeopleRepository repository) {
        this.repository = repository;
    }

    public List<People> findAll() {
        return (List<People>) repository.findAll();
    }

    public People findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public People save(People people) {
        return repository.save(people);
    }

    public void update(People people, Long id) {
        repository.save(people);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}	

