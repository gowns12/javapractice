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


//    List<List<Integer>> countDuplicateItems(List<Integer> priceList) {
//        HashMap<Integer, Integer> countDuplicatePriceHashMap = new HashMap<>();
//
//        //{가격=개수} 형태의 해시맵 생성
//        for (Integer i : priceList) {
//            countDuplicatePriceHashMap.put(i, countDuplicatePriceHashMap.getOrDefault(i, 0) + 1);
//        }
//
//
//        //가격리스트 중복 제거 후 오름차순 정렬
//        List<Integer> distinctSortedPriceList = priceList.stream()
//                .sorted()
//                .distinct()
//                .toList();
//
//        //[가격,개수]의 이중 리스트 생성
//        List<List<Integer>> countDuplicatePriceList = new ArrayList<>(List.of());
//
//        for (Integer i : distinctSortedPriceList) {
//            countDuplicatePriceList.add(List.of(i, countDuplicatePriceHashMap.get(i)));
//        }
//
//        return countDuplicatePriceList;
//    }


//    @Test
//    void countDuplicatePrice() {
//        assertThat(countDuplicateItems(List.of(1000, 2000, 1000, 3000, 2000))).isEqualTo(List.of(List.of(1000, 2), List.of(2000, 2), List.of(3000, 1)));
//        assertThat(countDuplicateItems(List.of(5000))).isEqualTo(List.of(List.of(5000, 1)));
//        assertThat(countDuplicateItems(List.of())).isEqualTo(List.of());
//    }

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
        System.out.println("가장 많이 등장한 문자열: " + biggestStr + " 횟수 : " + biggestCount);
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

        List<HashMap<String, String>> goods = new ArrayList<>();
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

    @Test
    void mapCreate() {
        HashMap<String, String> product1 = new HashMap<>();
        product1.put("상품명", "코멧 니트릴장갑 화이트");
        product1.put("상품가격", "6540");
        product1.put("카테고리", "주방용품");

        HashMap<String, String> product2 = new HashMap<>();
        product1.put("상품명", "라운드랩 1025 독도 로션, 400ml, 1개");
        product1.put("상품가격", "16,910");
        product1.put("카테고리", "뷰티");

        HashMap<String, String> product3 = new HashMap<>();
        product1.put("상품명", "라운드랩 1025 독도 로션, 400ml, 1개");
        product1.put("상품가격", "16,910");
        product1.put("카테고리", "식품");

        HashMap<String, String> human1 = new HashMap<>();
        product1.put("이름", "박효신");
        product1.put("생년월일", "810901");
        product1.put("국적", "대한민국");

        HashMap<String, String> human2 = new HashMap<>();
        product1.put("이름", "마동석");
        product1.put("생년월일", "710301");
        product1.put("국적", "미국");

        HashMap<String, String> movie1 = new HashMap<>();
        product1.put("제목", "범죄도시");
        product1.put("감독", "강윤성");
        product1.put("개봉일", "2017-10-03");

        HashMap<String, String> movie2 = new HashMap<>();
        product1.put("제목", "다크나이트");
        product1.put("감독", "크리스토퍼 놀란");
        product1.put("개봉일", "2008-08-06");
    }

    boolean myContains(ArrayList<String> names, String name) {

        boolean contains = false;

        for (String s : names) {
            if (s.equals(name)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    @Test
    void myContainsTest() {
        ArrayList<String> names = new ArrayList<>();
        names.add("박효신");
        names.add("이지은");
        names.add("하현우");

        boolean 하현우존재여부 = myContains(names, "하현우");
        boolean 잔나비존재여부 = myContains(names, "잔나비");

        assertThat(하현우존재여부).isTrue();
        assertThat(잔나비존재여부).isFalse();
    }

//    List<Integer> getCommonElements(List<Integer> integers1, List<Integer> integers2) {
//        List<Integer> commonElements = new ArrayList<>(List.of());
//
//        for (Integer i : integers1) {
//            for (Integer integer : integers2) {
//                if (i == integer) {
//                    commonElements.add(i);
//                }
//            }
//        }
//
//        return commonElements;
//    }

    List<Integer> getCommonElements(List<Integer> integers1, List<Integer> integers2) {
        HashMap<Integer, Integer> integers1Map = new HashMap<>();
        HashMap<Integer, Integer> integers2Map = new HashMap<>();

        List<Integer> commonElements = new ArrayList<>(List.of());
        int j = 0;
        for (Integer i : integers1) {

            integers1Map.put(j,i);
            j++;
        }

        j = 0;
        for (Integer i : integers2) {
            integers2Map.put(j,i);
            j++;
        }

        for (Integer value : integers1Map.values()) {
            if (integers2Map.containsValue(value)){
                commonElements.add(value);
            }
        }

        return commonElements;
    }



    @Test
    void getCommonElementsTest() {
        List<Integer> firstList = List.of(1, 2, 3);
        List<Integer> secondList = List.of(2, 3, 4);

        List<Integer> commonElements = getCommonElements(firstList, secondList);

        assertThat(commonElements)
                .containsExactlyInAnyOrder(2, 3);
    }

    int myFrequency(ArrayList<String> names,String name){
        HashMap<String, Integer> duplicatenameMap = new HashMap<>();

        for (String str : names) {
            duplicatenameMap.put(str,duplicatenameMap.getOrDefault(str,0)+1);
        }

        return duplicatenameMap.get(name);
    }

    HashMap<String,Integer> countNameOccurrences(List<String> names){
        HashMap<String, Integer> duplicatenameMap = new HashMap<>();

        for (String str : names) {
            duplicatenameMap.put(str,duplicatenameMap.getOrDefault(str,0)+1);
        }

        return duplicatenameMap;
    }

    @Test
    void myFrequencyTest() {
        ArrayList<String> names = new ArrayList<>();
        names.add("박효신");
        names.add("이지은");
        names.add("이지은");
        names.add("하현우");
        names.add("하현우");
        names.add("하현우");

        int 박효신Count = myFrequency(names, "박효신");
        int 이지은Count = myFrequency(names, "이지은");
        int 하현우Count = myFrequency(names, "하현우");

        assertThat(박효신Count).isEqualTo(1);
        assertThat(이지은Count).isEqualTo(2);
        assertThat(하현우Count).isEqualTo(3);
    }


    @Test
    void countNameOccurrencesTest() {
        List<String> names = List.of(
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

        Map<String, Integer> countsByName = countNameOccurrences(names);

        assertThat(countsByName).containsEntry("추민영", 2)
                .containsEntry("문성희", 1)
                .containsEntry("전지예", 1)
                .containsEntry("정해준", 1)
                .containsEntry("김성락", 2)
                .containsEntry("이호연", 1)
                .containsEntry("권상윤", 3)
                .containsEntry("황승혁", 3)
                .containsEntry("박현지", 2)
                .containsEntry("김민성", 1)
                .containsEntry("이채현", 1)
                .containsEntry("문인혁", 2)
                .containsEntry("황효진", 2)
                .containsEntry("윤찬영", 1)
                .containsEntry("윤태우", 1)
                .containsEntry("허재", 1);
    }

    List<List<Integer>> countDuplicateItems(List<Integer> items){
        HashMap<Integer, Integer> countDuplicateItemsMap = new HashMap<>();

        for (Integer item : items) {
            countDuplicateItemsMap.put(item,countDuplicateItemsMap.getOrDefault(item,0)+1);
        }

        List<List<Integer>> countDuplicateItems = new ArrayList<>(List.of());

        for (Map.Entry<Integer, Integer> integerIntegerEntry : countDuplicateItemsMap.entrySet()) {
            countDuplicateItems.add(List.of(integerIntegerEntry.getKey(),integerIntegerEntry.getValue()));
        }

        return  countDuplicateItems;
    }

    @Test
    void countDuplicateItemsTest() {
        assertThat(countDuplicateItems(List.of(1000, 2000, 1000, 3000, 2000))).containsExactlyInAnyOrder(List.of(1000, 2), List.of(2000, 2), List.of(3000, 1));
        assertThat(countDuplicateItems(List.of(5000))).containsExactlyInAnyOrder(List.of(5000, 1));
        assertThat(countDuplicateItems(List.of())).isEqualTo(List.of());
    }

    @Test
    void citypopulation() {
        HashMap<String, String> 제주 = new HashMap<>();
        HashMap<String, String> 강릉 = new HashMap<>();
        HashMap<String, String> 울산 = new HashMap<>();

        제주.put("이름","제주");
        제주.put("인구수","670837명");

        강릉.put("이름","강릉");
        강릉.put("인구수","207988명");

        울산.put("이름","울산");
        울산.put("인구수","1098540명");

        List<HashMap<String,String>> 도시별정보 = new ArrayList<>(List.of(제주,강릉,울산));
        ArrayList<List<String>> 도시별인구수 = new ArrayList<>(List.of());

        for (HashMap<String, String> stringStringHashMap : 도시별정보) {
            도시별인구수.add(List.of(stringStringHashMap.get("이름"),stringStringHashMap.get("인구수")));
        }

        System.out.println(도시별인구수);
    }
}


