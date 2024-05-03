package wooahanprecourse.blackjack.domain.participant;

import wooahanprecourse.blackjack.domain.bettingMoney.BettingMoney;
import wooahanprecourse.blackjack.domain.card.Card;
import wooahanprecourse.blackjack.view.OutPutView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dealer implements Participant {
    public static final String DEALER_NAME = "딜러";
    public static final int DRAW_CARD_BOUNDARY = 16;
    public static final String DRAW_CARD_MASSAGE = "딜러는 16이하라 한 장 카드를 더 받았습니다.";
    public static final String NOT_DRAW_CARD_MASSAGE = "딜러는 17이상이라 카드를 받지 않습니다.";
    public static final int BLACK_JACK = 21;

    private ParticipantName name;
    private List<Card> cards = new ArrayList<>();
    private int totalPoint;
    private BettingMoney bettingMoney;

    public Dealer() {
        name = new ParticipantName("딜러");
        bettingMoney = BettingMoney.ofZero();
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
        if(isUpper()){
            OutPutView.print(NOT_DRAW_CARD_MASSAGE);
            return false;
        }
        OutPutView.print(DRAW_CARD_MASSAGE);
        return true;
    }

    private boolean isUpper(){
        return totalPoint > DRAW_CARD_BOUNDARY;
    }

    @Override
    public void showCards() {
        List<Card> showCard = List.of(cards.get(0));
        OutPutView.printFirstCardTurn(showCard,name.getName());
    }

    @Override
    public void showFinalResult() {
        OutPutView.printFinalCardResult(name.getName(),cards,totalPoint);
    }

    public int getTotalPoint(){
        return this.totalPoint;
    }

    public String getName() {
        return name.getName();
    }

    public void winMoney(final BettingMoney bettingMoney){
        this.bettingMoney.addMoney(bettingMoney);
    }

    public void loseMoney(final BettingMoney bettingMoney) {
        this.bettingMoney.loseMoney(bettingMoney);
    }

    public int getBettingMoney() {
        return bettingMoney.getBettingMoney();
    }
}
