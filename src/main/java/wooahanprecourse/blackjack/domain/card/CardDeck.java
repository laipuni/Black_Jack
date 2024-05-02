package wooahanprecourse.blackjack.domain.card;

import wooahanprecourse.blackjack.domain.card.Card;

import java.util.*;

public class CardDeck {

    private Stack<Card> deck;

    private CardDeck(Stack<Card> deck) {
        this.deck = deck;
    }

    public static CardDeck createDeck(){
        Stack<Card> deck = createDeckBy();
        Collections.shuffle(deck);
        return new CardDeck(deck);
    }

    private static Stack<Card> createDeckBy() {
        Stack<Card> cardStack = new Stack<>();
        List<CardPattern> patters = CardPattern.getValues();
        List<CardDenomination> denominations = CardDenomination.getValues();
        for (CardPattern pattern : patters) {
            cardStack.addAll(createCards(pattern, denominations));
        }
        return cardStack;
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
