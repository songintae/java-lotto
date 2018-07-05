package lotto.domain;

import java.util.Objects;

public class LottoNo {


    private int number;

    public LottoNo(int number){
        if(!isValidBoundary(number))
            throw new IllegalArgumentException("잘못된 숫자를 입력했습니다.");
        this.number = number;
    }

    private boolean isValidBoundary(int number) {
        if (number < 1 || number > 45)
            return false;
        return true;
    }


    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }
}
