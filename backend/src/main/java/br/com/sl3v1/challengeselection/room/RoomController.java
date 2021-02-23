package br.com.sl3v1.challengeselection.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api/v1/room", produces = { MediaType.APPLICATION_JSON_VALUE })
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
	public List<Room> findById(@PathVariable("id") Long id) {
		return (List<Room>) roomService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Room> save(@RequestBody Room room) {
		return ResponseEntity.ok(roomService.save(room));
	}

	@PutMapping("/")
	public ResponseEntity<Room> update(@RequestBody Room room) {
		Room roomSaved = roomService.save(room);
		return new ResponseEntity<Room>(roomSaved, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void update(@PathVariable("id") Long id) {
		roomService.delete(id);
	}

}
