package wooahanprecourse.blackjack.domain.card;

import java.util.Arrays;
import java.util.List;

public enum CardDenomination {

    A(1,"A"),
    ONE(1,"1"),
    TWO(1,"2"),
    THREE(1,"3"),
    FOUR(1,"4"),
    FIVE(1,"5"),
    SIX(1,"6"),
    SEVEN(1,"7"),
    EIGHT(1,"8"),
    NINE(1,"9"),
    TEN(1,"10"),
    KING(1,"k"),
    QUEEN(1,"q"),
    JACK(1,"j");

    private int point;
    private String name;

    CardDenomination(int point, String name) {
        this.point = point;
        this.name = name;
    }

    public static List<CardDenomination> getValues(){
        return Arrays.asList(CardDenomination.values());
    }
}
