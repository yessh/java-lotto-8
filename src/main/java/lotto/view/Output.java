package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class Output {

    public void printLottoCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
