package domian;

import base.domain.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = TeamEmployee.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EMPLOYEE_TYPE", discriminatorType = DiscriminatorType.STRING)

public class TeamEmployee extends BaseEntity<Long> {

    public static final String TABLE_NAME = "employees";

    public static final String FIRST_NAME = "FIRST_NAME";
    public static final String LAST_NAME = "LAST_NAME";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";
    public static final String SALARY = "SALARY";

    @Column(name = FIRST_NAME)
    String firstName;
    @Column(name = LAST_NAME)
    String lastName;
    @Column(name = USERNAME)
    String username;
    @Column(name = PASSWORD)
    String password;
    @Column(name = SALARY)
    Double salary;


    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    Team team;

    @ManyToMany(mappedBy = "employees")
    private Set<MatchLineup> matchLineups;


}
