package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    GameResult result;

    @BeforeEach
    void setUp() {
        int countOfPurchaseLotto = 5;
        List<Lotto> allLotto = new ArrayList<>();
        WinningLotto winningLotto;

        allLotto.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        allLotto.add(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)));
        allLotto.add(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)));
        allLotto.add(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)));
        allLotto.add(new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10)));

        winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

        result = new GameResult(countOfPurchaseLotto, allLotto, winningLotto);
    }

    @Test
    void 당첨결과가_1등부터_미당첨까지_포함하는지_테스트() {
        assertThat(result.getResult().size()).isEqualTo(6);
    }

    @Test
    void 올바른_결과_생성_테스트() {
        assertThat(result.getResult().get(Rank.values()[0])).isEqualTo(1);
        assertThat(result.getResult().get(Rank.values()[1])).isEqualTo(1);
        assertThat(result.getResult().get(Rank.values()[2])).isEqualTo(0);
        assertThat(result.getResult().get(Rank.values()[3])).isEqualTo(1);
        assertThat(result.getResult().get(Rank.values()[4])).isEqualTo(1);
        assertThat(result.getResult().get(Rank.values()[5])).isEqualTo(1);

    }
}