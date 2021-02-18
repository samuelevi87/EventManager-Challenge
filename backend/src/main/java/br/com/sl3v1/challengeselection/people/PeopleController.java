package br.com.sl3v1.challengeselection.people;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api/v1/people", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PeopleController {


    private PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    @ResponseBody
    public List<People> findAll() {
        return peopleService.findAll();
    }

    @SuppressWarnings("unchecked")
	@GetMapping("/{id}")
    @ResponseBody
    public List<People> findById(@PathParam("id") Long id) {
        return (List<People>) peopleService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public People save(@RequestBody People people) {
        return peopleService.save(people);
    }

    @PutMapping("/{id}")
    public void update(People people, @PathParam("id") Long id) {
        peopleService.update(people, id);
    }

    @DeleteMapping("/{id}")
    public void update(@PathParam("id") Long id) {
        peopleService.delete(id);
    }
}
