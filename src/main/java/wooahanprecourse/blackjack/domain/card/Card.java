package wooahanprecourse.blackjack.domain.card;

public class Card {

    private CardPattern pattern;
    private CardDenomination denomination;

    public Card(CardPattern pattern, CardDenomination denomination) {
        this.pattern = pattern;
        this.denomination = denomination;
    }

}
