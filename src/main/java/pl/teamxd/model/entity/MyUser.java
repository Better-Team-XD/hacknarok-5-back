package pl.teamxd.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String email;

    private String password;

    @Embedded
    private Address address;

    @ManyToMany
    private Set<Place> favouritePlaces = new HashSet<>();

    @OneToMany
    private Set<Place> myPlaces = new HashSet<>(); // places I 'own'

    public MyUser(String name, String email, String city, String street, String zip) {
        this.name = name;
        this.email = email;
        this.address = new Address(city, street, zip);
    }

    public MyUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
