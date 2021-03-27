package pl.teamxd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.teamxd.model.Place;

@Repository
public interface IPlaceRepository extends JpaRepository<Place, Long> {
}
