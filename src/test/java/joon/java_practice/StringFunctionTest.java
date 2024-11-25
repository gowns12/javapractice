package joon.java_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.*;

import java.util.Map.Entry;

public class StringFunctionTest {
    @Test
    void ListLoop() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(80);
        scores.add(60);
        scores.add(70);
        scores.add(100);
        scores.add(90);
        scores.add(50);

        int sum = 0;
        for (Integer score : scores) {
            sum += score;
        }

        System.out.println("점수의 총 합은: " + sum);

        System.out.println("점수의 평균은: " + (sum / scores.size()));

        System.out.println("최고 점수는: " + maxList(scores));

        System.out.println("최저 점수는: " + minList(scores));

        System.out.println("평균값보다 낮은 점수의 리스트: " + avgLow(scores));

        System.out.println("평균값보다 높은 점수의 리스트: " + avgHigh(scores));

        Collections.sort(scores);

        System.out.println("오름차순 정렬 : " + scores);

        System.out.println("중앙값은 " + centerValue(scores));

    }

    int maxList(ArrayList<Integer> List) {
        int answer = 0;
        for (int i = 0; i < List.size(); i++) {
//            answer = integer >= answer ? integer : answer;
            if (List.get(i) >= answer) {
                answer = List.get(i);
            }
        }

        return answer;
    }

    int minList(ArrayList<Integer> List) {
        int answer = List.get(0);
        for (Integer integer : List) {
            answer = integer <= answer ? integer : answer;
        }
        return answer;
    }

    int sum(ArrayList<Integer> List) {
        int sum = 0;
        for (Integer list : List) {
            sum += list;
        }
        return sum;
    }

    ArrayList<Integer> avgLow(ArrayList<Integer> List) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int avg = sum(List) / List.size();
        for (Integer list : List) {
            if (list < avg) {
                answer.add(list);
            }
        }
        return answer;
    }

    ArrayList<Integer> avgHigh(ArrayList<Integer> List) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int avg = sum(List) / List.size();
        for (Integer list : List) {
            if (list > avg) {
                answer.add(list);
            }
        }
        return answer;
    }

    ArrayList<Integer> centerValue(ArrayList<Integer> scores) {
        ArrayList<Integer> answer = new ArrayList<>();
        if (scores.size() % 2 == 0) {
            answer.add(scores.get(scores.size() / 2 - 1));
            answer.add(scores.get(scores.size() / 2));
        } else {
            answer.add(scores.get(scores.size() / 2));
        }
        return answer;
    }

    @Test
    void test() {
        ArrayList<String> 과일 = new ArrayList<>();
        과일.add("사과");
        과일.add("바나나");

        copyTest(과일);

        System.out.println(과일);

    }

    void copyTest(ArrayList<String> list) {
        list.add("추가");
    }

    @Test
    void listFunction() {
        assertThat(getSum(List.of(1, 2, 3, 4))).isEqualTo(10);
        assertThat(getSum(List.of(7))).isEqualTo(7);
        assertThat(getSum(List.of())).isEqualTo(0); // 빈 리스트가 주어질 경우 0을 return

        assertThat(getAverage(List.of(1, 2, 3, 4))).isEqualTo(2.5);
        assertThat(getAverage(List.of(7))).isEqualTo(7.0);
        assertThat(getAverage(List.of())).isEqualTo(0.0); // 빈 리스트가 주어질 경우 0 return

        assertThat(findMax(List.of(3, 10, 5, 4, 7))).isEqualTo(10);
        assertThat(findMax(List.of(7))).isEqualTo(7);

        assertThat(findMin(List.of(3, 10, 5, 4, 7))).isEqualTo(3);
        assertThat(findMin(List.of(7))).isEqualTo(7);

        assertThat(getIntegersBetween(1, 5)).isEqualTo(List.of(1, 2, 3, 4, 5));
        assertThat(getIntegersBetween(-3, 1)).isEqualTo(List.of(-3, -2, -1, 0, 1));
        assertThat(getIntegersBetween(3, 3)).isEqualTo(List.of(3));
        assertThat(getIntegersBetween(5, 1)).containsExactlyInAnyOrder(5, 4, 3, 2, 1);

        assertThat(filterPositive(List.of(-1, 2, -3, 4, 0))).isEqualTo(List.of(2, 4));
        assertThat(filterPositive(List.of(-1, -2, -3))).isEqualTo(List.of());
        assertThat(filterPositive(List.of())).isEqualTo(List.of());

        assertThat(findPassedStudents(List.of(70, 85, 90, 75, 80))).isEqualTo(List.of(85, 90, 80));
        assertThat(findPassedStudents(List.of(70, 75, 79))).isEqualTo(List.of());
        assertThat(findPassedStudents(List.of(80, 85, 90))).isEqualTo(List.of(80, 85, 90));

        assertThat(removeDuplicates(List.of(1, 2, 2, 3, 4, 4, 5))).isEqualTo(List.of(1, 2, 3, 4, 5));
        assertThat(removeDuplicates(List.of(1, 1, 1, 1))).isEqualTo(List.of(1));
        assertThat(removeDuplicates(List.of())).isEqualTo(List.of());

        assertThat(calculateRanks(List.of(80, 90, 70, 85))).isEqualTo(List.of(3, 1, 4, 2));
        assertThat(calculateRanks(List.of(100, 100, 80))).isEqualTo(List.of(1, 1, 3));
        assertThat(calculateRanks(List.of())).isEqualTo(List.of());
    }

    int getSum(List<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        return sum;
    }

    double getAverage(List<Integer> list) {
        int sum = getSum(list);
        return list.isEmpty() ? 0 : (double) sum / (double) list.size();
    }

    int findMax(List<Integer> list) {
        int answer = 0;
        for (int i : list) {
            if (answer < i) {
                answer = i;
            }
        }
        return answer;
    }

    int findMin(List<Integer> list) {
        int answer = list.get(0);
        for (int i : list) {
            if (answer > i) {
                answer = i;
            }
        }
        return answer;
    }

    List<Integer> getIntegersBetween(int a, int b) {
        return a < b ? IntStream.rangeClosed(a, b).boxed().toList() : IntStream.rangeClosed(b, a).boxed().toList();
    }

    List<Integer> filterPositive(List<Integer> lsit) {
        Stream<Integer> answer = lsit.stream();
        return answer.filter(i -> i % 2 == 0 && i > 0).toList();
    }

    List<Integer> findPassedStudents(List<Integer> scores) {
        Stream<Integer> answer = scores.stream();
        return answer.filter(i -> i >= 80).toList();
    }

    List<Integer> removeDuplicates(List<Integer> numbers) {
        Stream<Integer> answer = numbers.stream();
        return answer.distinct().toList();
    }

    List<Integer> calculateRanks(List<Integer> scores) {
        List<Integer> ranking = scores.stream().sorted().toList();
        List<Integer> answer = new ArrayList<>(List.of());
        for (Integer i : scores) {
            for (Integer j : ranking) {
                if (i == j) {
                    answer.add(ranking.size() - ranking.lastIndexOf(i));
                    break;
                }
            }
        }
        return answer;
    }

    int calculateTotalPrice(List<Integer> priceList) {
        return getSum(priceList);
    }

    @Test
    void shoppingCart() {
        assertThat(calculateTotalPrice(List.of(1000, 2000, 3000))).isEqualTo(6000);
        assertThat(calculateTotalPrice(List.of(5000))).isEqualTo(5000);
        assertThat(calculateTotalPrice(List.of())).isEqualTo(0);

        assertThat(applyDiscount(List.of(1000, 2000, 3000), 10)).isEqualTo(List.of(900, 1800, 2700));
        assertThat(applyDiscount(List.of(5000), 50)).isEqualTo(List.of(2500));
        assertThat(applyDiscount(List.of(), 20)).isEqualTo(List.of());

        assertThat(filterExpensiveItems(List.of(1000, 2000, 3000, 4000), 2500)).isEqualTo(List.of(3000, 4000));
        assertThat(filterExpensiveItems(List.of(1000, 1500, 2000), 3000)).isEqualTo(List.of());
        assertThat(filterExpensiveItems(List.of(), 2000)).isEqualTo(List.of());

    }

    List<Integer> applyDiscount(List<Integer> priceList, double discountRate) {
        List<Integer> answer = new ArrayList<>();
        for (Integer i : priceList) {
            answer.add((int) Math.round(i * (1 - discountRate / 100)));
        }
        return answer;
    }

    List<Integer> filterExpensiveItems(List<Integer> priceList, int standardPrice) {
        Stream<Integer> answer = priceList.stream();
        return answer.filter(i -> i >= standardPrice).toList();
    }
}


