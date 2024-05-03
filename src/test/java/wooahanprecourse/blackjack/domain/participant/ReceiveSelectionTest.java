package wooahanprecourse.blackjack.domain.participant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ReceiveSelectionTest {

    @DisplayName("y를 입력할 경우 true를 반환한다")
    @Test
    void findValueYes(){
        assertThat(ReceiveSelection.findValue("y")).isTrue();
    }


    @DisplayName("n를 입력할 경우 false를 반환한다")
    @Test
    void findValueNo(){
        assertThat(ReceiveSelection.findValue("n")).isFalse();
    }


    @DisplayName("y or n이외에 입력을 넣을 경우 에러가 발생한다.")
    @Test
    void findValueElse(){
        assertThatThrownBy(() -> ReceiveSelection.findValue("Else"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("y or n로 입력해주시길 바랍니다.");
    }
}