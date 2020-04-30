package domain;

import exception.ManualLotto.CountOfSelectNumberException;
import exception.ManualLotto.MaximumCountOfManualLottoException;
import exception.ManualLotto.MinimumCountOfManualLottoException;
import exception.ManualLotto.SelectedNumbersDuplicateException;
import exception.PurchasePrice.MinimumPurchasePriceException;
import exception.PurchasePrice.PurchasePriceUnitException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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

    @Test
    void 수동로또번호_갯수_테스트() {
        assertThatExceptionOfType(CountOfSelectNumberException.class)
                .isThrownBy(() -> Validator.isValidNumbers("1,2,3,4,5"));
    }

    @Test
    void 수동로또번호_중복_테스트() {
        assertThatExceptionOfType(SelectedNumbersDuplicateException.class)
                .isThrownBy(() -> Validator.isValidNumbers("1,1,2,3,4,5"));
    }
}