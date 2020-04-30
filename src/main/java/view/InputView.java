package view;

import domain.Lotto;
import domain.Validator;
import domain.WinningLotto;
import util.ChangeStringToIntList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String DEMAND_PURCHASE_PRICE = "구입금액을 입력해주세요.";
    private static final String DEMAND_COUNT_OF_MANUAL_LOTTO = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final String DEMAND_MANUAL_NUMBERS = "수동으로 구매하실 번호를 입력해주세요. 현재 완성된 수동 로또 개수는 : ";
    private static final String DEMAND_WINNING_NUMBERS = "지난 주 당첨번호를 입력해주세요.";
    private static final String DEMAND_BONUS_NUMBER = "보너스 볼을 입력해주세요";
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
            System.out.println(DEMAND_MANUAL_NUMBERS + countFinishedManualLotto);
            String selectedNumbers = scanner.next();
            Validator.isValidNumbers(selectedNumbers);
            lottoNumbers = ChangeStringToIntList.changeStringToList(selectedNumbers);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return inputManualNumber(countFinishedManualLotto);
        }

        return lottoNumbers;
    }


    public static List<Integer> inputWinningLottoNumbers() {
        List<Integer> winningNumbers;

        try {
            System.out.println(DEMAND_WINNING_NUMBERS);
            String lastWeekWinningNumbers = scanner.next();
            Validator.isValidNumbers(lastWeekWinningNumbers);
            winningNumbers = ChangeStringToIntList.changeStringToList(lastWeekWinningNumbers);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return inputWinningLottoNumbers();
        }

        return winningNumbers;
    }

    public static int inputBonus(List<Integer> winningNumbers) {
        int bonusNumber;

        try {
            System.out.println(DEMAND_BONUS_NUMBER);
            bonusNumber = scanner.nextInt();
            Validator.isValidBonusNumber(bonusNumber,winningNumbers);
        }catch(Exception e){
            System.err.println(e.getMessage());
            return inputBonus(winningNumbers);
        }
        return bonusNumber;
    }
}
