package pl.teamxd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.teamxd.model.entity.Place;


@Repository
public interface IPlaceRepository extends JpaRepository<Place, Long> {
    @Query( // TODO improve
            value = "select * from place p where sqrt((p.lon-?1)*(p.lon-?1)+(p.lat-?2)*(p.lat-?2)) < ?3",
            countQuery = "select count * from place",
            nativeQuery = true
    )
    Page<Place> findAllPlacesWithPagination(Double lon, Double lat, Double rad, Pageable pageable);
}
