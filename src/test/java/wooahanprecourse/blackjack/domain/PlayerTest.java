package wooahanprecourse.blackjack.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wooahanprecourse.blackjack.domain.participant.ParticipantName;
import wooahanprecourse.blackjack.domain.participant.Player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @DisplayName("플레이어는 딜러와 같은 이름을 가질 경우 에러가 발생한다.")
    @Test
    void verifySameDealerName(){
        //given//when//then
        Assertions.assertThatThrownBy(() -> new Player("딜러"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("딜러와 같은이름을 가질 수 없습니다.");
    }
}