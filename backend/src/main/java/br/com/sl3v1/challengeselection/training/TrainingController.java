package br.com.sl3v1.challengeselection.training;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api/v1/training", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TrainingController {


    private TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping
    @ResponseBody
    public List<Training> findAll() {
        return trainingService.findAll();
    }

    @SuppressWarnings("unchecked")
	@GetMapping("/{id}")
    @ResponseBody
    public List<Training> findById(@PathParam("id") Long id) {
        return (List<Training>) trainingService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public Training save(@RequestBody Training training) {
        return trainingService.save(training);
    }

    @PutMapping("/{id}")
    public void update(Training training, @PathParam("id") Long id) {
    	trainingService.update(training, id);
    }

    @DeleteMapping("/{id}")
    public void update(@PathParam("id") Long id) {
    	trainingService.delete(id);
    }
    
}
