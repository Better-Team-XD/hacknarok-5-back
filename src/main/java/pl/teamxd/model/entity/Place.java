package pl.teamxd.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @Embedded
    private Location location;

    private String description = "";

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Event> events = new HashSet<>();

    public void addEvent(Event event) {
        events.add(event);
    }
}
