package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class Statistics {

    private final Map<Rank, Integer> result;
    private final double profitability;

    public Statistics(Lottos userLottos, WinningLotto winningLotto, int purchasedMoney) {
        this.result = calculateResults(userLottos, winningLotto);
        this.profitability = calculateProfitability(purchasedMoney);
    }

    private Map<Rank, Integer> calculateResults(Lottos userLottos, WinningLotto winningLotto) {
        Map<Rank, Integer> stats = new EnumMap<>(Rank.class);
        for(Rank rank : Rank.values()) {
            stats.put(rank, 0);
        }

        for(Lotto lotto: userLottos.getLottos()) {
            Rank rank = lotto.calculateRank(winningLotto);
            stats.put(rank, stats.get(rank)+1);
        }
        return stats;
    }

    private double calculateProfitability(int purchasedMoney) {
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            totalPrize += (entry.getKey().getPrizeMoney() * entry.getValue());
        }

        if (purchasedMoney == 0) {
            return 0.0;
        }
        return ((double) totalPrize / purchasedMoney) * 100.0;
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public double getProfitability() {
        return profitability;
    }
}
