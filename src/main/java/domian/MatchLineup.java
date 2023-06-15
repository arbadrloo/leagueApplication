package domian;

import base.domain.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = MatchLineup.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class MatchLineup extends BaseEntity<Long> {

    public static final String TABLE_NAME = "match_lineUps";

    public static final String MATCH = "MATCH";

    @Column(name = MATCH)
    @OneToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @ManyToMany(mappedBy = "")
    @JoinTable(
            name = "match_lineup_players",
            joinColumns = @JoinColumn(name = "match_lineup_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    Set <TeamEmployee> team1Players;


}
