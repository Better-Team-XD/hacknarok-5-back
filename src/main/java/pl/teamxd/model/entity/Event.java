package pl.teamxd.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String date;

    private String hour;

    private String description;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Place place;

    public Event(String name, String date, String hour, Place place) {
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.place = place;
        place.addEvent(this);
    }
}
