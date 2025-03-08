package nl.ba99.narrowcaster.repositories;

import nl.ba99.narrowcaster.models.MediaSlide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaSlideRepository extends JpaRepository<MediaSlide, Long> {
}
