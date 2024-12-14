package acwing.算法提高课.chapter1动态规划.买书;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] v = new int[]{0, 10, 20, 50, 100};
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        for (int i = 1; i <= 4; i++) {
//            for (int j = v[i]; j <= n; j++) {
//                dp[j] += dp[j - v[i]];
//            }
//        }
//        System.out.println(dp[n]);
        int[][] dp = new int[5][n + 1];
//        for (int i = 0; i <= 4; i++) {
//            dp[i][0] = 1;
//        }
        dp[0][0] = 1;
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j <= n; j++) {
//                for (int k = 0; k * v[i] <= j; k++) {
//                    dp[i][j] += dp[i - 1][j - k * v[i]];
//                }
                dp[i][j] = dp[i - 1][j];
                if (j - v[i] >= 0) {
                    dp[i][j] += dp[i][j - v[i]];
                }
            }
        }
        System.out.println(dp[4][n]);
    }
}
