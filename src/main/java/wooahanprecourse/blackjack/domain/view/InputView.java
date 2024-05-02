package wooahanprecourse.blackjack.domain.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String InputPlayerName(){
        return readLine();
    }

    public static String InputBettingMoney(){
        return readLine();
    }

    public static String InputCommandToReceiveCard(){
        return readLine();
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("잘못된 입력을 받으셨습니다.",e);
        }
    }

}
