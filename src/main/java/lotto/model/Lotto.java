package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
    public static Lotto makeRandomLotto() {
        List<Integer> createdNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> numbers = new ArrayList<>(createdNumbers);

        Collections.sort(numbers);

        return new Lotto(numbers);
    }

    public Rank calculateRank(WinningLotto winningLotto) {
        int matchCount = (int) this.numbers.stream()
                .filter(winningLotto.getWinningNumbers().getNumbers()::contains)
                .count();

        boolean bonusMatch = this.numbers.contains(winningLotto.getBonusNumber());

        return Rank.valueOf(matchCount, bonusMatch);
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> nonDuplicatedNumbers = new HashSet<>(numbers);
        if (nonDuplicatedNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자들로 입력되어야 합니다.");
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 이상 45 이하이어야 합니다.");
            }
        }
    }

}
