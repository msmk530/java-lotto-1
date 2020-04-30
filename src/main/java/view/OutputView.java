package view;

import domain.GameResult;
import domain.Lotto;
import domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String FIRST_EARNING_MESSAGE = "총 수익률은 ";
    private static final String SECOND_EARNING_MESSAGE = "%입니다.";
    private static final int PRICE_PER_LOTTOGAME = 1000;
    private static final int PERCENT = 100;

    private OutputView() {
        throw new AssertionError();
    }

    public static void printAllLotto(List<Lotto> allLotto, int countOfManualLotto, int countOfAutomaticLotto) {
        System.out.printf("수동으로 %d장 , 자동으로 %d장을 구매하셨습니다.\n", countOfManualLotto, countOfAutomaticLotto);
        for (Lotto lotto : allLotto) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void printResult(GameResult gameResult) {
        System.out.println("당첨 통계 \n-------------------");
        printGameResult(gameResult.getResult());
        printEarningRate(gameResult.getResult(), gameResult.getCountOfPurchaseLotto());
    }

    private static void printGameResult(Map<Rank, Integer> result) {
        for (int i = Rank.values().length - 1; i >= 0; i--) {
            Rank.values()[i].printMessage(result.get(Rank.values()[i]));
        }
    }

    private static void printEarningRate(Map<Rank, Integer> gameResult, int countOfPurchaseLotto) {
        double EarningRate = 0;

        for (Rank rank : gameResult.keySet()) {
            EarningRate += (double) ((rank.getWinningMoney()) / (countOfPurchaseLotto * PRICE_PER_LOTTOGAME)) * gameResult.get(rank) * PERCENT;
        }
        System.out.println(FIRST_EARNING_MESSAGE + String.format("%.3f", EarningRate) + SECOND_EARNING_MESSAGE);
    }
}
