package wooahanprecourse.blackjack.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantNameTest {

    @DisplayName("이름에 공백이 포함 되면 안된다.")
    @Test
    void hasBlank(){
        assertThatThrownBy(() -> new ParticipantName("lee jinho"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("이름에 공백은 포함할 수 없습니다.");
    }

    @DisplayName("플레이어들의 이름들 중 딜러와 같은 이름이 없는지 확인한다.")
    @Test
    void createPlayerWithDealerName(){
        assertThatThrownBy(() -> new ParticipantName("딜러"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("딜러와 같은이름을 가질 수 없습니다.");
    }

    @DisplayName("플레이어 이름은 1자~20자까지 가능하다.")
    @Test
    void createPlayerWithIsBetween1And20(){
        assertThatThrownBy(() -> new ParticipantName("111222333444555666777888999"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("이름의 길이 제한은 1~20자 입니다.");
    }

    @DisplayName("플레이어 이름은 공백일 수 없다.")
    @Test
    void createPlayerWithEmptyName(){
        assertThatThrownBy(() -> new ParticipantName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("이름이 공백일 수 없습니다.");
    }

}