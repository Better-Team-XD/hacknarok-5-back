package pl.teamxd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.teamxd.model.entity.Place;
import pl.teamxd.repository.IPlaceRepository;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final IPlaceRepository placeRepository;

    // TODO consider location
    public Page<Place> getAll(
            Integer page,
            Integer size,
//            String name,
//            String date,
            String sortBy,
            Boolean asc
    ) {
//        Place examplePlace = new Place(name)
        var direction = asc ? Sort.Direction.ASC : Sort.Direction.DESC;
        var pageable = PageRequest.of(page, size, direction, sortBy);
        return placeRepository.findAll(pageable);
    }
}
