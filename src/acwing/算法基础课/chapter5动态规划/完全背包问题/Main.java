package acwing.算法基础课.chapter5动态规划.完全背包问题;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int[] v = new int[N + 10];
        int[] w = new int[N + 10];
        for (int i = 1; i <= N; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
//        int[][] dp = new int[N + 10][V + 10];
//        for (int i = 1; i <= N; i++) {
//            for (int j = 0; j <= V; j++) {
//                for (int k = 0; k * v[i] <= j; k++) {
//                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i]] + k * w[i]);
//                }
//            }
//        }
        int[] dp = new int[V + 10];
        for (int i = 1; i <= N; i++) {
            for (int j = v[i]; j <= V; j++) {
//                for (int k = 0; k * v[i] <= j; k++) {
//                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
//                }
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        System.out.println(dp[V]);
    }
}