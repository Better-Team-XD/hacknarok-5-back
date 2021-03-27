package pl.teamxd.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.teamxd.model.entity.Location;
import pl.teamxd.model.entity.Place;
import pl.teamxd.repository.IMyUserRepository;
import pl.teamxd.repository.IPlaceRepository;
import pl.teamxd.model.entity.MyUser;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class MockData {
    private final IMyUserRepository userRepository;
    private final IPlaceRepository placeRepository;

    @PostConstruct
    public void generate(){
        userRepository.save(new MyUser("Krzysztof Nalepa","misiek.nalepa@wp.pl", "alamakota"));

        for (int i = 1; i <= 10; i++) {
            Location location = new Location(i, i);
            var place = new Place("Place " + i, location);

            placeRepository.save(place);
        }

    }
}
