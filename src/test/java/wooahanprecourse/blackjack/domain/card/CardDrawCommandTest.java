package wooahanprecourse.blackjack.domain.card;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CardDrawCommandTest {
    @DisplayName("주어진 입력(y or n)이외에 입력은 에러가 발생한다.")
    @Test
    void test(){
        assertThatThrownBy(() ->CardDrawCommand.findCardDrawCommand("s"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}