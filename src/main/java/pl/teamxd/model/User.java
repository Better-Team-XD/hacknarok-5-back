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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String email;

    @Embedded
    private Address address;

    @ManyToMany
    private Set<Place> favouritePlaces = new HashSet<>();

    @OneToMany
    private Set<Place> myPlaces = new HashSet<>(); // places I 'own'

    public User(String name, String email, String city, String street, String zip) {
        this.name = name;
        this.email = email;
        this.address = new Address(city, street, zip);
    }
}
