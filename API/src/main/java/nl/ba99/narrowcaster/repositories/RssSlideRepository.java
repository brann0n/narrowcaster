package nl.ba99.narrowcaster.repositories;

import nl.ba99.narrowcaster.models.RssSlide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RssSlideRepository extends JpaRepository<RssSlide, Long> {
}
