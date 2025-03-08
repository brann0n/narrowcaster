package nl.ba99.narrowcaster.repositories;

import nl.ba99.narrowcaster.models.SlideshowVariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlideshowVariableRepository extends JpaRepository<SlideshowVariable, Long> {
}
