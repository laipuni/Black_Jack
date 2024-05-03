package wooahanprecourse.blackjack.game;

import wooahanprecourse.blackjack.domain.bettingMoney.BettingMoney;
import wooahanprecourse.blackjack.domain.card.CardDeck;
import wooahanprecourse.blackjack.domain.participant.Dealer;
import wooahanprecourse.blackjack.domain.participant.Participant;
import wooahanprecourse.blackjack.domain.participant.Player;
import wooahanprecourse.blackjack.domain.participant.Players;

import java.util.List;

public class GameManager {

    private final CardDeck deck;
    
    private GameManager(CardDeck deck) {
        this.deck = deck;
    }

    public static GameManager create(){
        CardDeck deck = CardDeck.createDeck();
        return new GameManager(deck);
    }

    public void giveTwoCardToParticipants(final List<Player> players, final Dealer dealer){
        //딜러와 플레이어들에게 카드 2장을 나누어 준다.
        dealer.addCard(deck.draw(), deck.draw());
        players.forEach(player -> player.addCard(deck.draw(),deck.draw()));
    }

    public void judgeFirstResult(final Dealer dealer, final List<Player> playerList) {
        //딜러가 블랙잭을 가졌는지 확인한다.
        playerList.forEach(player -> {
            judgeFirstTurnDealerWin(dealer,player);
            judgeFirstTurnPlayerWin(dealer,player);
        });
    }

    public void judgeFirstTurnPlayerWin(final Dealer dealer,final Player player){
        if(player.isBlackJack() && !dealer.isBlackJack()){
            dealer.loseMoney(BettingMoney.of(player.getMoney()));
            player.winBonusMoney();
        }
    }

    public void judgeFirstTurnDealerWin(final Dealer dealer,final Player player){
        if(!player.isBlackJack() && dealer.isBlackJack()){
            dealer.winMoney(BettingMoney.of(player.getMoney()));
            player.loseMoney();
        }
    }
    
}
