package com.vaidoos.guitorio.customnavigationdrawer;

/**
 * Created by Guitorio on 2/21/2018.
 */

public class CardDetail {

    private String tvRemainingBalanceDigit,cardNumerFirstFourDig,cardNumerLastFourDig,validationDate;

    public CardDetail(String tvRemainingBalanceDigit, String cardNumerFirstFourDig, String cardNumerLastFourDig, String validationDate) {
        this.tvRemainingBalanceDigit = tvRemainingBalanceDigit;
        this.cardNumerFirstFourDig = cardNumerFirstFourDig;
        this.cardNumerLastFourDig = cardNumerLastFourDig;
        this.validationDate = validationDate;
    }

    public String getTvRemainingBalanceDigit() {
        return tvRemainingBalanceDigit;
    }

    public void setTvRemainingBalanceDigit(String tvRemainingBalanceDigit) {
        this.tvRemainingBalanceDigit = tvRemainingBalanceDigit;
    }

    public String getCardNumerFirstFourDig() {
        return cardNumerFirstFourDig;
    }

    public void setCardNumerFirstFourDig(String cardNumerFirstFourDig) {
        this.cardNumerFirstFourDig = cardNumerFirstFourDig;
    }

    public String getCardNumerLastFourDig() {
        return cardNumerLastFourDig;
    }

    public void setCardNumerLastFourDig(String cardNumerLastFourDig) {
        this.cardNumerLastFourDig = cardNumerLastFourDig;
    }

    public String getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(String validationDate) {
        this.validationDate = validationDate;
    }
}
