package nl.ba99.narrowcaster.repositories;

import nl.ba99.narrowcaster.models.ConsultationHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationHourRepository extends JpaRepository<ConsultationHour, Long> {
}
