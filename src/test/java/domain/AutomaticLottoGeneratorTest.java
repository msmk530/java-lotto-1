package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutomaticLottoGeneratorTest {
    private static final int COUNT_OF_LOTTO_NUMBER = 6;

    private Lotto automaticLotto;

    @BeforeEach
    void setUp() {
        List<Integer> numbers = Arrays.asList(6,5,4,3,2,1);
        LottoGenerator generator = new AutomaticLottoGenerator();
        automaticLotto = generator.generateLotto(numbers);
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