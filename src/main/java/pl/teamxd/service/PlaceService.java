package pl.teamxd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.teamxd.model.entity.Place;
import pl.teamxd.model.response.PlaceResponse;
import pl.teamxd.repository.IPlaceRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final IPlaceRepository placeRepository;

    public Page<PlaceResponse> getAll(
            Integer page,
            Integer size,
            String sortBy,
            Boolean asc,
            Optional<Double> lon,
            Optional<Double> lat,
            Double radius
    ) {
        var direction = asc ? Sort.Direction.ASC : Sort.Direction.DESC;
        var pageable = PageRequest.of(page, size, direction, sortBy);
        Double longitude = lon.orElseThrow(IllegalAccessError::new);
        Double latitude = lat.orElseThrow(IllegalAccessError::new);
        double tmp;
        List<Place> places = placeRepository.findAll();
        // TODO: move to sql query if only possible
        List<PlaceResponse> filteredPlaces = places.stream()
                .filter(place -> this.calculateDistance(place, longitude, latitude) <= radius)
                .map(place -> new PlaceResponse(
                        place.getId(),
                        place.getName(),
                        place.getImageUrl(),
                        place.getLocation(),
                        place.getDescription(),
                        calculateDistance(place, longitude, latitude),
                        place.getEvents())
                )
                .collect(Collectors.toList());

        int start = (int)pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), filteredPlaces.size());

        return new PageImpl<>(filteredPlaces.subList(start, end), pageable, places.size());
    }

    private double calculateDistance(Place place, double longitude, double latitude) {
        double theta = Math.abs(longitude - place.getLocation().getLon());
        double dist = Math.sin(Math.toRadians(latitude)) * Math.sin(Math.toRadians(place.getLocation().getLat())) +
                Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(place.getLocation().getLat())) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        return dist;
    }
}
