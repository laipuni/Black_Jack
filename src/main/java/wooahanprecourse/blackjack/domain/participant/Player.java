package wooahanprecourse.blackjack.domain.participant;

import wooahanprecourse.blackjack.domain.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Player implements Participant{

    private String name;
    private int totalPoint;
    private List<Card> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void addCard(Card card){
        if(card == null){
            return;
        }
        cards.add(card);
        totalPoint += card.getNumberType().getPoint();
    }

    public String getName() {
        return name;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

}
