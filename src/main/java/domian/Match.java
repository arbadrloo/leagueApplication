package domian;

import base.domain.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = Match.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Match extends BaseEntity<Long> {
    public static final String TABLE_NAME = "matches";

    public static final String GOALS = "GOALS";

    @Column(name = GOALS)
    @OneToMany(mappedBy = "match")
    List<Goal> goals = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "team1_id")
    Team team1;

    @ManyToOne
    @JoinColumn(name = "team2_id")
    Team team2;

    @OneToOne(mappedBy = "match")
    MatchLineup MatchLineupTeam1;

    @OneToOne(mappedBy = "match")
    MatchLineup MatchLineupTeam2;

    @ManyToOne
    @JoinColumn(name = "stadium_id")
    Stadium stadium;
}
