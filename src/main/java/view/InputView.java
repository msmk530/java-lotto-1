package view;

import domain.Validator;

import java.util.Scanner;

public class InputView {
    private static final String DEMAND_PURCHASE_PRICE = "구입금액을 입력해주세요.";
    private static final String DEMAND_COUNT_OF_MANUAL_LOTTO = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final int PRICE_PER_ONE_LOTTO = 1000;
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchasePrice() {
        int purchasePrice;

        try {
            System.out.println(DEMAND_PURCHASE_PRICE);
            purchasePrice = scanner.nextInt();
            Validator.isCorrectPurchasePrice(purchasePrice);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return inputPurchasePrice();
        }
        return purchasePrice / PRICE_PER_ONE_LOTTO;
    }


    public static int inputCountOfManualLotto(int countOfPurchaseLotto) {
        int countOfManualLotto;

        try {
            System.out.println(DEMAND_COUNT_OF_MANUAL_LOTTO);
            countOfManualLotto = scanner.nextInt();
            Validator.isCorrectCountOfManualLotto(countOfPurchaseLotto, countOfManualLotto);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return inputCountOfManualLotto(countOfPurchaseLotto);
        }

        return countOfManualLotto;
    }
}
