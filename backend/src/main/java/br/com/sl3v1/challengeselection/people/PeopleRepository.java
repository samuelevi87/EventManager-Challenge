package br.com.sl3v1.challengeselection.people;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends CrudRepository<People, Long> {

    List<People> findByRoomId(Long roomId);

    List<People> findByCoffeeId(Long coffeeId);
}
