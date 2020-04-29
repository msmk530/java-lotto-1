package domain;

import exception.PurchasePrice.PurchaseAmountException;

public class Validator {
    private static final String PURCHASE_PRICE_ERROR_MESSAGE = "구입금액은 1000원 단위여야합니다.";

    public static void isCorrectPurchasePrice(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new PurchaseAmountException(PURCHASE_PRICE_ERROR_MESSAGE);
        }
    }

}
