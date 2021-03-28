package pl.teamxd.model.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import pl.teamxd.model.entity.Event;
import pl.teamxd.model.entity.Location;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceResponse {
    private Long id;

    private String name;

    private String imageUrl;

    private Location location;

    private String description;

    private double distance;

    private Set<Event> events = new HashSet<>();
}
