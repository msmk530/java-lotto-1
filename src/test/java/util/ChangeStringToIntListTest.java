package util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ChangeStringToIntListTest {
    @Test
    void 스트링을_Int형_리스트로_변환_테스트() {
        //given
        String number = "1,2,3,4,5,6";
        List<Integer> compareTarget = IntStream.range(1, 7)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> target;
        //when
        target = ChangeStringToIntList.change(number);
        //then
        assertThat(target.equals(compareTarget)).isTrue();
    }
}