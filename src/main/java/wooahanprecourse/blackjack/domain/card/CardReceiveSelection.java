package wooahanprecourse.blackjack.domain.card;

import java.util.*;
import java.util.stream.Collectors;

public enum CardReceiveSelection {
    YES("y",true),
    NO("n",false);

    private String answer;
    private boolean value;
    private static final Map<String, Boolean> receiveSelectionMap = createSelectionMap();

    private static HashMap<String, Boolean> createSelectionMap() {
        return new HashMap<>(
                Arrays.stream(CardReceiveSelection.values())
                        .collect(Collectors.toMap(CardReceiveSelection::getAnswer, CardReceiveSelection::getValue))
        );
    }

    CardReceiveSelection(final String answer, final boolean value) {
        this.answer = answer;
        this.value = value;
    }

    public static boolean findValue(final String command) {
        return Optional.ofNullable(receiveSelectionMap.get(command))
                .orElseThrow(() -> new IllegalArgumentException("y or n로 입력해주시길 바랍니다."));
    }

    public String getAnswer() {
        return answer;
    }

    public boolean getValue() {
        return value;
    }
}
