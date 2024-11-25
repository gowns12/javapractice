package joon.java_practice;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ListLoop {
    @Test
    void sortOrder() {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(80);
        scores.add(60);
        scores.add(70);
        scores.add(100);
        scores.add(90);

        System.out.println(sumScores(scores));


    }

    int sumScores(ArrayList<Integer> scores){
        int sum=0;
        for(Integer i : scores){
            sum+=i;
        }

        return sum;
    }
}
