package wooahanprecourse.blackjack.domain.bettingMoney;

public class BettingMoney {
    public static final int ZERO = 0;
    public static final int MIN_MONEY = 1000;
    public static final int MAX_MONEY = 100000000;
    public static final double WIN_MULTIPLY = 1;
    public static final double WIN_BONUS_WIN = 1.5;

    private int bettingMoney;
    private BettingMoney(int inputMoney) {
        this.bettingMoney = inputMoney;
    }

    public static BettingMoney of(int inputMoney){
        verifyMoneyDownMinOrUpperMax(inputMoney);
        return new BettingMoney(inputMoney);
    }

    public static BettingMoney ofZero(){
        return new BettingMoney(ZERO);
    }

    public static BettingMoney of(String inputMoney){
        int bettingMoney = convertInt(inputMoney);
        verifyMoneyDownMinOrUpperMax(bettingMoney);
        return new BettingMoney(bettingMoney);
    }

    private static void verifyMoneyDownMinOrUpperMax(int bettingMoney) {
        if(bettingMoney <= MIN_MONEY || bettingMoney >= MAX_MONEY){
            throw new IllegalArgumentException("배당금액은 1,000원에서 100,000,000까지 입력받을 수 있습니다.");
        }
    }

    private static int convertInt(String inputMoney) {
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

    public void winBonusMoney(){
        this.bettingMoney *= WIN_BONUS_WIN;
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
