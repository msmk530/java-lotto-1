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

    }

    @Test
    void 당첨결과가_1등부터_미당첨까지_포함하는지_테스트() {
        assertThat(result.getResult().size()).isEqualTo(6);
    }

    @Test
    void 올바른_결과_생성_테스트() {

    }
}