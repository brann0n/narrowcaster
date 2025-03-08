package nl.ba99.narrowcaster.repositories;

import nl.ba99.narrowcaster.models.TextSlide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextSlideRepository extends JpaRepository<TextSlide, Long> {
}
