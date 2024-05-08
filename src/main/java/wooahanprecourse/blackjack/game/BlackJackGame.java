package wooahanprecourse.blackjack.game;

import wooahanprecourse.blackjack.domain.bettingMoney.BettingMoney;
import wooahanprecourse.blackjack.domain.participant.Dealer;
import wooahanprecourse.blackjack.domain.participant.Player;
import wooahanprecourse.blackjack.domain.participant.Players;
import wooahanprecourse.blackjack.view.InputView;
import wooahanprecourse.blackjack.view.OutPutView;

import java.util.HashMap;
import java.util.Map;

public class BlackJackGame {

    private BettingMoneyManager bettingMoneyManager;

    public void startGame(){
        final Dealer dealer = new Dealer();
        final Players players = createPlayer();
        DeckManager deckManager = DeckManager.create();
        final Map<Player, BettingMoney> bettingMoneyMap = createBettingMapBy(players);
        this.bettingMoneyManager = new BettingMoneyManager(bettingMoneyMap);
        deckManager.giveTwoCardToParticipants(players,dealer);
        judgeFirstResult(dealer,players);
        showCardParticipants(players,dealer);
        deckManager.giveExtraCard(players,dealer);
        showFinalResult(dealer, players);
        finalresult(players,dealer);
        OutPutView.printFinalResult(dealer,players.getPlayers());
    }

    private static Map<Player, BettingMoney> createBettingMapBy(final Players players) {
        Map<Player, BettingMoney> bettingMoneyMap = new HashMap<>();
        for (Player player : players.getPlayers()) {
            OutPutView.printBettingMoneyMassage(player.getName());
            BettingMoney bettingMoney = BettingMoney.of(InputView.InputBettingMoney());
            player.bet(bettingMoney);
            bettingMoneyMap.put(player,bettingMoney);
        }
        return bettingMoneyMap;
    }

    private Players createPlayer() {
        OutPutView.printPlayerNameMassage();
        String playerName = InputView.InputPlayerName();
        return new Players(playerName);
    }

    private void showCardParticipants(final Players players, final Dealer dealer){
        dealer.showCards();
        players.getPlayers().forEach(Player::showCards);
    }

    private void showFinalResult(final Dealer dealer, final Players players) {
        dealer.showFinalResult();
        players.getPlayers().forEach(Player::showFinalResult);
    }

    public void judgeFirstResult(final Dealer dealer, final Players players) {
        //딜러가 블랙잭을 가졌는지 확인한다.
        players.getPlayers().forEach(player -> {
            bettingMoneyManager.judgeFirstTurnDealerWin(dealer, player);
            bettingMoneyManager.judgeFirstTurnPlayerWin(dealer, player);
        });
    }

    private void finalresult(final Players players, final Dealer dealer) {
        players.getPlayers().forEach(player -> judgeScoreResult(player, dealer));
    }

    private void judgeScoreResult(final Player player, final Dealer dealer) {
        if (player.isBlackJack() && dealer.isBlackJack()) {
            player.resetMoney();
            return;
        }

        bettingMoneyManager.judgeDealerWin(player, dealer);
        bettingMoneyManager.judgePlayerWin(player, dealer);
    }
}
