package domain;

import exception.ManualLotto.MaximumCountOfManualLottoException;
import exception.ManualLotto.MinimumCountOfManualLottoException;
import exception.PurchasePrice.MinimumPurchasePriceException;
import exception.PurchasePrice.PurchasePriceUnitException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    @Test
    void 최소구매금액_만족_테스트() {
        assertThatExceptionOfType(MinimumPurchasePriceException.class)
                .isThrownBy(() -> Validator.isCorrectPurchasePrice(900));
    }

    @Test
    void 구매금액_단위_테스트() {
        assertThatExceptionOfType(PurchasePriceUnitException.class)
                .isThrownBy(() -> Validator.isCorrectPurchasePrice(1010));
    }

    @Test
    void 수동매수_최소_테스트() {
        assertThatExceptionOfType(MinimumCountOfManualLottoException.class)
                .isThrownBy(() -> Validator.isCorrectCountOfManualLotto(5, -1));
    }

    @Test
    void 수동매수_최대_테스트() {
        assertThatExceptionOfType(MaximumCountOfManualLottoException.class)
                .isThrownBy(() -> Validator.isCorrectCountOfManualLotto(5, 6));
    }
}