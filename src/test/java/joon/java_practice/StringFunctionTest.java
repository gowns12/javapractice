package joon.java_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.FLOAT_ARRAY;

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

    List<Integer> calculateRanks(List<Integer> scores){
        List<Integer> sortedScores = scores.stream().sorted(Comparator.reverseOrder()).toList();
        new ArrayList<Integer> answer = scores;
        for (int i = 0; i < sortedScores.size(); i++) {
            answer.replaceAll(sortedScores.get(0),1);
        }

        }
    }

}
