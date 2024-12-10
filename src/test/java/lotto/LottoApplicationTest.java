package lotto;


import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class LottoApplicationTest {
    @Test
    void name() {
        List<Integer> numberList = new ArrayList<>(List.of(1,2,3,4,5,6));
        List<Integer> numberList2 = new ArrayList<>(List.of(1,2,3,4,5,7));;
        LottoNumbers lottoNumbers = new LottoNumbers(numberList);
        LottoNumbers lottoNumbers2 = new LottoNumbers(numberList2);
        List<LottoNumbers> lottoNumbersList = List.of(lottoNumbers);


        Assertions.assertThat(Util.rankList(lottoNumbersList,lottoNumbers2,7).get(0)).isEqualTo(Rank.SECOND);
    }
}
