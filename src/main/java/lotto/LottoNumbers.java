package lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private List<Integer> lottoList;

    public LottoNumbers(List<Integer> numberList) {
        Collections.shuffle(numberList);
        this.lottoList = new ArrayList<>(List.of(numberList.get(0),numberList.get(1),numberList.get(2)
                ,numberList.get(3),numberList.get(4),numberList.get(5)));
    }

    public LottoNumbers(int number1, int number2, int number3, int number4, int number5, int number6) {
        List<Integer> temp = new ArrayList<>(List.of(number1,number2,number3,number4,number5,number6));
        for (Integer i : temp) {
            if (i>45 || i<1){
                throw new IllegalArgumentException("번호는 1~45까지만 입력가능합니다.");
            }
        }
        this.lottoList = temp;
    }

    public List<Integer> getLottoList() {
        return lottoList;
    }

    public void print(){
        System.out.println(lottoList);
    }
}
