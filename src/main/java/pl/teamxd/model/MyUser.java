package pl.teamxd.model;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @ManyToMany
    private Set<Place> favouritePlaces = new HashSet<>();

    @OneToMany
    private Set<Place> myPlaces = new HashSet<>(); // places I 'own'
}
