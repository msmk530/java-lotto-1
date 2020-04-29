package domain;

import exception.PurchasePrice.MinimumPurchasePriceException;
import exception.PurchasePrice.PurchasePriceUnitException;

public class Validator {
    private static final String PURCHASE_PRICE_UNIT_ERRORMESSAGE = "구입금액은 1000원 단위여야합니다.";
    private static final String MINIMUM_PURCHASE_PRICE_ERRORMESSAGE = "구입금액은 최소 1000원이어야 합니다.";

    public static void isCorrectPurchasePrice(int purchasePrice) {
        if (purchasePrice < 1000) {
            throw new MinimumPurchasePriceException(MINIMUM_PURCHASE_PRICE_ERRORMESSAGE);
        }

        if (purchasePrice % 1000 != 0) {
            throw new PurchasePriceUnitException(PURCHASE_PRICE_UNIT_ERRORMESSAGE);
        }
    }

}
