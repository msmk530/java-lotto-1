package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoGeneratorTest {
    private Lotto manualLotto;

    @BeforeEach
    void setUp() {
        List<Integer> manualNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        manualLotto = new ManualLottoGenerator().generateLotto(manualNumbers);
    }

    @Test
    void 수동_로또_생성_테스트() {
        assertThat(manualLotto).isNotNull();
    }

    @Test
    void 수동_로또_내용_테스트() {
        assertThat(manualLotto.getNumbers()).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
}