package wooahanprecourse.blackjack.domain.card;

import java.util.Arrays;
import java.util.List;

public enum CardDenomination {

    A(10,"A"),
    TWO(2,"2"),
    THREE(3,"3"),
    FOUR(4,"4"),
    FIVE(5,"5"),
    SIX(6,"6"),
    SEVEN(7,"7"),
    EIGHT(8,"8"),
    NINE(9,"9"),
    TEN(10,"10"),
    KING(10,"k"),
    QUEEN(10,"q"),
    JACK(10,"j");

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
