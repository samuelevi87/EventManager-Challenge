package br.com.sl3v1.challengeselection.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/people", produces = {"application/JSON"})
public class PeopleController {

    private PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public ResponseEntity<List<People>> findAll() {
        return ResponseEntity.ok(peopleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<People> findById(@PathParam(value = "id") Long id) {
        return ResponseEntity.ok(peopleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<People> save(@RequestBody People people) throws Exception {
        return ResponseEntity.ok(peopleService.save(people));
    }

    @PutMapping("/{id}")
    public ResponseEntity<People> update(@RequestBody People people, @PathParam(value = "id") Long id) throws Exception {
        People peopleSaved = peopleService.update(people, id);
        return new ResponseEntity<>(peopleSaved, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathParam("id") Long id) {
        peopleService.delete(id);
    }
}
