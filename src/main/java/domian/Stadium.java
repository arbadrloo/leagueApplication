package domian;

import base.domain.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Stadium.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Stadium extends BaseEntity<Integer> {

    public static final String TABLE_NAME = "stadiums";

    public static final String NAME = "NAME";
    public static final String CITY = "CITY";

    @Column(name = NAME)
    String name;

    @Column(name = CITY)
    @ManyToOne
    @JoinColumn(name = "city_id")
    City city;


}
