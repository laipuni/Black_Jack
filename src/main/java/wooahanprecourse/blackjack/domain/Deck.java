package wooahanprecourse.blackjack.domain;

import wooahanprecourse.blackjack.domain.card.Card;

import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> deck;

    public Deck(List<Card> deck) {
        this.deck = deck;
        shuffleCards();
    }

    private void shuffleCards(){
        Collections.shuffle(deck);
    }

    public Card takeOneCard(){
        return deck.get(0);
    }
}
