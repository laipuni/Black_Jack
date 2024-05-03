package wooahanprecourse.blackjack.domain.participant;

import java.util.*;
import java.util.stream.Collectors;

public enum ReceiveSelection {
    YES("y",true),
    NO("n",false);

    private String answer;
    private boolean value;
    private static final Map<String, Boolean> receiveSelectionMap = createSelectionMap();

    private static HashMap<String, Boolean> createSelectionMap() {
        return new HashMap<>(
                Arrays.stream(ReceiveSelection.values())
                        .collect(Collectors.toMap(ReceiveSelection::getAnswer, ReceiveSelection::getValue))
        );
    }

    ReceiveSelection(final String answer, final boolean value) {
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
