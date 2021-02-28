package br.com.sl3v1.challengeselection.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {
        return (List<Room>) roomRepository.findAll();
    }

    public Room findById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public Room save(Room room) {
        room.setLotation(0);
        return roomRepository.save(room);
    }

    public void update(Room room, Long id) throws Exception {

        Optional<Room> roomOptional = roomRepository.findById(id);

        if(roomOptional.isPresent()){
            Room roomDb = roomOptional.get();
            roomDb.setName(room.getName());
            roomDb.setCapacity(room.getCapacity());
            roomRepository.save(roomDb);
        }else{
            throw new Exception("Sala com o id: " + id + " informado não encontrado!");
        }
    }

    public void delete(Long id) {
        roomRepository.deleteById(id);
    }

    public Room getMinLotation() {
        return roomRepository.getMinLotation();
    }

}

