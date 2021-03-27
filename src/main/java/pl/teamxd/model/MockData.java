package pl.teamxd.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.teamxd.repository.ILocationRepository;
import pl.teamxd.repository.IMyUserRepository;
import pl.teamxd.repository.IPlaceRepository;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class MockData {
    private final IMyUserRepository userRepository;
    private final IPlaceRepository placeRepository;
    private final ILocationRepository locationRepository;

    @PostConstruct
    public void generate(){
        userRepository.save(new MyUser());

        for (int i = 1; i <= 10; i++) {
            Location location = new Location(i, i);
            var place = new Place("Place " + i, location);
            locationRepository.save(location);
            placeRepository.save(place);
        }

    }
}
