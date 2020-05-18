package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChangeStringToIntList {
    public static List<Integer> change(String numbers) {
        String[] targetNumbers = numbers.split(",");
        List<Integer> changedNumbers = new ArrayList<>();

        for (String targetNumber : targetNumbers) {
            changedNumbers.add(Integer.parseInt(targetNumber));
        }

        return changedNumbers;
    }
}
