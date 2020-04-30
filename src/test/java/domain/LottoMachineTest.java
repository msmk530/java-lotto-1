package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {
    @Test
    void 자동_로또리스트_반환_테스트() {
        List<Lotto> lottoes = LottoMachine.createAutomaticLotto(new AutomaticLottoGenerator(), 5);
        assertThat(lottoes.size()).isEqualTo(5);
    }

}