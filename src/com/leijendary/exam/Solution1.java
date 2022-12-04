package com.leijendary.exam;

public class Solution1 {
    public static void main(String[] args) {
        final var solution1 = new Solution1();

        final var start = System.nanoTime();

        System.out.println(solution1.solve(new int[]{0, 4, -1, 0, 3}, new int[]{0, -2, 5, 0, 3}));
        System.out.println(solution1.solve(new int[]{2, -2, -3, 3}, new int[]{0, 0, 4, -4}));
        System.out.println(solution1.solve(new int[]{4, -1, 0, 3}, new int[]{-2, 6, 0, 4}));
        System.out.println(solution1.solve(new int[]{3, 2, 6}, new int[]{4, 1, 6}));
        System.out.println(solution1.solve(new int[]{1, 4, 2, -2, 5}, new int[]{7, -2, -2, 2, 5}));

        final var end = System.nanoTime();

        System.out.println((end - start) / 1000000 + "ms");
    }

    public int solve(int[] a, int[] b) {
        // Get only a's length since we validated both lengths should be equal
        final var length = a.length;

        // Support large numbers
        long[] c = new long[length];
        long[] d = new long[length];

        // Index 0 values, the loop will start at index 1
        c[0] = a[0];
        d[0] = b[0];

        for (int i = 1; i < length; i++) {
            c[i] = a[i] + c[i - 1];
            d[i] = b[i] + d[i - 1];
        }

        int fairCount = 0;
        long leftA;
        long rightA;
        long leftB;
        long rightB;

        for (int k = 1; k < length; k++) {
            leftA = c[k - 1];
            rightA = c[length - 1] - leftA;
            leftB = d[k - 1];
            rightB = d[length - 1] - leftB;

            if (leftA == rightA && rightA == leftB && leftB == rightB) {
                fairCount++;
            }
        }

        return fairCount;
    }
}
