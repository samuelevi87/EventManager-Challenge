package br.com.sl3v1.challengeselection.room;

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
@RequestMapping(path = "/api/v1/room", produces = {MediaType.APPLICATION_JSON_VALUE})
public class RoomController {


    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    @ResponseBody
    public List<Room> findAll() {
        return roomService.findAll();
    }

    @SuppressWarnings("unchecked")
	@GetMapping("/{id}")
    @ResponseBody
    public List<Room> findById(@PathParam("id") Long id) {
        return (List<Room>) roomService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public Room save(@RequestBody Room room) {
        return roomService.save(room);
    }

    @PutMapping("/{id}")
    public void update(Room room, @PathParam("id") Long id) {
    	roomService.update(room, id);
    }

    @DeleteMapping("/{id}")
    public void update(@PathParam("id") Long id) {
    	roomService.delete(id);
    }
}
