package domian;


import lombok.*;

import javax.persistence.DiscriminatorValue;

@Getter
@Setter
@DiscriminatorValue("PLAYER")
public class Player extends TeamEmployee{

    public Player() {
    }
}
