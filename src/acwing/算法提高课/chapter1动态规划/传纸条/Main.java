package acwing.算法提高课.chapter1动态规划.传纸条;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] w = new int[m + 1][n + 1];
        int[][][] dp = new int[m + n + 1][m + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = scanner.nextInt();
            }
        }
        for (int k = 2; k <= m + n; k++) {
            for (int i1 = 1; i1 <= m; i1++) {
                for (int i2 = 1; i2 <= m; i2++) {
                    int j1 = k - i1;
                    int j2 = k - i2;
                    if (j1 < 1 || j1 > n || j2 < 1 || j2 > n) continue;
                    int t = w[i1][j1];
                    if (i1 != i2) t += w[i2][j2];
                    dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2] + t);
                    dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1 - 1][i2 - 1] + t);
                    dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2] + t);
                    dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k - 1][i1][i2 - 1] + t);
                }
            }
        }
        System.out.println(dp[m + n][m][m]);
    }
}
