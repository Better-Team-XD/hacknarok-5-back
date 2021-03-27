package pl.teamxd.model;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String city;

    private String street;

    private String zip;
}
