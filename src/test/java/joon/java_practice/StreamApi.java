package joon.java_practice;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class StreamApi {
    @Test
    void streamTests() {
        System.out.println(Stream.of(100, 60, 35, 70, 38, 80).filter(i -> i < 40).toList());
        System.out.println(Stream.of(100, 60, 35, 70, 38, 80).filter(i -> i % 2 == 0).toList());
        System.out.println(Stream.of("백승수", "김신", "왕여", "박새로이", "천지훈").filter(str -> str.length() != 3).toList());
        System.out.println(Stream.of("왕건", "이성계", "부여풍", "이도", "이산", "궁예").filter(str -> str.startsWith("이")).toList());
        System.out.println(Stream.of("왕건", "이성계", "부여풍", "이도", "이산", "궁예").filter(str -> str.startsWith("이")).filter(str -> str.length() != 3).toList());

    }

    @Test
    void 필터_테스트_40보다_작은_수() {
        List<Integer> scores = List.of(100, 60, 35, 70, 38, 80);

        List<Integer> scoresBelow40 = scores.stream()
                .filter(i -> i < 40)
                .toList();

        assertThat(scoresBelow40).isEqualTo(List.of(35, 38));
    }

    @Test
    void 필터_테스트_짝수() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = numbers.stream().filter(i -> i % 2 == 0).toList();/* filter()를 사용하는 코드 */
        assertThat(evenNumbers).isEqualTo(List.of(2, 4, 6, 8, 10));
    }

    @Test
    void 필터_테스트_길이_3_아닌_이름() {
        List<String> names = List.of("왕건", "이성계", "이방원", "박새로이", "이도");

        List<String> filteredNames = names.stream().filter(str -> str.length() != 3).toList();

        assertThat(filteredNames).isEqualTo(List.of("왕건", "박새로이", "이도"));
    }

    @Test
    void 필터_테스트_이씨_이름() {
        List<String> names = List.of("왕건", "이성계", "이방원", "박새로이", "이도");

        List<String> filteredNames = names.stream().filter(str -> str.startsWith("이")).toList();

        assertThat(filteredNames).isEqualTo(List.of("이성계", "이방원", "이도"));
    }

    @Test
    void 필터_테스트_두_글자_이씨_이름() {
        List<String> names = List.of("왕건", "이성계", "이방원", "박새로이", "이도");

        List<String> filteredNames = names.stream().filter(str -> str.startsWith("이") && str.length() == 2).toList();

        assertThat(filteredNames).isEqualTo(List.of("이도"));
    }

    @Test
    void 맵_테스트_제곱() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<Integer> squaredNumbers = numbers.stream()
                .map(i -> i * i)
                .toList();

        assertThat(squaredNumbers).isEqualTo(List.of(1, 4, 9, 16, 25));
    }

    @Test
    void 맵_테스트_할인_적용() {
        List<Integer> 장바구니상품들가격 = List.of(100, 200, 300, 400, 500);

        List<Double> 할인적용된금액목록 = 장바구니상품들가격.stream()
                .map(i -> i * 0.9)
                .toList();

        assertThat(할인적용된금액목록).isEqualTo(List.of(90.0, 180.0, 270.0, 360.0, 450.0));
    }

    @Test
    void 맵_테스트_대문자화() {
        List<String> companies = List.of("google", "apple", "netflix");
        List<String> upperCasedCompanies = companies.stream().map(String::toUpperCase).toList();

        assertThat(upperCasedCompanies).isEqualTo(List.of("GOOGLE", "APPLE", "NETFLIX"));
    }

    @Test
    void 맵_테스트_짝수_홀수() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<String> evenOddNumbers = numbers.stream()
                .map(n -> {
                    return n % 2 == 0 ? "짝수" : "홀수";

                }).toList();

        assertThat(evenOddNumbers).isEqualTo(List.of("홀수", "짝수", "홀수", "짝수", "홀수"));
    }

    @Test
    void 필터_맵_테스트1() {
        // given
        List<Integer> prices = Arrays.asList(1000, 25000, 30000, 15000, 5000, 40000);

        List<Double> discountedPrices = prices.stream().filter(i -> i >= 20000).map(i -> i * 0.9).toList();
        assertThat(discountedPrices).hasSize(3);
        assertThat(discountedPrices).isEqualTo(List.of(22500.0, 27000.0, 36000.0));
    }

    @Test
    void 필터_맵_테스트2() {
        // given
        List<String> names = Arrays.asList("Kim", "Park", "Lee", "Choi", "Jung", "Kang");

        List<String> upperCasedNames = names.stream().filter(str -> str.length() >= 4).map(String::toUpperCase).toList();

        assertThat(upperCasedNames).hasSize(4);
        assertThat(upperCasedNames).isEqualTo(List.of("PARK", "CHOI", "JUNG", "KANG"));
    }

    @Test
    void sreamMap() {
        HashMap<String, String> member = new HashMap<>();

        member.put("ID", "아이디");
        member.put("PASSWORD", "비밀번호");
        member.put("NICKNAME", "닉네임");

        List<HashMap<String, String>> memberInfo = new ArrayList<>();

        memberInfo.add(member);

        System.out.println(memberInfo.stream()
                .map(h -> {
                    HashMap<String, String> memberCopy = new HashMap<>(member);
                    memberCopy.remove("PASSWORD");
                    return memberCopy;
                })
                .toList());

        System.out.println(memberInfo);

        memberInfo = memberInfo.stream().map(h -> {
            h.put("username", h.get("NICKNAME"));
            h.remove("NICKNAME");
            return h;
        }).toList();

        System.out.println(memberInfo);
    }


}
