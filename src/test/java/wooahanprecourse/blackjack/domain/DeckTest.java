package wooahanprecourse.blackjack.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wooahanprecourse.blackjack.domain.card.Card;
import wooahanprecourse.blackjack.domain.card.CardNumberType;
import wooahanprecourse.blackjack.domain.card.CardType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static wooahanprecourse.blackjack.domain.card.CardNumberType.*;
import static wooahanprecourse.blackjack.domain.card.CardType.*;

class DeckTest {

    @DisplayName("카드 한장을 덱에 넣고, 카드 한장을 꺼낸다.")
    @Test
    void deck(){
        //given
        Deck deck = new Deck(List.of(
                new Card(TWO, HEART)
        ));

        //when
        Card card = deck.takeOneCard();

        //then
        assertThat(card)
                .extracting("numberType","cardType")
                .contains(TWO,HEART);

    }


}