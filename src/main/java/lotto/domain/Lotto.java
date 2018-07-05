package lotto.domain;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int A_LOTTO_COUNT = 6;

    private Set <LottoNo> numbers;

    public Lotto(Set<LottoNo> numbers) {
        this.numbers = numbers;
        if (!isValidLottoNumbers())
            throw new IllegalArgumentException("로또 번호가 잘못됐습니다.");

    }

    public Set<LottoNo> getNumbers() {
        return numbers;
    }

    public int getMatchCount(Lotto winLotto) {

        return winLotto.getNumbers().stream()
                .filter(number -> numbers.contains(number))
                .collect(Collectors.toList()).size();
    }

    public boolean isWinner(Lotto winLotto){
        return LottoState.isWinner(getMatchCount(winLotto));
    }


    public String buildLottoString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        Iterator<LottoNo> itr = numbers.iterator();
        result.append(itr.next().getNumber());
        while(itr.hasNext()){
            result.append(", " + itr.next().getNumber());
        }
        result.append("]");
        return result.toString();
    }

    boolean isValidLottoNumbers() {
        if(!isValidSize())
            return false;

        return true;
    }

    private boolean isValidSize() {
        if (numbers == null)
            throw new IllegalArgumentException();

        if (Lotto.A_LOTTO_COUNT != numbers.size())
            return false;
        return true;
    }


}
