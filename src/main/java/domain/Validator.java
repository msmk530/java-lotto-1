package domain;

import exception.ManualLotto.*;
import exception.PurchasePrice.MinimumPurchasePriceException;
import exception.PurchasePrice.PurchasePriceUnitException;
import exception.WinningLotto.BetweenBonusAndWinningNumbersDuplicateExcetpion;
import exception.WinningLotto.BonusNumberRangeException;

import java.util.*;

public class Validator {
    private static final String PURCHASE_PRICE_UNIT_ERROR_MESSAGE = "구입금액은 1000원 단위여야합니다.";
    private static final String MINIMUM_PURCHASE_PRICE_ERROR_MESSAGE = "구입금액은 최소 1000원이어야 합니다.";
    private static final String MINIMUM_COUNT_OF_MANUAL_LOTTO_ERROR_MESSAGE = "수동으로 구매하실 매수는 최소 0이상 이어야합니다.";
    private static final String MAXIMUM_COUNT_OF_MANUAL_LOTTO_ERROR_MESSAGE = "수동으로 구매하실 수 있는 매수는 최대";
    private static final String SELECTED_NUMBER_COUNT_ERROR_MEESAGE = "번호는 6개를 입력해 주셔야 합니다.";
    private static final String SELECTED_NUMBER_DUPLICATE_ERROR_MESSAGE = "선택하신 번호에 중복이 있으면 안됩니다.";
    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "번호는 1부터 45사이의 숫자여야 합니다.";
    private static final String BONUS_AND_WINNINGNUMBERS_DUPLICATE_ERROR_MESSAGE = "보너스번호는 당첨번호와 중복되면 안됩니다.";
    private static final String BONUS_NUMBER_RANGE_ERROR_MESSAGE = "보너스 번호는 1부터 45사이의 숫자여야 합니다.";
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private Validator() {
        throw new AssertionError();
    }

    public static void isCorrectPurchasePrice(int purchasePrice) {
        if (purchasePrice < 1000) {
            throw new MinimumPurchasePriceException(MINIMUM_PURCHASE_PRICE_ERROR_MESSAGE);
        }

        if (purchasePrice % 1000 != 0) {
            throw new PurchasePriceUnitException(PURCHASE_PRICE_UNIT_ERROR_MESSAGE);
        }
    }

    public static void isCorrectCountOfManualLotto(int countOfPurchaseLotto, int countOfManualLotto) {
        if (countOfManualLotto < 0) {
            throw new MinimumCountOfManualLottoException(MINIMUM_COUNT_OF_MANUAL_LOTTO_ERROR_MESSAGE);
        }

        if (countOfPurchaseLotto < countOfManualLotto) {
            throw new MaximumCountOfManualLottoException(MAXIMUM_COUNT_OF_MANUAL_LOTTO_ERROR_MESSAGE
                    + Integer.toString(countOfPurchaseLotto) + "장 입니다.");
        }
    }

    public static void isValidNumbers(List<Integer> selectedNumbers) {
        if (selectedNumbers.size() != 6) {
            throw new CountOfSelectNumberException(SELECTED_NUMBER_COUNT_ERROR_MEESAGE);
        }

        Set<Integer> checkDuplicate = new HashSet<>(selectedNumbers);

        if (selectedNumbers.size() != checkDuplicate.size()) {
            throw new SelectedNumbersDuplicateException(SELECTED_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }

        for (Integer selectedNumber : selectedNumbers) {
            if (selectedNumber < MINIMUM_LOTTO_NUMBER
                    || selectedNumber > MAXIMUM_LOTTO_NUMBER) {
                throw new LottoNumberOutOfRangeException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
            }
        }

    }

    public static void isValidBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new BetweenBonusAndWinningNumbersDuplicateExcetpion(BONUS_AND_WINNINGNUMBERS_DUPLICATE_ERROR_MESSAGE);
        }
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new BonusNumberRangeException(BONUS_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }
}
