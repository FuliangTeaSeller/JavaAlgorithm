package acwing.算法基础课.chapter5动态规划.最短编辑距离;

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
        scanner.nextLine();
        String a = scanner.nextLine();
        int m = scanner.nextInt();
        scanner.nextLine();
        String b = scanner.nextLine();

        System.out.println(check(a,b));
//        int[][] dp = new int[n + 1][m + 1];
////        for (int i = 0; i <= n; i++) {
////            for (int j = 0; j <= m; j++) {
////                dp[i][j] = (int) 2e9;
////            }
////        }
//
//        for (int i = 1; i <= n; i++) {
//            dp[i][0] = i;
//        }
//        for (int j = 1; j <= m; j++) {
//            dp[0][j] = j;
//        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
//                if (a.charAt(i - 1) == b.charAt(j - 1)) {
//                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
//                } else {
//                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
//                }
////                if (a.charAt(i - 1) == b.charAt(j - 1)) {
////                    dp[i][j] = dp[i - 1][j - 1];
////                } else {
////                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]) + 1, dp[i - 1][j - 1] + 1);
////                }
//            }
//        }
//        System.out.println(dp[n][m]);
    }
}
