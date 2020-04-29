package view;

import domain.Validator;

import java.util.Scanner;

public class InputView {
    private static final String DEMAND_PURCHASE_PRICE = "구입금액을 입력해주세요.";
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
        return purchasePrice;
    }


}
