package wooahanprecourse.blackjack.view;

import wooahanprecourse.blackjack.domain.card.Card;
import wooahanprecourse.blackjack.domain.participant.Dealer;
import wooahanprecourse.blackjack.domain.participant.ParticipantName;
import wooahanprecourse.blackjack.domain.participant.Player;

import java.util.List;
import java.util.StringJoiner;

public class OutPutView {

    public static final String INPUT_PLAYER_NAME_MASSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    public static final String INPUT_BETTING_MONEY_MASSAGE = "%s의 배팅 금액은?";
    public static final String FIRST_CARDS_RESULT = "%s카드: %s";
    public static final String INPUT_RECEIVE_CARD_MASSAGE = "%s 는 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    public static final String FINAL_RESULT = "%s카드: %s - 결과: %d";
    public static final String FINAL_BETTING_RESULT = "##최종수익";
    public static final String FINAL_BETTING_RESULT_FORMAT = "%s : %s";

    public static void printPlayerNameMassage(){
        print(INPUT_PLAYER_NAME_MASSAGE);
    }

    public static void printBettingMoneyMassage(String playerName){
        print(String.format(INPUT_BETTING_MONEY_MASSAGE,playerName));
    }

    public static void print(String message){
        System.out.println(message);
    }

    public static void printFirstCardTurn(List<Card> cards,String name) {
        String cardJoiner = createCardJoiner(cards);

        print(String.format(FIRST_CARDS_RESULT,name,cardJoiner));
    }

    private static String createCardJoiner(List<Card> cards) {
        StringJoiner joiner = new StringJoiner(", ");

        cards.forEach(card -> joiner.add(card.toString()));
        return joiner.toString();
    }

    public static void printReceiveCardCommandMassage(String name) {
        print(String.format(INPUT_RECEIVE_CARD_MASSAGE,name));
    }

    public static void printFinalResult(Dealer dealer, List<Player> players){
        print(FINAL_BETTING_RESULT);
        printFinalBettingResult(dealer.getName(), dealer.getBettingMoney());
        players.forEach(player -> printFinalBettingResult(player.getName(), player.getMoney()));
    }

    private static void printFinalBettingResult(String name, int money){
        print(String.format(FINAL_BETTING_RESULT_FORMAT,name,money));
    }

    public static void printFinalCardResult(String name, List<Card> cards, int totalPoint) {
        print(String.format(FINAL_RESULT,name,createCardJoiner(cards),totalPoint));
    }

}
