
package lotto.domain;

import org.assertj.core.util.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void createLottoNullExceptionTest() {
        new Lotto(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createLottoOutboundExceptionTest() {
        new Lotto(Sets.newHashSet(new ArrayList<>()));
    }

    @Test
    public void getMatchCountTest() {
        Lotto lotto = new Lotto(Sets.newHashSet(Arrays.asList(
                new LottoNo(1),
                new LottoNo(2),
                new LottoNo(3),
                new LottoNo(4),
                new LottoNo(5),
                new LottoNo(6)
        )));

        Lotto winLotto = new Lotto(Sets.newHashSet(Arrays.asList(
                new LottoNo(1),
                new LottoNo(2),
                new LottoNo(3),
                new LottoNo(7),
                new LottoNo(8),
                new LottoNo(9)
        )));


        assertEquals(3, lotto.getMatchCount(winLotto));
    }

    @Test
    public void buildLottoStringTest() {
        Lotto lotto = new Lotto(Sets.newHashSet(Arrays.asList(
                new LottoNo(1),
                new LottoNo(2),
                new LottoNo(3),
                new LottoNo(4),
                new LottoNo(5),
                new LottoNo(6)
        )));
        String expected = "[1, 2, 3, 4, 5, 6]";
        assertEquals(expected, lotto.buildLottoString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidLottoTest_숫자개수_불일치() {
        Lotto lotto = new Lotto(Sets.newHashSet(Arrays.asList(
                new LottoNo(1),
                new LottoNo(2),
                new LottoNo(3),
                new LottoNo(4),
                new LottoNo(5)
        )));
    }


    @Test(expected = IllegalArgumentException.class)
    public void createInvalidLottoTest_숫자중복_체크() {
        Lotto lotto = new Lotto(Sets.newHashSet(Arrays.asList(
                new LottoNo(1),
                new LottoNo(2),
                new LottoNo(3),
                new LottoNo(4),
                new LottoNo(5),
                new LottoNo(5)
        )));
    }


}
