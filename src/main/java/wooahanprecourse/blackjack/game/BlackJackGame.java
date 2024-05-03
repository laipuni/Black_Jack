package wooahanprecourse.blackjack.game;

import wooahanprecourse.blackjack.domain.bettingMoney.BettingMoney;
import wooahanprecourse.blackjack.domain.card.CardDeck;
import wooahanprecourse.blackjack.domain.participant.Dealer;
import wooahanprecourse.blackjack.domain.participant.Player;
import wooahanprecourse.blackjack.domain.participant.Players;
import wooahanprecourse.blackjack.view.InputView;
import wooahanprecourse.blackjack.view.OutPutView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackJackGame {
    public void startGame(){
        CardDeck deck = CardDeck.createDeck();
        //플레이어들 이름 입력
        Dealer dealer = new Dealer();
        Players players = createPlayer();
        //각각에 플레이어들 배팅 금액을 입력
        List<Player> playerList = players.getPlayers();
        Map<Player, BettingMoney> bettingMoneyMap = createBettingMapBy(playerList);
        //딜러와 플레이어들에게 카드 2장을 나누어 준다.
        dealer.addCard(deck.draw(), deck.draw());
        playerList.forEach(player -> player.addCard(deck.draw(),deck.draw()));
        //첫 결과를 확인
        judgeFirstResult(dealer, playerList);
        //각각의 참가자들의 카드를 보여준다.
        dealer.showCards();
        playerList.forEach(Player::showCards);
        //각각의 플레이어들에게 카드를 더 받을지 묻는다.
        playerList.forEach(player -> {
            inputReceiveCardCommandRecursive(deck,player);
            player.showCards();
        });
        //딜러가 16이하일 경우는 카드한장을 받고, 17이상일 경우는 받지않는다.
        if(dealer.canDrawCard()){
            dealer.addCard(deck.draw());
        }
        //최종결과를 출력한다.
        dealer.showFinalResult();
        playerList.forEach(Player::showFinalResult);
        //최종 심판
        finalResult(playerList,dealer);
        //최종 배팅금액 출력
        OutPutView.printFinalResult(dealer,playerList);
    }

    private static Map<Player, BettingMoney> createBettingMapBy(final List<Player> playerList) {
        Map<Player, BettingMoney> bettingMoneyMap = new HashMap<>();
        for (Player player : playerList) {
            OutPutView.printBettingMoneyMassage(player.getName());
            BettingMoney bettingMoney = BettingMoney.of(InputView.InputBettingMoney());
            player.bet(bettingMoney);
            bettingMoneyMap.put(player,bettingMoney);
        }
        return bettingMoneyMap;
    }

    private void finalResult(final List<Player> players, final Dealer dealer) {
        players.forEach(player -> judgeScoreResult(player,dealer));
    }


    private static void judgeFirstResult(final Dealer dealer, final List<Player> playerList) {
        //딜러가 블랙잭을 가졌는지 확인한다.
        playerList.forEach(player -> {
            judgeFirstTurnDealerWin(dealer,player);
            judgeFirstTurnPlayerWin(dealer,player);
        });
    }

    private static void judgeFirstTurnPlayerWin(final Dealer dealer,final Player player){
        if(player.isBlackJack() && !dealer.isBlackJack()){
            dealer.loseMoney(BettingMoney.of(player.getMoney()));
            player.winBonusMoney();
        }
    }

    private static void judgeFirstTurnDealerWin(final Dealer dealer,final Player player){
        if(!player.isBlackJack() && dealer.isBlackJack()){
            dealer.winMoney(BettingMoney.of(player.getMoney()));
            player.loseMoney();
        }
    }

    private void judgeScoreResult(final Player player, final Dealer dealer){
        if(player.isBlackJack() && dealer.isBlackJack()){
            player.resetMoney();
            return;
        }

        judgeDealerWin(player, dealer);
        judgePlayerWin(player, dealer);
    }

    private static void judgePlayerWin(final Player player, final Dealer dealer) {
        //플레이어가 이긴 경우
        if(player.isBlackJack()
                || (!player.isBust() && player.getTotalPoint() > dealer.getTotalPoint())
                || (dealer.isBust() && !player.isBust())
        ){
            player.winMoney();
            dealer.loseMoney(BettingMoney.of(player.getMoney()));
        }
    }

    private static void judgeDealerWin(final Player player, final Dealer dealer) {
        //딜러가 이긴 경우
        if(dealer.isBlackJack()
                || (!dealer.isBust() && dealer.getTotalPoint() > player.getTotalPoint())
                || player.isBust()
        ){
            dealer.winMoney(BettingMoney.of(player.getMoney()));
            player.loseMoney();
        }
    }

    private static void inputReceiveCardCommandRecursive(CardDeck deck,Player player){
        if(canNotDrawACard(player)){
            return;
        }
        player.addCard(deck.draw());
        inputReceiveCardCommandRecursive(deck,player);
    }

    private static boolean canNotDrawACard(Player player) {
        return !player.canDrawCard() || player.isBust();
    }

    private static Players createPlayer() {
        OutPutView.printPlayerNameMassage();
        String playerName = InputView.InputPlayerName();
        return new Players(playerName);
    }
}
