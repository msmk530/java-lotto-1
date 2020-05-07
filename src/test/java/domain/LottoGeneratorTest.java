package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    void generateLotto() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = LottoGenerator.generateLotto(numbers);

        assertThat(lotto.getNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}