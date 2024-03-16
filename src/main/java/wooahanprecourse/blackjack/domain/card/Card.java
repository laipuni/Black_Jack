package wooahanprecourse.blackjack.domain.card;

public class Card {

    private CardNumberType numberType;
    private CardType cardType;

    public Card(CardNumberType numberType, CardType cardType) {
        this.numberType = numberType;
        this.cardType = cardType;
    }

    public CardNumberType getNumberType() {
        return numberType;
    }

    public CardType getCardType() {
        return cardType;
    }
}
