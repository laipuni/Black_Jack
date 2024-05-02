package wooahanprecourse.blackjack.domain;

import wooahanprecourse.blackjack.domain.bettingMoney.BettingMoney;
import wooahanprecourse.blackjack.domain.card.CardDeck;
import wooahanprecourse.blackjack.domain.participant.Dealer;
import wooahanprecourse.blackjack.domain.participant.Player;
import wooahanprecourse.blackjack.domain.participant.Players;
import wooahanprecourse.blackjack.domain.view.InputView;
import wooahanprecourse.blackjack.domain.view.OutPutView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public class BlackJackGame {
    public void startGame(){
        CardDeck deck = CardDeck.createDeck();

        //플레이어들 이름 입력
        Dealer dealer = new Dealer();
        Players players = createPlayer();

        //각각에 플레이어들 배팅 금액을 입력
        List<Player> playerList = players.getPlayers();
        Map<Player, BettingMoney> bettingMoneyMap = new HashMap<>();
        for (Player player : playerList) {
            OutPutView.printBettingMoneyMassage(player.getName());
            BettingMoney bettingMoney = new BettingMoney(InputView.InputBettingMoney());
            bettingMoneyMap.put(player,bettingMoney);
        }

        //딜러와 플레이어들에게 카드 2장을 나누어 준다.
        dealer.addCard(deck.draw(), deck.draw());
        playerList.forEach(player -> player.addCard(deck.draw(),deck.draw()));

        firstResult(dealer, playerList, bettingMoneyMap);

        //각각의 참가자들의 카드를 보여준다.
        dealer.showCards();
        playerList.forEach(Player::showCards);

        //각각의 플레이어들에게 카드를 더 받을지 묻는다.
        playerList.forEach(player -> inputReceiveCardCommandRecursive(deck,player));

        //딜러가 16이하일 경우는 카드한장을 받고, 17이상일 경우는 받지않는다.
        if(dealer.canDrawCard()){
            dealer.addCard(deck.draw());
        }

        //최종결과를 출력한다.
        dealer.showFinalResult();
        playerList.forEach(Player::showFinalResult);

        //최종 심판
        finalResult(playerList,dealer);

    }

    private void finalResult(final List<Player> players, final Dealer dealer) {
        players.forEach(player -> judgeScoreResult(player,dealer));
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
          dealer.loseMoney(new BettingMoney(player.getMoney()));
        }
    }

    private static void judgeDealerWin(final Player player, final Dealer dealer) {
        //딜러가 이긴 경우
        if(dealer.isBlackJack()
                || (!dealer.isBust() && dealer.getTotalPoint() > dealer.getTotalPoint())
                || (player.isBust() && !dealer.isBust())
        ){
            dealer.winMoney(new BettingMoney(player.getMoney()));
            player.loseMoney();
        }
    }

    private static void firstResult(final Dealer dealer, final List<Player> playerList, final Map<Player, BettingMoney> bettingMoneyMap) {
        //딜러가 블랙잭을 가졌는지 확인한다.
        boolean hasBlackJack = dealer.isBlackJack();
        if(hasBlackJack){
            //만약 참일 경우, 블랙잭을 가지지 않은 플레이어는 베팅 금액을 모두 잃게 된다.
            playerList.stream()
                    .filter(Predicate.not(Player::isBlackJack))
                    .forEach(player -> bettingMoneyMap.get(player).loseMoney());
        } else{
            //만약 거짓일 경우, 블랙잭을 가진 플레이어는 1.5배의 배팅 금액을 받게 된다.
            playerList.stream()
                    .filter(Player::isBlackJack)
                    .forEach(player -> bettingMoneyMap.get(player).winMoney());
        }
    }

    private static void inputReceiveCardCommandRecursive(CardDeck deck,Player player){
        if(canDrawACard(player)){
            player.showCards();
            return;
        }
        String command = InputView.InputCommandToReceiveCard();
        player.addCard();
    }

    private static boolean canDrawACard(Player player) {
        return !player.canDrawCard() || player.isBust();
    }

    private static Players createPlayer() {
        OutPutView.printPlayerNameMassage();
        String playerName = InputView.InputPlayerName();
        return new Players(playerName);
    }
}
