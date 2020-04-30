package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    @Test
    void 로또머신_수동로또_반환_테스트() {
        //given
        Lotto manualLotto;
        //when
        manualLotto = LottoMachine.createLotto(new ManualLottoGenerator(), Arrays.asList(1, 2, 3, 4, 5, 6));
        //then
        assertThat(manualLotto).isNotNull();
    }

    @Test
    void 로또머신_자동로또_반환_테스트() {
        Lotto automaticLotto;
        List<Integer> emptyNumbers = new ArrayList<>();

        automaticLotto = LottoMachine.createLotto(new AutomaticLottoGenerator(), emptyNumbers);

        assertThat(automaticLotto).isNotNull();
    }
}