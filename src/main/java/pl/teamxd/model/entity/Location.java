package pl.teamxd.model.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Embeddable
public class Location {

    @NonNull
    private double lon;

    @NonNull
    private double lat;

    @NonNull
    private String city;

    @NonNull
    private String street;
}
