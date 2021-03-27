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
    private Long id;

    private String name;

    private String email;

    private String password;

    @ManyToMany
    private Set<Place> favouritePlaces = new HashSet<>();

    @OneToMany
    private Set<Place> myPlaces = new HashSet<>(); // places I 'own'

    public MyUser(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
