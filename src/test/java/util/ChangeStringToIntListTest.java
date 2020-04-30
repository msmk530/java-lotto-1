package util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ChangeStringToIntListTest {

    @Test
    void 문자열을_정수_리스트로_바꿔주는_테스트() {
        //given
        String numbers = "1,2,3,4,5,6";
        List<Integer> compareNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when
        List<Integer> changeType = ChangeStringToIntList.change(numbers);
        //then
        assertThat(changeType).isEqualTo(compareNumbers);
    }
}