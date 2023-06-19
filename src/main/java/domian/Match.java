package domian;

import base.domain.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

//    @Column(name = GOALS)
    @OneToMany(mappedBy = "match")
    List<Goal> goals = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "team_id")
    Team team;


    @OneToMany(mappedBy = "match")
    Set<MatchLineup> matchLineups = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "stadium_id")
    Stadium stadium;
}
