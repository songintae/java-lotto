package lotto.domain;

import java.util.*;

public class LottoResult {
    private Map<LottoState, Integer> matchCounter = new LinkedHashMap<LottoState, Integer>() {{
        put(LottoState.FORTH, 0);
        put(LottoState.THIRD, 0);
        put(LottoState.SECOND, 0);
        put(LottoState.FIRST, 0);
    }};
    private int investMoney;


    public LottoResult(List<LottoState> winners, int investMoney) {
        for (LottoState winner : winners) {
            matchCounter.put(winner
                    , matchCounter.get(winner) + 1);
        }
        this.investMoney = investMoney;
    }

    public int getTotalReword() {
        int totalReword = 0;
        Iterator<LottoState> itr = matchCounter.keySet().iterator();
        LottoState key = null;
        while (itr.hasNext()) {
            key = itr.next();
            totalReword += key.getReward() * matchCounter.get(key);
        }

        return totalReword;
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder();
        result.append("\n당첨 통계\n");
        result.append("---------\n");

        Iterator<LottoState> itr = matchCounter.keySet().iterator();
        LottoState key = null;
        while (itr.hasNext()) {
            key = itr.next();
            result.append(key.getMatchCount() + "개 일치 (" + key.getReward() + ")- " + matchCounter.get(key) + "개\n");
        }
        result.append("총 수익률은 " + String.format("%.1f", getProfit()) + "%입니다.");
        return result.toString();
    }

    public double getProfit() {
        return (double) getTotalReword() / investMoney * 100;
    }
}
