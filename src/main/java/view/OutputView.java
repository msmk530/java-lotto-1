package view;

import domain.Lotto;

import java.util.List;

public class OutputView {
    public static void printAllLotto(List<Lotto> allLotto, int countOfManualLotto, int countOfAutomaticLotto) {
        System.out.printf("수동으로 %d장 , 자동으로 %d장을 구매하셨습니다.\n", countOfManualLotto, countOfAutomaticLotto);
        for (Lotto lotto : allLotto) {
            System.out.println(lotto.getNumbers().toString());
        }
    }
}
