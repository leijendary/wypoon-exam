package com.leijendary.exam;

import java.util.Arrays;

public class TestSolution {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 100000;
    private static final int MIN_VALUE = -1000000;
    private static final int MAX_VALUE = 1000000;

    public static void main(String[] args) {
        final var testSolution = new TestSolution();

        // 5
        System.out.println(testSolution.solution(new int[]{1, 3, 6, 4, 1, 2}));
        // 4
        System.out.println(testSolution.solution(new int[]{1, 2, 3}));
        // 1
        System.out.println(testSolution.solution(new int[]{-1, -3}));
        // 1
        System.out.println(testSolution.solution(new int[]{-1}));
    }

    public int solution(int[] a) {
        validateLength(a);

        Arrays.sort(a);

        int greater = 1;
        int previous = 0;

        for (int current : a) {
            validateValue(current);

            if (current < 1) {
                continue;
            }

            if (current - previous > 1) {
                return previous + 1;
            }

            previous = current;
            greater = previous + 1;
        }

        return greater;
    }

    private void validateLength(int[] n) {
        final var length = n.length;

        assert length >= MIN_LENGTH && length <= MAX_LENGTH
                : "n length should be between " + MIN_LENGTH + " and " + MAX_LENGTH;
    }

    private void validateValue(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            final var error = String.format("value should be between %d and %d", MIN_VALUE, MAX_VALUE);

            throw new RuntimeException(error);
        }
    }
}
