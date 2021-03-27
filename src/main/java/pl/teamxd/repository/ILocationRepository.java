package pl.teamxd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.teamxd.model.entity.Location;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Long> {
}
