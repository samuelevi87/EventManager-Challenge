package br.com.sl3v1.challengeselection.people;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import br.com.sl3v1.challengeselection.room.Room;
import br.com.sl3v1.challengeselection.room.RoomRepository;
import br.com.sl3v1.challengeselection.room.RoomService;

@Service
public class PeopleService {

    private PeopleRepository repository;
    private RoomService roomService;

    @Autowired
    public PeopleService(PeopleRepository repository) {
        this.repository = repository;
    }

    public List<People> findAll() {
        return (List<People>) repository.findAll();
    }

    public People findById(Long id) {
        return repository.findById(id).orElse(null);
        
    }

    public People save(People people) {
//   	if (!(roomService.findAll().isEmpty())) {
//    		    @Query(value = "SELECT ID FROM TB_ROOM WHERE CAPACITY = (SELECT MIN(CAPACITY) FROM TB_ROOM", nativeQuery = true)
//        public Room findMinorCapacity() {
//    		return Room;
//    	}
//    		
//    		System.out.println("Cadastro Salvo ");
//    	}
//    	else {
//    		System.out.println();
//    	}
    	// buscar a sala com menor lotação
    	
    	//people.set
    	
    	// setar a sala na pessoa
    	// salvar a pessoa com a sala
    	
    	// fazer os mesmos passos acima com o café 
    	
// */   	
    	return this.repository.save(people);
    }
    
//    public People testRoom() {
//    	RoomRepository roomRepository;
//    	List<Room> list =  roomRepository.findAll();
//    	Stream(Room) sortedList = list.stream()
//    }

    public void update(People people, Long id) {
        this.repository.save(people);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
    
//    public List<Room> gerarTurmas() {
//    	
//    	List<Room> rooms = roomService.findAll();
//    	List<People> persons = peopleService.findAll();
//    	
//    	int qtdAlunosSala = 0;
//    	
//    	if((rooms != null && !rooms.isEmpty()) && (persons != null && !persons.isEmpty())) {	
//    		qtdAlunosSala = persons.size() / rooms.size();
//    	}
//    	
//    	for (Room room : rooms) {
//    		List<People> personsOfRoom1 = persons.subList(0, qtdAlunosSala);
//    		room.getPeopleList(personsOfRoom1)
//			
//		}
//    	
//    	// TODO montar lógica para popular a salas
//    	
//    	
//		
//		// TODO busca as salas - OK
//		// TODO busca as pessoas - OK
//		// TODO divide as pessoas pelas salas
//		// TODO retorna as salas com as pessoas
//		
//		return null;
//	}
    
    
}	

