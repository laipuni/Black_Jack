package wooahanprecourse.blackjack.domain;

import wooahanprecourse.blackjack.domain.card.CardDeck;
import wooahanprecourse.blackjack.domain.participant.Participant;

import java.util.List;

public class GameManager {

    private final CardDeck deck;
    private final Participant participant;

    private GameManager(CardDeck deck, Participant participant) {
        this.deck = deck;
        this.participant = participant;
    }

    public static GameManager of(CardDeck deck, Participant participant){
        return new GameManager(deck, participant);
    }

    public void giveTwoCardToParticipants(List<Participant> participants, CardDeck deck){
        participants.forEach(participant ->
                        participant.addCard(deck.draw(),deck.draw()));
    }

}
