package pl.teamxd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.teamxd.model.entity.Place;
import pl.teamxd.repository.IPlaceRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final IPlaceRepository placeRepository;

    public Page<Place> getAll(
            Integer page,
            Integer size,
            String sortBy,
            Boolean asc,
            Optional<Double> lon,
            Optional<Double> lat,
            Double rad
    ) {
        var direction = asc ? Sort.Direction.ASC : Sort.Direction.DESC;
        var pageable = PageRequest.of(page, size, direction, sortBy);
        return placeRepository.findAllPlacesWithPagination(lon.orElseThrow(IllegalArgumentException::new), lat.orElseThrow(IllegalArgumentException::new), rad, pageable);
    }
}
