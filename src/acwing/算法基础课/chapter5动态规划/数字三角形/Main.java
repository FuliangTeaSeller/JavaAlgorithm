package acwing.算法基础课.chapter5动态规划.数字三角形;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n ; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        dp[1][1] = a[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + a[i][j];
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[n][i]);
        }
        System.out.println(ans);
    }
}
