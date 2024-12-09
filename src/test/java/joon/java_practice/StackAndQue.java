package joon.java_practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQue {
    @Test
    void stack() {
        Stack<Integer> integers = new Stack<>();

        integers.push(1);
        integers.push(2);
        integers.push(3);

        Assertions.assertThat(integers.peek()).isEqualTo(3);
        Assertions.assertThat(integers.pop()).isEqualTo(3);
        Assertions.assertThat(integers.peek()).isEqualTo(2);

    }

    @Test
    void queue() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        Assertions.assertThat(queue.peek()).isEqualTo(1);
        Assertions.assertThat(queue.poll()).isEqualTo(1);
        Assertions.assertThat(queue.peek()).isEqualTo(2);
    }



}
