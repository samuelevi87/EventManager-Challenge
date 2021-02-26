package br.com.sl3v1.challengeselection.coffee;

import br.com.sl3v1.challengeselection.people.People;
import br.com.sl3v1.challengeselection.people.PeopleService;
import br.com.sl3v1.challengeselection.room.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1/coffee", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CoffeeController {

    private CoffeeService coffeeService;
    private PeopleService peopleService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Coffee>> findAll() {
        return ResponseEntity.ok(coffeeService.findAll());
    }

    @GetMapping("/f/")
    @ResponseBody
    public ResponseEntity<Coffee> getMinLotation() {
        return ResponseEntity.ok(coffeeService.getMinLotation());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Coffee> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(coffeeService.findById(id));
    }

    @GetMapping("/list/{coffee_id}")
    public ResponseEntity<List<People>> findByCoffeeId(@PathVariable(value = "coffee_id") Long coffeeId) {
        return ResponseEntity.ok(peopleService.findByCoffeeId(coffeeId));
    }

    @PostMapping
    public ResponseEntity<Coffee> save(@RequestBody Coffee coffee) {
        return ResponseEntity.ok(coffeeService.save(coffee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coffee> update(@PathVariable("id") Long id,
                                         @RequestBody Coffee coffee) throws Exception {
        coffeeService.update(coffee, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public void update(@PathVariable("id") Long id) {
        coffeeService.delete(id);
    }


}
