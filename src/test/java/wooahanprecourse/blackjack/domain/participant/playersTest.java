package wooahanprecourse.blackjack.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @DisplayName("플레이어는 최소 2명 참가 가능하다.")
    @Test
    void 참가자는_최소_2명입니다(){
        assertThatThrownBy(() -> new Players("jinho"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("플레이어는 2~7명 참가 가능합니다.");
    }

    @DisplayName("플레이어는 최대 7명 참가 가능하다.")
    @Test
    void 참가자는_최대_7명까지입니다(){
        assertThatThrownBy(() -> new Players("aa, bb, cc, dd, ee, ff, gg, hh"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("플레이어는 2~7명 참가 가능합니다.");
    }

    @DisplayName("중복된 이름을 입력할 수 없다.")
    @Test
    void isDuplicatedName(){
        assertThatThrownBy(() -> new Players("jinho, jinho"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("중복된 이름은 입력할 수 없습니다.");
    }

}