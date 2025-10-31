package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

public class Input {

    public int inputMoney() {
        while(true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String money = Console.readLine();
                InputParser.validateInputMoney(money);

                return Integer.parseInt(money);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public Lotto inputNumbers() {
        while(true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String numbers = Console.readLine();

                return InputParser.parseLotto(numbers);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public int inputBonusNumber() {
        while(true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusNumber = Console.readLine();

                return Integer.parseInt(bonusNumber);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
