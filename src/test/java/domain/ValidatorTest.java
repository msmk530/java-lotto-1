package domain;

import exception.PurchasePrice.MinimumPurchasePriceException;
import exception.PurchasePrice.PurchasePriceUnitException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    @Test
    void 최소구매금액_만족_테스트() {
        assertThatExceptionOfType(MinimumPurchasePriceException.class)
                .isThrownBy(()->Validator.isCorrectPurchasePrice(900));
    }

    @Test
    void 구매금액_단위_테스트() {
        assertThatExceptionOfType(PurchasePriceUnitException.class)
                .isThrownBy(()->Validator.isCorrectPurchasePrice(1010));
    }
}