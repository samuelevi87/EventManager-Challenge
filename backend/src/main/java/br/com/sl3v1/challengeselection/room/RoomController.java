package br.com.sl3v1.challengeselection.room;

import br.com.sl3v1.challengeselection.people.People;
import br.com.sl3v1.challengeselection.people.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1/room", produces = {MediaType.APPLICATION_JSON_VALUE})
public class RoomController {

    private RoomService roomService;
    private PeopleService peopleService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Room>> findAll() {
        return ResponseEntity.ok(roomService.findAll());
    }

    @GetMapping("/f/")
    @ResponseBody
    public ResponseEntity<Room> getMinLotation() {
        return ResponseEntity.ok(roomService.getMinLotation());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Room> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(roomService.findById(id));
    }

    @GetMapping("/list/{room_id}")
    public ResponseEntity<List<People>> findByRoomId(@PathVariable(value = "room_id") Long roomId) {
        return ResponseEntity.ok(peopleService.findByRoomId(roomId));
    }

    @PostMapping
    public ResponseEntity<Room> save(@RequestBody Room room) {
        return ResponseEntity.ok(roomService.save(room));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> update(@PathVariable("id") Long id,
                                 @RequestBody Room room) throws Exception {
        roomService.update(room, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        roomService.delete(id);
    }


}
