package view;

import domain.Validator;
import util.ChangeStringToIntList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String DEMAND_PURCHASE_PRICE = "구입금액을 입력해주세요.";
    private static final String DEMAND_COUNT_OF_MANUAL_LOTTO = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final String DEMAND_MANUAL_NUMBER = "수동으로 구매하실 번호를 입력해주세요. 현재 완성된 수동 로또 개수는 : ";
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


    public static List<Integer> inputManualNumber(int countFinishedManualLotto) {
        List<Integer> lottoNumbers;

        try {
            System.out.println(DEMAND_MANUAL_NUMBER+countFinishedManualLotto);
            String selectedNumbers = scanner.next();
            Validator.isValidNumbers(selectedNumbers);
            lottoNumbers = ChangeStringToIntList.changeStringToList(selectedNumbers);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return inputManualNumber(countFinishedManualLotto);
        }

        return lottoNumbers;
    }

}
