package wooahanprecourse.blackjack.domain.participant;

import wooahanprecourse.blackjack.domain.bettingMoney.BettingMoney;
import wooahanprecourse.blackjack.domain.card.Card;
import wooahanprecourse.blackjack.domain.view.OutPutView;

import java.util.Arrays;
import java.util.List;

public class Player implements Participant {
    public static final int BLACK_JACK = 21;

    private ParticipantName name;
    private List<Card> cards;
    private int totalPoint;
    private BettingMoney bettingMoney;

    public Player(String name) {
        this.name = new ParticipantName(name);
    }

    public void bet(BettingMoney bettingMoney){
        this.bettingMoney = bettingMoney;
    }

    @Override
    public void addCard(Card... drawCards) {
        addCardPoint(drawCards);
        this.cards.addAll(Arrays.asList(drawCards));
    }

    private void addCardPoint(Card[] drawCards) {
        Arrays.stream(drawCards).forEach(card -> totalPoint += card.getPoint());
    }

    @Override
    public boolean isBust() {
        return totalPoint > BLACK_JACK;
    }

    @Override
    public boolean isBlackJack() {
        return totalPoint == BLACK_JACK;
    }

    @Override
    public boolean canDrawCard() {
        OutPutView.printReceiveCardCommandMassage(name.getName());
        return false;
    }

    @Override
    public void showCards() {
        OutPutView.printFirstCardTurn(cards,name.getName());
    }

    @Override
    public void showFinalResult() {
        OutPutView.printFinalResult(name,cards,totalPoint);
    }

    public String getName() {
        return name.getName();
    }

    public int getTotalPoint(){
        return this.totalPoint;
    }

    public void resetMoney() {
        this.bettingMoney.resetMoney();
    }

    public int getMoney() {
        return bettingMoney.getBettingMoney();
    }

    public void loseMoney() {
        this.bettingMoney.loseMoney();
    }

    public void winMoney() {
        this.bettingMoney.winMoney();
    }
}
