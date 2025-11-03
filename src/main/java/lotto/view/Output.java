package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.Statistics;

import java.util.Map;

public class Output {

    public void printLottoCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printStatistics(Statistics statistics) {
        System.out.println("\n당첨 톰계");
        System.out.println("---");

        Map<Rank, Integer> result = statistics.getResult();

        System.out.printf("3개 일치 (%,d원) - %d개\n", Rank.FIFTH.getPrizeMoney(), result.get(Rank.FIFTH));
        System.out.printf("4개 일치 (%,d원) - %d개\n", Rank.FOURTH.getPrizeMoney(), result.get(Rank.FOURTH));
        System.out.printf("5개 일치 (%,d원) - %d개\n", Rank.THIRD.getPrizeMoney(), result.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개\n", Rank.SECOND.getPrizeMoney(), result.get(Rank.SECOND));
        System.out.printf("6개 일치 (%,d원) - %d개\n", Rank.FIRST.getPrizeMoney(), result.get(Rank.FIRST));
    }

    public void printProfitability(double profitability) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitability);
    }
}
