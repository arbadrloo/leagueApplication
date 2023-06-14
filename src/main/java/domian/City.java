package domian;

import base.domain.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = City.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class City extends BaseEntity <Integer> {

    public static final String TABLE_NAME = "cities";

    public static final String NAME = "NAME";
    public static final String TEAMS = "TEAMS";
    public static final String STADIUMS = "STADIUMS";

    @Column(name = NAME)
    String name;

    @Column(name = TEAMS)
    @OneToMany(mappedBy = "city")
    List<Team> teams;

    @Column(name = STADIUMS)
    @OneToMany(mappedBy = "city")
    List<Stadium> stadiums;




}
