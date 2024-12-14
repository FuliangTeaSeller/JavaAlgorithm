package acwing.算法基础课.chapter5动态规划.最短Hamilton路径;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] w = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = scanner.nextInt();
            }
        }
        int M = 1 << n;
        int[][] dp = new int[M][n + 1];
        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[1][0] = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) > 0) {
                    for (int k = 0; k < n; k++) {
                        if (((i >> j) & 1) > 0) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - (1 << j)][k] + w[k][j]);
                        }
                    }
                }
            }
        }
        System.out.println(dp[M - 1][n - 1]);
    }
}
