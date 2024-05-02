package wooahanprecourse.blackjack.domain.card;

import jakarta.annotation.Nullable;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CardDrawCommand {

    CARD_DRAW_YES("y"),
    CARD_DRAW_NO("n");

    private final String answer;
    private static final Map<String,CardDrawCommand> CACHE = Stream.of(CardDrawCommand.values())
                    .collect(Collectors.toUnmodifiableMap(CardDrawCommand::getAnswer,cardDrawCommand -> cardDrawCommand));

    private CardDrawCommand(String answer) {
        this.answer = answer;
    }

    public static CardDrawCommand findCardDrawCommand(String command){
        return Optional.ofNullable(CACHE.get(command.toLowerCase()))
                .orElseThrow(() ->
                        new IllegalArgumentException(createExceptionMassage() + " 중에서 입력해주세요.")
                );
    }

    private static String createExceptionMassage(){
        StringJoiner joiner = new StringJoiner(", ");
        for (CardDrawCommand value : CardDrawCommand.values()) {
            joiner.add(value.answer);
        }
        return joiner.toString();
    }

    public String getAnswer() {
        return answer;
    }
}
