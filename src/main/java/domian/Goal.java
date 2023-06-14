package domian;

import base.domain.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = Goal.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Goal extends BaseEntity<Long> {

    public static final String TABLE_NAME = "goals";

    public static final String MATCH = "MATCH";
    public static final String TEAM_EMPLOYEE = "TEAM_EMPLOYEE";
    public static final String SCORE_TIME = "SCORE_TIME";

    @ManyToOne
    @JoinColumn(name = "match_id")
    @Column(name = MATCH)
    Match match;

    @ManyToOne
    @JoinColumn(name = "player_id")
    @Column(name = TEAM_EMPLOYEE)
    TeamEmployee player;

    @Column(name = SCORE_TIME)
    Integer scoreTime;

}
