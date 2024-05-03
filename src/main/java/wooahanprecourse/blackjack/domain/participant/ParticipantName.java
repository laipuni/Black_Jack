package wooahanprecourse.blackjack.domain.participant;

public class ParticipantName {
    public static final int NAME_MIN_LENGTH = 1;
    public static final int NAME_MAX_LENGTH = 20;

    private String name;

    public ParticipantName(String name) {
        validation(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validation(String name) {
        verifyEmptyName(name);
        verifyNull(name);
        verifyBlankName(name);
        verifyBlank(name);
        verifyNameLength(name);
    }

    private void verifyBlank(String name) {
        if(name.contains(" ")){
            throw new IllegalArgumentException("이름에 공백은 포함할 수 없습니다.");
        }
    }


    private void verifyNameLength(String name){
        int length = name.length();
        if(length < NAME_MIN_LENGTH  || length > NAME_MAX_LENGTH){
            throw new IllegalArgumentException("이름의 길이 제한은 1~20자 입니다.");
        }
    }

    private void verifyEmptyName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("이름이 공백일 수 없습니다.");
        }
    }

    private void verifyBlankName(String name){
        if(name.isBlank()){
            throw new IllegalArgumentException("이름은 빈칸일 수 없습니다.");
        }
    }

    private void verifyNull(String name){
        if(name == null){
            throw new IllegalArgumentException("이름은 null일 수 없습니다.");
        }
    }
}
