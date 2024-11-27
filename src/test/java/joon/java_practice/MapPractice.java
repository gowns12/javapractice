package joon.java_practice;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;


public class MapPractice {
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


        List<String> distinctNameList = new ArrayList<>(nameList.stream().distinct().toList());
        HashMap<String, Integer> nameHashMap2 = new HashMap<>();
        for (String name : distinctNameList) {
            nameHashMap2.put(name, Collections.frequency(nameList, name));
        }

        System.out.println(nameHashMap);
        System.out.println(nameHashMap2);

    }


    List<List<Integer>> countDuplicateItems(List<Integer> priceList) {
        HashMap<Integer, Integer> countDuplicatePriceHashMap = new HashMap<>();

        //{가격=개수} 형태의 해시맵 생성
        for (Integer i : priceList) {
            countDuplicatePriceHashMap.put(i,countDuplicatePriceHashMap.getOrDefault(i,0)+1);
        }


        //가격리스트 중복 제거 후 오름차순 정렬
        List<Integer> distinctSortedPriceList = priceList.stream()
                .sorted()
                .distinct()
                .toList();

        //[가격,개수]의 이중 리스트 생성
        List<List<Integer>> countDuplicatePriceList = new ArrayList<>(List.of());

        for (Integer i : distinctSortedPriceList) {
            countDuplicatePriceList.add(List.of(i,countDuplicatePriceHashMap.get(i)));
        }

        return countDuplicatePriceList;
    }


    @Test
    void countDuplicatePrice() {
        assertThat(countDuplicateItems(List.of(1000, 2000, 1000, 3000, 2000))).isEqualTo(List.of(List.of(1000, 2), List.of(2000, 2), List.of(3000, 1)));
        assertThat(countDuplicateItems(List.of(5000))).isEqualTo(List.of(List.of(5000, 1)));
        assertThat(countDuplicateItems(List.of())).isEqualTo(List.of());
    }

    @Test
    void hashMap() {
        Map<String, String> englishKorean = new HashMap<>();
        englishKorean.put("book", "책");
        englishKorean.put("apple", "사가ㅗ"); // 이 코드를 수정하지 마세요
        englishKorean.put("car", "자동차");

// 아래에 코드 한 줄 추가
        englishKorean.put("apple", "사과");

// 아래 테스트를 통과해야 합니다
        assertThat(englishKorean).containsEntry("apple", "사과");
    }

    // 문제: HashMap을 사용하여 다음 작업을 수행하세요:
// 1. 학생 이름(String)과 나이(Integer)를 저장하는 Map을 생성하세요
// 2. 3명의 학생 정보를 추가하세요
// 3. 특정 학생의 나이를 출력하세요
    @Test
    void studentAgeMap() {
        // 여기에 코드 작성
        HashMap<String, Integer> studentsAndAge = new HashMap<>();
        studentsAndAge.put("정해준", 26);
        studentsAndAge.put("홍길동", 15);
        studentsAndAge.put("철수", 21);

        System.out.println(studentsAndAge.get("정해준"));
    }

    // 문제: 다음 작업을 수행하는 메서드를 작성하세요:
// 1. 과일 이름(String)과 가격(Integer)을 저장하는 Map을 생성하세요
// 2. 모든 과일의 이름과 가격을 출력하세요
// 3. 특정 과일의 가격을 업데이트하세요
// 4. 가격이 특정 금액 이상인 과일들만 출력하세요
    @Test
    void fruitPriceMap() {
        // 여기에 코드 작성
        HashMap<String, Integer> fruitsPrice = new HashMap<>();
        fruitsPrice.put("사과", 2000);
        fruitsPrice.put("바나나", 3000);
        fruitsPrice.put("귤", 2500);
        fruitsPrice.put("포도", 4000);
        fruitsPrice.put("복숭아", 5500);

        fruitsPrice.put("바나나", 2900);

        for (String s : fruitsPrice.keySet()) {
            if (fruitsPrice.get(s) >= 3000) {
                System.out.println(s);
            }
        }
    }

    // 문제: 문자열 배열이 주어졌을 때:
// 1. 각 문자열이 몇 번 등장하는지 카운트하는 Map을 만드세요
// 2. 가장 많이 등장한 문자열과 그 횟수를 출력하세요
    void countOccurrences(List<String> words) {
        // 여기에 코드 작성
        HashMap<String, Integer> countStringsMap = new HashMap<>();

        for (String word : words) {

            if (countStringsMap.get(word) == null) {
                countStringsMap.put(word, 1);
            } else {
                countStringsMap.put(word, countStringsMap.get(word) + 1);
            }

        }

        int biggestCount = 0;
        String biggestStr = "";

        for (String str : countStringsMap.keySet()) {
            if (countStringsMap.get(str) > biggestCount) {
                biggestCount = countStringsMap.get(str);
                biggestStr = str;
            }
        }
        System.out.println("가장 많이 등장한 문자열: "+biggestStr+" 횟수 : "+biggestCount);
    }

    @Test
    void count() {
        countOccurrences(List.of("s", "sd", "d", "s", "f", "d", "d"));
    }

    @Test
    void intersection() {
        ArrayList<Integer> int1 = new ArrayList<>(List.of(1, 2, 3, 4));
        ArrayList<Integer> int2 = new ArrayList<>(List.of(2, 4, 5, 6));

        HashMap<Integer, Integer> intHashMap = new HashMap<>();

        for (int i = 0; i < int1.size(); i++) {
            intHashMap.put(int1.get(i), int2.get(i));
        }

        ArrayList<Integer> intersectionIntList = new ArrayList<>(List.of());


        for (Integer i : intHashMap.keySet()) {
            if (intHashMap.containsValue(i)) {
                intersectionIntList.add(i);
            }
        }

        System.out.println(intersectionIntList);
    }

    @Test
    void mainCity() {
        HashMap<String, List<String>> mainCityMap = new HashMap<>();

        mainCityMap.put("한국", List.of("제주", "강릉", "부여"));
        mainCityMap.put("미국", List.of("뉴욕", "LA", "디트로이트"));
        mainCityMap.put("독일", List.of("함부르크", "뮌헨", "프랑크푸르트"));

        System.out.println(mainCityMap);
    }

    @Test
    void goodsList() {
        HashMap<String, String> goods1 = new HashMap<>();
        goods1.put("상품명", "칙촉"); //{"상품명, "칙촉"}
        goods1.put("가격", "2000원");
        goods1.put("카테고리", "식품");

        HashMap<String, String> goods2 = new HashMap<>();
        goods2.put("상품명", "세탁 건조 일체형 워시 콤보");
        goods2.put("가격", "400만원");
        goods2.put("카테고리", "가전");

        HashMap<String, String> goods3 = new HashMap<>();
        goods3.put("상품명", "바나나우유");
        goods3.put("가격", "1700원");
        goods3.put("카테고리", "식품");

        List<HashMap<String,String>> goods = new ArrayList<>();
        goods.add(goods1);
        goods.add(goods2);
        goods.add(goods3);

        System.out.println(goods);
        System.out.println(List.of(goods1, goods2, goods3));
    }

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participantMap = new HashMap<>();
        HashMap<String, Integer> completionMap = new HashMap<>();

        for (String s : participant) {
            participantMap.put(s, participantMap.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            participantMap.put(s, participantMap.get(s) - 1);
        }

        String loser = "";

        for (Map.Entry<String, Integer> stringIntegerEntry : participantMap.entrySet()) {
            if (stringIntegerEntry.getValue() != 0) {
                loser = stringIntegerEntry.getKey();
            }
        }
        return loser;
    }
}


