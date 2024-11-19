package joon.java_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.FLOAT_ARRAY;


public class MyTest {
    int square(int n) {
        return n * n;
    }

    int add(int a, int b) {
        return a + b;
    }

    int getAverage(int a, int b, int c) {
        return (a + b + c) / 3;
    }

    int calculateBirthYear(int age) {
        return 2025 - age;
    }

    boolean isPositive(int n) {
        if (n > 0) {
            return true;
        } else {
            return false;
        }
    }

    int getBigger(int a, int b) {
        return Math.max(a, b);
    }

    int getBiggest(int a, int b, int c) {
        if (Math.max(a, b) == a) {
            if (Math.max(a, c) == a) {
                return a;
            } else {
                return c;
            }
        } else if (Math.max(b, c) == b) {
            return b;
        } else {
            return c;
        }
    }

    int min(int a, int b, int c) {
        if (Math.min(a, b) == a) {
            if (Math.min(a, c) == a) {
                return a;
            } else {
                return c;
            }
        } else if (Math.min(b, c) == b) {
            return b;
        } else {
            return c;
        }
    }

    int abs(int n) {
        if (n < 0) {
            n = -n;
        }
        return n;
    }

    boolean isEmpty(String st) {
        if (st.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    String concat(String s1, String s2) {
        return s1 + s2;
    }

    boolean isMale(String s) {
        if (s.startsWith("1") || s.startsWith("3")) {
            return true;
        } else {
            return false;
        }
    }

    int getLength(List<String> str) {
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

        assertThat(concat("hello", "world").equals("helloworld")).isTrue();

        assertThat(isMale("1234567")).isTrue();
        assertThat(isMale("3234567")).isTrue();
        assertThat(isMale("2234567")).isFalse();
        assertThat(isMale("4234567")).isFalse();

        Assertions.assertThat(getLength(List.of("a", "b", "c"))).isEqualTo(3);
        Assertions.assertThat(List.of("a", "b", "c").size()).isEqualTo(3);

    }

    @Test
    void typeTest() {
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

    int maxMin(int score) {
        return Math.max(Math.min(score, 100), 0);

    }

    @Test
    void maxMin() {
        assertThat(maxMin(130)).isEqualTo(100);
        assertThat(maxMin(51)).isEqualTo(51);
        assertThat(maxMin(-130)).isEqualTo(0);
    }

    @Test
    void substring() {
        String url = "www.google.com";
        assertThat(url.substring(4, 10)).isEqualTo("google");
        assertThat(url.replace('.', ',')).isEqualTo("www,google,com");
        String s = "  a    ";
        assertThat(s.trim()).isEqualTo("a");
        String formatted = String.format("안녕하세요. %d년생 %s입니다", 71, "마동석");
        assertThat(formatted).isEqualTo("안녕하세요. 71년생 마동석입니다");
        assertThat(String.join("-", "자바", "스프링", "정해준")).isEqualTo("자바-스프링-정해준");
    }

    boolean isValidEmail(String email) {
        return email.contains("@");
    }

    boolean isFemale(String number) {
        return number.startsWith("2") || number.startsWith("4");
    }

    boolean isFemale2(String number) {
        boolean answer = false;
        if (number.charAt(0) == '2' || number.charAt(0) == '4') {
            answer = true;
        }
        return answer;
    }


    boolean isValidIdNumber(String number) {
        boolean answer = true;
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                answer = false;
            }
        }
        return answer;
    }

    String toCamelCase(String s) {
        return concat(concat(s.substring(0, s.indexOf('_')), String.valueOf(s.charAt(s.indexOf('_') + 1)).toUpperCase()), s.substring(s.indexOf('_') + 2));
    }

    boolean isValidPhoneNumber(String number) {
        boolean answer = false;
        if (number.length() == 11 && number.startsWith("010")) {
            for (int i = 0; i < number.length(); i++) {
                if (Character.isDigit(number.charAt(i))) {
                    answer = true;
                } else {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }

    String extractDomain(String url) {
        return url.substring(8, url.indexOf('/', 8));
    }

    boolean passWordCheck(String passWord) {
        boolean answer = true;
        if (passWord.length() >= 8 && passWord.contains("!") || passWord.contains("@") || passWord.contains("#") || passWord.contains("$") || passWord.contains("%") || passWord.contains("^") || passWord.contains("&") || passWord.contains("*") || passWord.contains("(") || passWord.contains(")")) {
            int count = 0;
            for (int i = 0; i < passWord.length(); i++) {
                if(Character.isUpperCase(passWord.charAt(i))){
                    count++;
                }
            }
            if (count==0){
                answer=false;
            }
        }
        else {
            answer = false;
        }
        return answer;
    }

    @Test
    void stringFunction_practice() {
        assertThat(isValidEmail("gowns4414@naver.com")).isTrue();
        assertThat(isValidEmail("gowns4414naver.com")).isFalse();

        assertThat(isFemale("1234567")).isFalse();
        assertThat(isFemale("2345678")).isTrue();
        assertThat(isFemale("3456789")).isFalse();
        assertThat(isFemale("4567890")).isTrue();

        assertThat(isValidIdNumber("1234567")).isTrue();
        assertThat(isValidIdNumber("1abcd67")).isFalse();
        assertThat(isValidIdNumber("1abcd6b")).isFalse();

        assertThat(toCamelCase("snake_case")).isEqualTo("snakeCase");
        assertThat(toCamelCase("product_name")).isEqualTo("productName");
        assertThat(toCamelCase("created_at")).isEqualTo("createdAt");

        assertThat(isValidPhoneNumber("01012345678")).isTrue();
        assertThat(isValidPhoneNumber("010123456789")).isFalse();
        assertThat(isValidPhoneNumber("00012345678")).isFalse();
        assertThat(isValidPhoneNumber("010xxxx5678")).isFalse();

        assertThat(extractDomain("https://git-scm.com/book/en/v2")).isEqualTo("git-scm.com");
        assertThat(extractDomain("https://www.google.com/search?q=java")).isEqualTo("www.google.com");
        assertThat(extractDomain("https://www.op.gg/modes/aram/teemo/build?region=global&tier=all")).isEqualTo("www.op.gg");

      
        assertThat(passWordCheck("1qdA24@@")).isTrue();
        assertThat(passWordCheck("123$saDsd")).isTrue();
        assertThat(passWordCheck("asdw2")).isFalse();
        assertThat(passWordCheck("asda1232")).isFalse();
    }


}