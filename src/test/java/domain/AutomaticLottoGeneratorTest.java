package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutomaticLottoGeneratorTest {
    private static final int COUNT_OF_LOTTO_NUMBER = 6;

    private Lotto automaticLotto;

    @BeforeEach
    void setUp() {
        LottoGenerator generator = new AutomaticLottoGenerator();
        List<Integer> emptyNumbers = new ArrayList<>();
        automaticLotto = generator.generateLotto(emptyNumbers);
    }

    @Test
    void 자동_로또_생성_테스트() {
        assertThat(automaticLotto).isNotNull();
    }

    @Test
    void 생성된_로또_사이즈_테스트() {
        assertThat(automaticLotto.getNumbers().size()).isEqualTo(COUNT_OF_LOTTO_NUMBER);
    }
}