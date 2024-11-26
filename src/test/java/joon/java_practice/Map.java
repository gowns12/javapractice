package joon.java_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.*;


public class Map {
    @Test
    void goodsReduce() {
        HashMap<String, Integer> productStock = new HashMap<>();
        productStock.put("갤럭시 S24", 8);
        productStock.put("삼다수 2L", 20);
        productStock.put("칙촉 오리지널 6+2입 120g", 10);
        productStock.put("M4 맥북 프로", 5);

// 아래에 코드를 작성해 주세요
        productStock.put("갤럭시 S24", productStock.get("갤럭시 S24") - 1);
        productStock.put("M4 맥북 프로", productStock.get("M4 맥북 프로") - 1);
// 🚫 productStock.put("갤럭시 S24", 7);
// 🚫 productStock.put("M4 맥북 프로", 4);


// 아래 테스트를 통과해야 합니다
        assertThat(productStock.get("갤럭시 S24")).isEqualTo(7);
        assertThat(productStock.get("M4 맥북 프로")).isEqualTo(4);
    }

    @Test
    void sameName() {

        List<String> nameList = List.of(
                "권상윤",
                "김민성",
                "추민영",
                "김성락",
                "황승혁",
                "문성희",
                "문인혁",
                "박현지",
                "윤찬영",
                "윤태우",
                "권상윤",
                "이채현",
                "황효진",
                "권상윤",
                "황승혁",
                "박현지",
                "이호연",
                "전지예",
                "정해준",
                "문인혁",
                "김성락",
                "추민영",
                "허재",
                "황승혁",
                "황효진"
        );

        HashMap<String, Integer> nameHashMap = new HashMap<>();
        for (String str : nameList) {
            if (nameHashMap.get(str) == null) {
                nameHashMap.put(str, 1);
            } else {
                nameHashMap.put(str, nameHashMap.get(str) + 1);
            }
        }

        System.out.println(nameHashMap);

    }


    List<List<Integer>> countDuplicateItems(List<Integer> priceList) {
        HashMap<Integer, Integer> countDuplicatePriceHashMap = new HashMap<>();

        //{가격=개수} 형태의 해시맵 생성
        for (Integer i : priceList) {
            if (countDuplicatePriceHashMap.get(i) == null) {
                countDuplicatePriceHashMap.put(i, 1);
            } else {
                countDuplicatePriceHashMap.put(i, countDuplicatePriceHashMap.get(i) + 1);
            }
        }


        //가격리스트 중복 제거 후 오름차순 정렬
        List<Integer> distinctSortedPriceList = priceList.stream()
                .sorted()
                .distinct()
                .toList();

        //[가격,개수]의 이중 리스트 생성
        List<List<Integer>> countDuplicatePriceList = new ArrayList<>(List.of());

        for (Integer i : distinctSortedPriceList) {
            List<Integer> tempList = new ArrayList<>(List.of());
            tempList.add(i);
            tempList.add(countDuplicatePriceHashMap.get(i));
            countDuplicatePriceList.add(tempList);
        }

        return countDuplicatePriceList;
    }

    @Test
    void countDuplicatePrice() {
        assertThat(countDuplicateItems(List.of(1000, 2000, 1000, 3000, 2000))).isEqualTo(List.of(List.of(1000, 2), List.of(2000, 2), List.of(3000, 1)));
        assertThat(countDuplicateItems(List.of(5000))).isEqualTo(List.of(List.of(5000, 1)));
        assertThat(countDuplicateItems(List.of())).isEqualTo(List.of());
    }

    public String solution(String[] participant, String[] completion) {
        HashSet<String> completionSet = new HashSet<String>(Arrays.asList(completion));
        String loser = "";
        for (String str : participant) {
            if (completionSet.add(str)) {
                loser = str;
            }
        }
        return loser;
    }

    @Test
    void name() {
        String[] str1 = {"leo", "kiki", "eden"};
        String[] str2 = {"eden", "kiki"};
        System.out.println(solution(str1, str2));
    }
}


