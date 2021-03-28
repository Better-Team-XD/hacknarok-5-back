package pl.teamxd.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.teamxd.model.entity.Event;
import pl.teamxd.model.entity.Location;
import pl.teamxd.model.entity.Place;
import pl.teamxd.repository.IEventRepository;
import pl.teamxd.repository.IMyUserRepository;
import pl.teamxd.repository.IPlaceRepository;
import pl.teamxd.model.entity.MyUser;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class MockData {
    private final IMyUserRepository userRepository;
    private final IPlaceRepository placeRepository;
    private final IEventRepository eventRepository;

    @PostConstruct
    public void generate(){
        userRepository.save(new MyUser("Krzysztof Nalepa","misiek.nalepa@wp.pl", "alamakota"));

        for (int i = 1; i <= 100; i++) {
            Location location = new Location((double)i/10, (double)i/10, "Kraków", "Długa");
            var place = new Place("Place " + i, "https://www.rp.pl/apps/pbcsi.dll/storyimage/RP/20201019/PCD/310199909/AR/0/AR-310199909.jpg?imageversion=Artykul&lastModified=", location);
            var event = new Event("Event " + i, i+"-"+i+"-"+"2021", "12:00", place);
            place.addEvent(event);
            eventRepository.save(event);
            placeRepository.save(place);
        }

    }
}
