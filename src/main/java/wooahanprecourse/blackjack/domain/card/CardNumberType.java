package wooahanprecourse.blackjack.domain.card;

public enum CardNumberType {

    TWO(2,"2"),
    THREE(3,"3"),
    FOUR(4,"4"),
    FIVE(5,"5"),
    SIX(6,"6"),
    SEVEN(7,"7"),
    EIGHT(8,"8"),
    NINE(9,"9"),
    TEN(10,"T"),
    KING(10,"K"),
    QUEEN(10,"Q"),
    JACK(10,"J"),
    A(11,"A");


    private final int point;
    private final String name;

    CardNumberType(int point, String name) {
        this.point = point;
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }
}
