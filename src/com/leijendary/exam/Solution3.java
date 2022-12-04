package com.leijendary.exam;

public class Solution3 {
    public static void main(String[] args) {
        final var solution3 = new Solution3();

        final var start = System.nanoTime();

        // 1
        System.out.println(solution3.solve(new int[]{2, 3}));
        // 3
        System.out.println(solution3.solve(new int[]{1, 0, 4, 1}));
        // 2
        System.out.println(solution3.solve(new int[]{5}));
        // 1
        System.out.println(solution3.solve(new int[]{4, 0, 3, 0}));

        final var end = System.nanoTime();

        System.out.println((end - start) / 1000000 + "ms");
    }

    public int solve(int[] a) {
        // Count of blocks that can be moved to the next stack
        var count = 0;
        // Sum of stacks that has a block
        var sum = 0;

        for (int value : a) {
            value += count;
            count = value / 2;
            sum += value % 2;
        }

        // Count remaining values outside the array's index
        while (count > 0) {
            sum += count % 2;
            count = count / 2;
        }

        return sum;
    }
}
