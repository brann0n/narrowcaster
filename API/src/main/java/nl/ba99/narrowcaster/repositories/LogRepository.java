package nl.ba99.narrowcaster.repositories;

import nl.ba99.narrowcaster.models.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

}
