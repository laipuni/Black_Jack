package wooahanprecourse.blackjack.domain.card;

import java.util.Arrays;
import java.util.List;

public enum CardPattern {

    SPADE("스페이드"),
    HEART("하트"),
    CLOVER("클로버"),
    DIAMOND("다이아몬드");

    private String description;
    CardPattern(String description) {
        this.description = description;
    }

    public static List<CardPattern> getValues(){
        return Arrays.asList(CardPattern.values());
    }

    public String getDescription() {
        return description;
    }
}
