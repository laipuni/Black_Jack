package wooahanprecourse.blackjack.game;

import wooahanprecourse.blackjack.domain.bettingMoney.BettingMoney;
import wooahanprecourse.blackjack.domain.card.CardDeck;
import wooahanprecourse.blackjack.domain.participant.Dealer;
import wooahanprecourse.blackjack.domain.participant.Player;
import wooahanprecourse.blackjack.domain.participant.Players;

import java.util.List;

public class DeckManager {

    private final CardDeck deck;
    
    private DeckManager(CardDeck deck) {
        this.deck = deck;
    }

    public static DeckManager create(){
        CardDeck deck = CardDeck.createDeck();
        return new DeckManager(deck);
    }

    public void giveTwoCardToParticipants(final Players players, final Dealer dealer){
        //딜러와 플레이어들에게 카드 2장을 나누어 준다.
        dealer.addCard(deck.draw(), deck.draw());
        players.getPlayers().forEach(player -> player.addCard(deck.draw(),deck.draw()));
    }

    public void giveExtraCard(final Players players, final Dealer dealer){
        players.getPlayers().forEach(player -> {
            inputReceiveCardCommandRecursive(player);
            player.showCards();
        });
        //딜러가 16이하일 경우는 카드 한장을 받고, 17이상일 경우는 받지 않는다.
        if(dealer.canDrawCard()){
            dealer.addCard(deck.draw());
        }
    }

    private void inputReceiveCardCommandRecursive(Player player){
        if(canNotDrawACard(player)){
            return;
        }
        player.addCard(deck.draw());
        inputReceiveCardCommandRecursive(player);
    }

    private boolean canNotDrawACard(Player player) {
        return !player.canDrawCard() || player.isBust();
    }

}
