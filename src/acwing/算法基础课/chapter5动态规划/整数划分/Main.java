package acwing.算法基础课.chapter5动态规划.整数划分;

import java.util.Scanner;

public class Main {
    static int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; j - k * i >= 0; k++) {
                    dp[i][j] += dp[i - 1][j - k * i];
                    dp[i][j] %= MOD;
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}
