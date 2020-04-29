package domain;

import exception.ManualLotto.MaximumCountOfManualLottoException;
import exception.ManualLotto.MinimumCountOfManualLottoException;
import exception.PurchasePrice.MinimumPurchasePriceException;
import exception.PurchasePrice.PurchasePriceUnitException;

public class Validator {
    private static final String PURCHASE_PRICE_UNIT_ERRORMESSAGE = "구입금액은 1000원 단위여야합니다.";
    private static final String MINIMUM_PURCHASE_PRICE_ERRORMESSAGE = "구입금액은 최소 1000원이어야 합니다.";
    private static final String MINIMUM_COUNT_OF_MANUAL_LOTTO_ERRORMESSAGE = "수동으로 구매하실 매수는 최소 0이상 이어야합니다.";
    private static final String MAXIMUM_COUNT_OF_MANUAL_LOTTO_ERRORMESSAGE = "수동으로 구매하실 수 있는 매수는 최대";

    public static void isCorrectPurchasePrice(int purchasePrice) {
        if (purchasePrice < 1000) {
            throw new MinimumPurchasePriceException(MINIMUM_PURCHASE_PRICE_ERRORMESSAGE);
        }

        if (purchasePrice % 1000 != 0) {
            throw new PurchasePriceUnitException(PURCHASE_PRICE_UNIT_ERRORMESSAGE);
        }
    }

    public static void isCorrectCountOfManualLotto(int countOfPurchaseLotto, int countOfManualLotto) {
        if (countOfManualLotto < 0) {
            throw new MinimumCountOfManualLottoException(MINIMUM_COUNT_OF_MANUAL_LOTTO_ERRORMESSAGE);
        }

        if (countOfPurchaseLotto < countOfManualLotto) {
            throw new MaximumCountOfManualLottoException(MAXIMUM_COUNT_OF_MANUAL_LOTTO_ERRORMESSAGE
                    + Integer.toString(countOfPurchaseLotto) + "장 입니다.");
        }
    }
}
