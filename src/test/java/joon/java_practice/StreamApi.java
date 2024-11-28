package joon.java_practice;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class StreamApi {
    @Test
    void streamTests() {
        System.out.println(Stream.of(100, 60, 35, 70, 38, 80).filter(i->i<40).toList());
        System.out.println(Stream.of(100, 60, 35, 70, 38, 80).filter(i -> i % 2 == 0).toList());
        System.out.println(Stream.of("백승수", "김신", "왕여", "박새로이", "천지훈").filter(str -> str.length() != 3).toList());
        System.out.println(Stream.of("왕건", "이성계", "부여풍", "이도", "이산", "궁예").filter(str -> str.startsWith("이")).toList());
        System.out.println(Stream.of("왕건", "이성계", "부여풍", "이도", "이산", "궁예").filter(str -> str.startsWith("이")).filter(str -> str.length() != 3).toList());

    }
}
