package wooahanprecourse.blackjack.domain.bettingMoney;

public class BettingMoney {
    public static final int MIN_MONEY = 1000;
    public static final int MAX_MONEY = 100000000;
    public static final double WIN_MULTIPLY = 1.5;

    private int bettingMoney;

    public BettingMoney(String inputMoney) {
        this(toInt(inputMoney));
    }

    public BettingMoney(int inputMoney) {
        verifyMoneyDownMinOrUpperMax(bettingMoney);
        this.bettingMoney = bettingMoney;
    }

    private static void verifyMoneyDownMinOrUpperMax(int bettingMoney) {
        if(bettingMoney < MIN_MONEY || bettingMoney > MAX_MONEY){
            throw new IllegalArgumentException("배당금액은 1,000원에서 100,000,000까지 입력받을 수 있습니다.");
        }
    }

    private static int toInt(String inputMoney) {
        try{
            return Integer.parseInt(inputMoney);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("배당금액은 숫자로 입력해주세요");
        }
    }

    public void loseMoney(){
        this.bettingMoney = -this.bettingMoney;
    }

    public void winMoney(){
        this.bettingMoney *= WIN_MULTIPLY;
    }

    public int getBettingMoney() {
        return bettingMoney;
    }

    public void resetMoney() {
        this.bettingMoney = 0;
    }

    public void addMoney(final BettingMoney bettingMoney) {
        this.bettingMoney += bettingMoney.getBettingMoney();
    }

    public void loseMoney(final BettingMoney bettingMoney) {
        this.bettingMoney -=bettingMoney.getBettingMoney();
    }
}
