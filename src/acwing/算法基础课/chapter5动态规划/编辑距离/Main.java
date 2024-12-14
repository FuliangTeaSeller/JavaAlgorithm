package acwing.算法基础课.chapter5动态规划.编辑距离;

import java.util.Scanner;

public class Main {
    static int check(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = scanner.nextLine();
        }
        for (int i = 0; i < m; i++) {
            String[] s = scanner.nextLine().split(" ");
            String q = s[0];
            int k = Integer.parseInt(s[1]);
            int ans = 0;
            for (int j = 0; j < n; j++) {
                if (check(str[j], q) <= k) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
