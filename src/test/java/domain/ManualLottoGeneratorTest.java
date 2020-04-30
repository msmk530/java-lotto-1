package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ManualLottoGeneratorTest {
    @Test
    void 수동_로또_생성_테스트() {
        //given
        LottoGenerator generator = new ManualLottoGenerator();
        Lotto compareLotto;
        Lotto manualLotto;
        //when
        compareLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        manualLotto = generator.generateLotto(Arrays.asList(4, 5, 6, 1, 2, 3));
        //then
        assertThat(manualLotto.equals(compareLotto)).isTrue();
    }
}