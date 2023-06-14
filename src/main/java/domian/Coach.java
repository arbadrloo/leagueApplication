package domian;


import lombok.*;

import javax.persistence.DiscriminatorValue;

@Getter
@Setter
@DiscriminatorValue("COACH")
public class Coach extends TeamEmployee{

    public Coach() {
    }
}
