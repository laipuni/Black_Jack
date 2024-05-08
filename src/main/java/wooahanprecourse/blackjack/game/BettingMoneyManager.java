package wooahanprecourse.blackjack.game;

import wooahanprecourse.blackjack.domain.bettingMoney.BettingMoney;
import wooahanprecourse.blackjack.domain.participant.Dealer;
import wooahanprecourse.blackjack.domain.participant.Player;
import wooahanprecourse.blackjack.domain.participant.Players;

import java.util.List;
import java.util.Map;

public class BettingMoneyManager {

    private final Map<Player, BettingMoney> bettingMoneyMap;

    public BettingMoneyManager(final Map<Player, BettingMoney> bettingMoneyMap) {
        this.bettingMoneyMap = bettingMoneyMap;
    }

    public void judgeFirstTurnPlayerWin(final Dealer dealer, final Player player) {
        if (player.isBlackJack() && !dealer.isBlackJack()) {
            dealer.loseMoney(bettingMoneyMap.get(player));
            player.winBonusMoney();
        }
    }

    public void judgeFirstTurnDealerWin(final Dealer dealer, final Player player) {
        if (!player.isBlackJack() && dealer.isBlackJack()) {
            dealer.winMoney(bettingMoneyMap.get(player));
            player.loseMoney();
        }
    }
    
    public void judgePlayerWin(final Player player, final Dealer dealer) {
        //플레이어가 이긴 경우
        if (player.isBlackJack()
                || (!player.isBust() && player.getTotalPoint() > dealer.getTotalPoint())
                || (dealer.isBust() && !player.isBust())
        ) {
            player.winMoney();
            dealer.loseMoney(bettingMoneyMap.get(player));
        }
    }

    public void judgeDealerWin(final Player player, final Dealer dealer) {
        //딜러가 이긴 경우
        if (dealer.isBlackJack()
                || (!dealer.isBust() && dealer.getTotalPoint() > player.getTotalPoint())
                || player.isBust()
        ) {
            dealer.winMoney(bettingMoneyMap.get(player));
            player.loseMoney();
        }
    }
}

