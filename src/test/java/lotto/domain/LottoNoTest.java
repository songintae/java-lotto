package lotto.domain;

import org.assertj.core.util.Sets;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LottoNoTest {


    @Test(expected = IllegalArgumentException.class)
    public void createInvalidLottoTest_숫자범위_불일치() {
        new LottoNo(60);
    }
}