package lotto.model;

public enum Rank {

    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    NONE(0, 0L);

    private final int matchCount;
    private final long prize;

    Rank(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public long getPrizeMoney() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
