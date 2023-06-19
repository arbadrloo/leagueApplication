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

    public static final String TEAM_UU = "TEAM_UU";
    public static final String NAME = "NAME";
    public static final String CITY = "CITY";
    public static final String TOTAL_SCORE = "TOTAL_SCORE";
    public static final String TEAM_EMPLOYEE = "TEAM_EMPLOYEE";

    @Column(name = TEAM_UU)
    String TeamUu;

    @Column(name = NAME)
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;


    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Set<TeamEmployee> teamEmployees;

    @Column(name = TOTAL_SCORE)
    int totalScore;



    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    Set<Match> matches;

}
