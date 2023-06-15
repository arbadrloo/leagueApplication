package domian;

import base.domain.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = Team.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Team extends BaseEntity<Integer> {

    public static final String TABLE_NAME = "teams";

    public static final String TEAM_ID = "TEAM_ID";
    public static final String NAME = "NAME";
    public static final String CITY = "CITY";
    public static final String TOTAL_SCORE = "TOTAL_SCORE";

    @Column(name = TEAM_ID)
    String TeamId;

    @Column(name = NAME)
    String name;

    @Column(name = CITY)
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = TOTAL_SCORE)
    int totalScore;

    @OneToMany(mappedBy = "team1")
    private Set<Match> homeMatches;

    @OneToMany(mappedBy = "team2")
    private Set<Match> awayMatches;

}
