package joon.java_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MyTest {
    int square(int n) {
        return n * n;
    }

    int add(int a, int b) {
        return a + b;
    }

    int getAverage(int a, int b, int c){
        return (a + b + c) / 3;
    }

    int calculateBirthYear(int age){
        return 2025-age;
    }

    boolean isPositive(int n){
        if (n>0){
            return true;
        }
        else {
            return false;
        }
    }

    int getBigger(int a, int b){
        return Math.max(a,b);
    }

    int getBiggest(int a, int b, int c){
        if (Math.max(a,b)==a){
            if (Math.max(a,c)==a){
                return a;
            }
            else {
                return c;
            }
        }
        else if (Math.max(b,c)==b){
            return b;
        }
        else {
            return c;
        }
    }

    int min(int a, int b, int c){
        if (Math.min(a,b)==a){
            if (Math.min(a,c)==a){
                return a;
            }
            else {
                return c;
            }
        }
        else if (Math.min(b,c)==b){
            return b;
        }
        else {
            return c;
        }
    }

    int abs(int n){
        if(n<0){
            n = -n;
        }
        return n;
    }

    boolean isEmpty(String st){
        if(st.equals("")){
            return true;
        }
        else {
            return false;
        }
    }

    String concat(String s1, String s2){
        return s1+s2;
    }

    boolean isMale(String s){
        if (s.startsWith("1")||s.startsWith("3")){
            return true;
        }
        else {
            return false;
        }
    }

    int getLength(List<String> str){
        return str.size();
    }



    @Test
    void Test() {
        assertThat(square(4)).isEqualTo(16);
        assertThat(square(-4)).isEqualTo(16);

        assertThat(add(3, 4)).isEqualTo(7);
        assertThat(add(10, -5)).isEqualTo(5);

        assertThat(getAverage(100, 100, 70)).isEqualTo(90);
        assertThat(getAverage(0, 100, 50)).isEqualTo(50);

        assertThat(calculateBirthYear(26)).isEqualTo(1999);

        assertThat(isPositive(3)).isEqualTo(true);
        assertThat(isPositive(9)).isTrue();
        assertThat(isPositive(0)).isFalse();
        assertThat(isPositive(-5)).isFalse();

        assertThat(getBigger(3, 7)).isEqualTo(7);
        assertThat(getBigger(7, 3)).isEqualTo(7);
        assertThat(getBigger(-9, -1)).isEqualTo(-1);

        assertThat(getBiggest(1, 2, 3)).isEqualTo(3);
        assertThat(getBiggest(3, 2, 1)).isEqualTo(3);
        assertThat(getBiggest(-3, -2, -1)).isEqualTo(-1);
        assertThat(getBiggest(-1, -2, -3)).isEqualTo(-1);

        assertThat(min(1, 2, 3)).isEqualTo(1);
        assertThat(min(3, 2, 1)).isEqualTo(1);
        assertThat(min(-3, -2, -1)).isEqualTo(-3);
        assertThat(min(-1, -2, -3)).isEqualTo(-3);

        assertThat(abs(3)).isEqualTo(3);
        assertThat(abs(-3)).isEqualTo(3);
        assertThat(abs(0)).isEqualTo(0);

        assertThat(isEmpty("")).isTrue();
        assertThat(isEmpty("a")).isFalse();
        assertThat(isEmpty("    ")).isFalse();

        assertThat(isEmpty("")).isTrue();
        assertThat(isEmpty("a")).isFalse();
        assertThat(isEmpty("    ")).isFalse();

        assertThat(concat("hello","world").equals("helloworld")).isTrue();

        assertThat(isMale("1234567")).isTrue();
        assertThat(isMale("3234567")).isTrue();
        assertThat(isMale("2234567")).isFalse();
        assertThat(isMale("4234567")).isFalse();

        Assertions.assertThat(getLength(List.of("a", "b", "c"))).isEqualTo(3);
        Assertions.assertThat(List.of("a", "b", "c").size()).isEqualTo(3);

    }

    @Test
    void typeTest(){
        int n = 100;
        String s = "Hello";
        System.out.println(s.length());
    }

    @Test
    void object() {
        String s = "Hello";
        assertThat(s.length()).isEqualTo(5);
        assertThat(s.equals("Hello")).isTrue();
        assertThat(s.charAt(2)).isEqualTo('l');
        assertThat(s.toLowerCase()).isEqualTo("hello");
        assertThat(s.toUpperCase()).isEqualTo("HELLO");
        assertThat(s.contains("ll")).isTrue();
        assertThat(s.startsWith("He")).isTrue();
        assertThat(s.endsWith("o")).isTrue();
        assertThat(s.indexOf("o")).isEqualTo(4);
        assertThat(s.concat(" World")).isEqualTo("Hello World");
    }
}
