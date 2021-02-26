package br.com.sl3v1.challengeselection.room;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
	
	@Query("select min(r.lotation) from Room r")
    Room getMinLotation();

}
