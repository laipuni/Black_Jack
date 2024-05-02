package wooahanprecourse.blackjack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wooahanprecourse.blackjack.domain.BlackJackGame;

import java.io.IOException;

public class BlackjackApplication {

    public static void main(String[] args) {
        BlackJackGame blackJackGame = new BlackJackGame();
        blackJackGame.startGame();
    }

}
