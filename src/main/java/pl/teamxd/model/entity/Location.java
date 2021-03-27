package pl.teamxd.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private double lon;

    @NonNull
    private double lat;

    @NonNull
    private String city;

    @NonNull
    private String street;

    @NonNull
    private String imageUrl;
}
