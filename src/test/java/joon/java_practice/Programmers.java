package joon.java_practice;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Programmers {
    @Test
    public void sa() {
        int[] numbers = {3, 30, 34, 5, 9};

        ArrayList<String> numbersList = (ArrayList<String>) Arrays.stream(numbers).boxed().map(String::valueOf).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (int i = 0; i < numbers.length; i++) {
            for (int i1 = i+1; i1 < numbersList.size(); i1++) {
                String temp = numbersList.get(i);
                if (temp.charAt(0)==numbersList.get(i1).charAt(0)&&i<i1){
                    if (Integer.parseInt(temp)%10<Integer.parseInt(numbersList.get(i1))%10){
                        temp = numbersList.get(i1);
                        numbersList.set(i1, numbersList.get(i));
                        numbersList.set(i, temp);
                    }
                }
            }
        }

        System.out.println(numbersList.stream().map(String::valueOf).collect(Collectors.joining()));
    }
}
