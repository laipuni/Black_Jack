package wooahanprecourse.blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wooahanprecourse.blackjack.domain.card.Card;
import wooahanprecourse.blackjack.domain.participant.Player;

import static org.assertj.core.api.Assertions.assertThat;
import static wooahanprecourse.blackjack.domain.card.CardNumberType.*;
import static wooahanprecourse.blackjack.domain.card.CardType.*;

class PlayerTest {

    @DisplayName("카드를 추가하면 플레이어의 총점수가 올라간다.")
    @Test
    void addCard(){
        //given
        Player player = new Player("laipuni");
        Card card1 = new Card(KING, DIAMOND);
        Card card2 = new Card(TWO, SPADE);

        player.addCard(card2);
        player.addCard(card1);

        //when
        int totalPoint = player.getTotalPoint();

        //then
        assertThat(totalPoint).isEqualTo(12);

    }

    @DisplayName("카드의 값이 null일 경우 카드를 포함하지 않는다")
    @Test
    void addCardWithNullCard(){
        //given
        Player player = new Player("laipuni");
        Card card1 = null;

        player.addCard(card1);

        //when
        int totalPoint = player.getTotalPoint();

        //then
        assertThat(totalPoint).isEqualTo(0);
    }

}