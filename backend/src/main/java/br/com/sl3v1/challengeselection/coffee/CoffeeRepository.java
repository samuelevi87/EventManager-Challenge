package br.com.sl3v1.challengeselection.coffee;

import br.com.sl3v1.challengeselection.room.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
    @Query("select min(c.lotation) from Coffee c")
    Coffee getMinLotation();
}
