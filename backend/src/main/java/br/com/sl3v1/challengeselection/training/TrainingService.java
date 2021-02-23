package br.com.sl3v1.challengeselection.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {
	
	private TrainingRepository repository;
	
	@Autowired
	public TrainingService (TrainingRepository repository) {
		this.repository = repository;

	}
	
	  public List<Training> findAll() {
	        return (List<Training>) repository.findAll();
	    }

	    public Training findById(Long id) {
	        return repository.findById(id).orElse(null);
	    }

	    public Training save(Training training) {
	        return repository.save(training);
	    }

	    public void update(Training training, Long id) {
	        repository.save(training);
	    }

	    public void delete(Long id) {
	        repository.deleteById(id);
	    }

}
