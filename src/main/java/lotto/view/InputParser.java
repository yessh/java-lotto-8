package lotto.view;

import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public static void validateInputMoney(String input) {
        try {
            int money = Integer.parseInt(input);

            if (money < 0) {
                throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야합니다.");
            }
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력되어야 합니다.");
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 돈 입력입니다");
        }
    }


    public static Lotto parseLotto(String input) {

        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            return new Lotto(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 숫자 입력입니다");
        }
    }

    public static void validateBonusNumber(String input) {
        try {
            int BonusNumber = Integer.parseInt(input);
            if (BonusNumber < 1 || BonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 입력입니다.");
        }
    }
}
