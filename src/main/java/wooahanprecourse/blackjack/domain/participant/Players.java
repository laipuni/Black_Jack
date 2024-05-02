package wooahanprecourse.blackjack.domain.participant;

import java.util.*;
import java.util.stream.Collectors;

public class Players {
    public static final int MIN_PLAYER = 2;
    public static final int MAX_PLAYER = 7;

    private List<Player> players;

    public Players(String playerName) {
        List<String> playerNames = toPlayerListBy(playerName);
        validationName(playerNames);
        this.players = createPlayers(playerNames);;
    }

    public List<Player> getPlayers(){
        return List.copyOf(players);
    }

    private static List<String> toPlayerListBy(String playerName) {
        String[] playerNames = playerName.split(",");
        return Arrays.stream(playerNames)
                .map(String::trim)
                .toList();
    }

    private static void validationName(List<String> playerNames) {
        verifyPlayerNumber(playerNames);
        verifyDuplicateName(playerNames);
    }

    private List<Player> createPlayers(List<String> playerNames) {
        return playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private static void verifyDuplicateName(List<String> playerNames) {
        Set<String> playerNameSet = new HashSet<>(playerNames);
        if(playerNameSet.size() != playerNames.size()){
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
    }

    private static void verifyPlayerNumber(List<String> playerNames) {
        int size = playerNames.size();
        if(size < MIN_PLAYER || size > MAX_PLAYER){
            throw new IllegalArgumentException("플레이어는 2~7명 참가 가능합니다.");
        }
    }
}
