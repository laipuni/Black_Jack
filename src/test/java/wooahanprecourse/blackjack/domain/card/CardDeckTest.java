package wooahanprecourse.blackjack.domain.card;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    @DisplayName("덱을 생성하면 카드52장을 생성한다.")
    @Test
    void creatDeck(){
        //given
        CardDeck deck = CardDeck.createDeck();

        //when//then
        assertThat(deck.getSize()).isEqualTo(52);
    }

    @DisplayName("덱에서 카드 한장을 뽑는다.")
    @Test
    void draw(){
        //given
        CardDeck deck = CardDeck.createDeck();

        //when
        Card card = deck.draw();

        //then
        assertThat(card).isInstanceOf(Card.class);

    }
}