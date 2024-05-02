package wooahanprecourse.blackjack.domain.participant;

import wooahanprecourse.blackjack.domain.card.Card;

public interface Participant {
    public abstract void addCard(Card... card);

    public abstract boolean isBust();

    public abstract boolean isBlackJack();

    public abstract boolean canDrawCard();

    public abstract void showCards();

    public abstract void showFinalResult();
}
