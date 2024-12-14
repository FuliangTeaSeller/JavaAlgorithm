package acwing.算法提高课.chapter1动态规划.宠物小精灵之收服;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int K = scanner.nextInt();
        int[] cost = new int[K + 1];
        int[] dmg = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            cost[i] = scanner.nextInt();
            dmg[i] = scanner.nextInt();
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= K; i++) {
            for (int j = n; j >= cost[i]; j--) {
                for (int k = m; k >= dmg[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - cost[i]][k - dmg[i]] + 1);
                }
            }
        }
        int c = -1;
        int r = 0;
        for (int k = 0; k < m; k++) {
            if ((dp[n][k] > c) || (dp[n][k] == c && k < r)) {
                c = dp[n][k];
                r = k;
            }
        }
        System.out.println(c + " " + (m - r));
    }
}
