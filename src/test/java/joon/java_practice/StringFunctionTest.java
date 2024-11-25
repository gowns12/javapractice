package joon.java_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
}
