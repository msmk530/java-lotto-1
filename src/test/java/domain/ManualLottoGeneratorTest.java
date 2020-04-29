package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoGeneratorTest {

    @Test
    void generateLotto() {
        //given
        LottoGenerator manualLottoGenerator = new ManualLottoGenerator();
        Lotto manualLotto;
        //when
        manualLotto = manualLottoGenerator.generateLotto(Arrays.asList(1,2,3,4,5,6));
        //then
        assertThat(manualLotto).isNotNull();
    }
}