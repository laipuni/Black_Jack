package wooahanprecourse.blackjack;

import org.junit.jupiter.api.Test;
import wooahanprecourse.blackjack.domain.card.CardNumberType;

public class EnumTest {

    @Test
    void values(){
        CardNumberType[] values = CardNumberType.values();

        for (CardNumberType value : values) {
            System.out.println("value = " + value);
        }
    }

}
