package acwing.算法基础课.chapter5动态规划.分组背包问题;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N=110;
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] v = new int[N][N];
        int[][] w = new int[N][N];
        int[] s = new int[N];
        for (int i = 1; i <= n; i++) {
            s[i] = scanner.nextInt();
            for (int j = 0; j < s[i]; j++) {
                v[i][j] = scanner.nextInt();
                w[i][j] = scanner.nextInt();
            }
        }
        int[][] dp = new int[N][N];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 0; k < s[i]; k++) {
                    int tv = v[i][k];
                    int tw = w[i][k];
                    if (j - tv >= 0)
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - tv] + tw);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}