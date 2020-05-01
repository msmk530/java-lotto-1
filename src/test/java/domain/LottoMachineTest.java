package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @Test
    void 자동로또_리스트_반환_테스트() {
        List<Lotto> lottoes = LottoMachine.createAutomaticLotto(5);
        assertThat(lottoes.size()).isEqualTo(5);
    }
}