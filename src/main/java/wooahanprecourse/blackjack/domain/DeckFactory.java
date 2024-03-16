package wooahanprecourse.blackjack.domain;

import wooahanprecourse.blackjack.domain.card.Card;
import wooahanprecourse.blackjack.domain.card.CardNumberType;
import wooahanprecourse.blackjack.domain.card.CardType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeckFactory {

    public static Deck createDeck(){
        CardNumberType[] cardNumberTypes = CardNumberType.values();
        CardType[] cardTypes = CardType.values();
        List<Card> deck = new ArrayList<>();

        for (CardType cardType : cardTypes) {
            List<Card> cards = createCards(cardType, cardNumberTypes);
            deck.addAll(cards);
        }

        return new Deck(deck);
    }

    private static List<Card> createCards(CardType cardType, CardNumberType[] cardNumberTypes) {
        return Arrays.stream(cardNumberTypes)
                .map(t -> new Card(t,cardType))
                .toList();
    }

}
