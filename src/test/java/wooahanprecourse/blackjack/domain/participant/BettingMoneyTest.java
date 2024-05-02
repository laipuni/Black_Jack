package wooahanprecourse.blackjack.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wooahanprecourse.blackjack.domain.bettingMoney.BettingMoney;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BettingMoneyTest {

    @DisplayName("숫자가 아닌 배당금액을 입력받으면 에러가 발생한다.")
    @Test
    void isInputNotNumber(){
        assertThatThrownBy(() -> new BettingMoney("money"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("배당금액은 숫자로 입력해주세요");
    }

    @DisplayName("배당금액은 1,000원에서 100,000,000까지 입력받을 수 있다.")
    @Test
    void isMoneyDownMin(){
        assertThatThrownBy(() -> new BettingMoney("10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("배당금액은 1,000원에서 100,000,000까지 입력받을 수 있습니다.");
    }

    @DisplayName("배당금액은 1,000원에서 100,000,000까지 입력받을 수 있다.")
    @Test
    void isMoneyUpperMax(){
        assertThatThrownBy(() -> new BettingMoney("1000000000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("배당금액은 1,000원에서 100,000,000까지 입력받을 수 있습니다.");
    }

    @DisplayName("플레이어가 졌을 경우 배팅금액을 잃게 된다.")
    @Test
    void loseMoney(){
        //given
        BettingMoney bettingMoney = new BettingMoney("5000");
        //when
        bettingMoney.loseMoney();

        //then
        assertThat(bettingMoney.getBettingMoney()).isEqualTo(-5000);
    }

    @DisplayName("플레이어가 이겼을 경우 배팅금액의 1.5배 돈을 얻게 된다.")
    @Test
    void winMoney(){
        //given
        BettingMoney bettingMoney = new BettingMoney("5000");
        //when
        bettingMoney.winMoney();

        //then
        assertThat(bettingMoney.getBettingMoney()).isEqualTo(7500);
    }
}