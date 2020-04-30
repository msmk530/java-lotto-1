package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @Test
    void 자동로또_리스트_반환_테스트() {
        List<Lotto> lottoes = LottoMachine.createAutomaticLotto(new AutomaticLottoGenerator(), 5);
        assertThat(lottoes.size()).isEqualTo(5);
    }

    @Test
    void 당첨로또_반환_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto;

        winningLotto = LottoMachine.createWinningLotto(winningNumbers, bonusNumber);

        assertThat(winningLotto.getLotto()).isEqualTo(new ManualLottoGenerator().generateLotto(winningNumbers));
        assertThat(winningLotto.getBonus()).isEqualTo(bonusNumber);
    }

}