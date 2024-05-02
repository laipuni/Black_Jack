package wooahanprecourse.blackjack.domain.view;

import wooahanprecourse.blackjack.domain.card.Card;
import wooahanprecourse.blackjack.domain.participant.ParticipantName;

import java.util.List;
import java.util.StringJoiner;

public class OutPutView {

    public static final String INPUT_PLAYER_NAME_MASSAGE = "게임에 참여할 사람의 이름을 입렵하세요.(쉼표 기준으로 분리)";
    public static final String INPUT_BETTING_MONEY_MASSAGE = "의 배팅 금액은?";
    public static final String INPUT_RECEIVE_CARD_MASSAGE = "는 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";

    public static void printPlayerNameMassage(){
        print(INPUT_PLAYER_NAME_MASSAGE);
    }

    public static void printBettingMoneyMassage(String playerName){
        print(playerName + INPUT_BETTING_MONEY_MASSAGE);
    }

    public static void print(String message){
        System.out.println(message);
    }

    public static void printFirstCardTurn(List<Card> cards,String name) {
        String cardJoiner = createCardJoiner(cards);

        print(name + "카드" + cardJoiner);
    }

    private static String createCardJoiner(List<Card> cards) {
        StringJoiner joiner = new StringJoiner(", ");

        cards.forEach(card -> joiner.add(card.toString()));
        return joiner.toString();
    }

    public static void printReceiveCardCommandMassage(String name) {
        print(name + INPUT_RECEIVE_CARD_MASSAGE);
    }

    public static void printFinalResult(ParticipantName name, List<Card> cards, int totalPoint) {
        print(name + "카드" + createCardJoiner(cards) + "- 결과: " + totalPoint);
    }

}
