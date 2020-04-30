package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @Test
    void Rank_1등_확인_테스트() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    void Rank_2등_확인_테스트() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void Rank_3등_확인_테스트() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    void Rank_4등_확인_테스트() {
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void Rank_5등_확인_테스트() {
        assertThat(Rank.valueOf(3,false)).isEqualTo(Rank.FIFTH);
    }

    @Test
    void Rank_미당첨_확인_테스트() {
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.MISS);
    }

}