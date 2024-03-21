package wooahanprecourse.blackjack.domain.card;

import wooahanprecourse.blackjack.domain.card.Card;

import java.util.*;

public class CardDeck {

    private Stack<Card> deck;

    public CardDeck() {
        deck = createDeck();
        cardShuffle();
    }

    private void cardShuffle() {
        Collections.shuffle(deck);
    }

    private Stack<Card> createDeck(){
        Stack<Card> deck = new Stack<>();
        List<CardPattern> patters = CardPattern.getValues();
        List<CardDenomination> denominations = CardDenomination.getValues();

        for (CardPattern pattern : patters) {
            deck.addAll(createCards(pattern, denominations));
        }

        return deck;
    }

    private static Stack<Card> createCards(CardPattern pattern, List<CardDenomination> denominations) {
        Stack<Card> deck = new Stack<>();
        for (CardDenomination denomination : denominations) {
            deck.push(new Card(pattern,denomination));
        }

        return deck;
    }

    public Card draw(){
        return deck.pop();
    }

    public int getSize(){
        return deck.size();
    }
}
