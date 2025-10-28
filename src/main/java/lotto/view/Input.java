package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public int inputMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public String inputNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

}
