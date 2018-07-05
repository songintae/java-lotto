package lotto.domain;

import org.assertj.core.util.Sets;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class LottoGameTest {

    private LottoGame game;

    Lotto lotto1 = null;
    Lotto lotto2 = null;
    Lotto lotto3 = null;

    @Before
    public void setup() {
        game = new LottoGame();
        lotto1 = new Lotto(Sets.newHashSet(Arrays.asList(
                new LottoNo(1),
                new LottoNo(2),
                new LottoNo(3),
                new LottoNo(4),
                new LottoNo(5),
                new LottoNo(6)
        )));

        lotto2 = new Lotto(Sets.newHashSet(Arrays.asList(
                new LottoNo(1),
                new LottoNo(2),
                new LottoNo(3),
                new LottoNo(4),
                new LottoNo(5),
                new LottoNo(7)
        )));

        lotto3 = new Lotto(Sets.newHashSet(Arrays.asList(
                new LottoNo(1),
                new LottoNo(9),
                new LottoNo(8),
                new LottoNo(7),
                new LottoNo(11),
                new LottoNo(2)
        )));
    }

    @Test
    public void generateTest() {
        assertEquals(2, game.generate(2000).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputExceptionTest() {
        game.generate(999);
    }


    @Test
    public void collectionShuffleStudyTest() {
        List<Integer> testCase = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);

        Collections.shuffle(testCase);
        assertThat(expected, not(testCase));
    }

    @Test
    public void getWinnersTest() {
        List<Lotto> testCase = new ArrayList<>(Arrays.asList(
                lotto1,
                lotto2,
                lotto3
        ));

        game.setWinLotto(lotto1);
        List<LottoState> winners = game.getWinners(testCase);
        assertEquals(2, winners.size());
    }
}