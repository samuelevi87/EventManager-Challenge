package br.com.sl3v1.challengeselection.room;

import java.util.List;

																																				import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private RoomRepository repository;

    @Autowired
    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public List<Room> findAll() {
        return (List<Room>) repository.findAll();
    }

    public Room findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Room save(Room room) {
        return repository.save(room);
    }

    public void update(Room room, Long id) {
        repository.save(room);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    
//    public Room findMinorCapacity() {
//    	return repository.findById(null)
//    }
}	

