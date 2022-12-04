package com.leijendary.exam;

public class Solution2 {
    public static void main(String[] args) {
        final var solution2 = new Solution2();

        final var start = System.nanoTime();

        // Solution should be 23010101
        System.out.println(solution2.solve(22123456));
        // 56
        System.out.println(solution2.solve(55));
        // 1767
        System.out.println(solution2.solve(1765));
        // 101
        System.out.println(solution2.solve(98));
        // 45010
        System.out.println(solution2.solve(44432));
        // 3401
        System.out.println(solution2.solve(3298));

        final var end = System.nanoTime();

        System.out.println((end - start) / 1000000 + "ms");
    }

    public int solve(int n) {
        n++;

        if (n <= 10) {
            return n;
        }

        var index = -1;
        var value = Integer.toString(n);
        var length = value.length();

        while ((index = consecutiveIndex(value, length)) > -1) {
            value = increment(value, length, index);
            length = value.length();
        }

        return Integer.parseInt(value);
    }

    private int consecutiveIndex(final String value, final int length) {
        for (int i = 0; i < length - 1; i++) {
            final var a = value.charAt(i);
            final var b = value.charAt(i + 1);

            if (a == b) {
                return i + 1;
            }
        }

        return -1;
    }

    private String increment(String value, int length, int index) {
        final var zeroes = "0".repeat(length - index - 1);
        final var onePadded = "1" + zeroes;
        final var increment = Integer.parseInt(onePadded);
        final var substring = value.substring(0, index + 1) + zeroes;
        final var incremented = Integer.parseInt(substring) + increment;

        return Integer.toString(incremented);
    }
}
