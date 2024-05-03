package wooahanprecourse.blackjack.domain.participant;

import wooahanprecourse.blackjack.domain.bettingMoney.BettingMoney;
import wooahanprecourse.blackjack.domain.card.Card;
import wooahanprecourse.blackjack.view.InputView;
import wooahanprecourse.blackjack.view.OutPutView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static wooahanprecourse.blackjack.domain.participant.Dealer.DEALER_NAME;

public class Player implements Participant {
    public static final int BLACK_JACK = 21;

    private ParticipantName name;
    private List<Card> cards = new ArrayList<>();
    private int totalPoint;
    private BettingMoney bettingMoney;

    public Player(String name) {
        verifySameDealerNameBy(name);
        this.name = new ParticipantName(name);
    }

    private void verifySameDealerNameBy(String name){
        if(DEALER_NAME.equals(name)){
            throw new IllegalArgumentException("딜러와 같은이름을 가질 수 없습니다.");
        }
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
        Arrays.stream(drawCards).forEach(card -> {
            totalPoint += card.getPoint();
        });
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
        return ReceiveSelection.findValue(InputView.InputCommandToReceiveCard());
    }

    @Override
    public void showCards() {
        OutPutView.printFirstCardTurn(cards,name.getName());
    }

    @Override
    public void showFinalResult() {
        OutPutView.printFinalCardResult(name.getName(),cards,totalPoint);
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

    public void winBonusMoney(){
        this.bettingMoney.winBonusMoney();
    }
}
