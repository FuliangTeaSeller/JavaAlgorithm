package acwing.算法提高课.chapter1动态规划.最长公共上升子序列;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextInt();
        }

        int[][] dp = new int[n + 1][n + 1];
//        朴素做法
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                dp[i][j] = dp[i - 1][j];
//                if (a[i] == b[j]) {
//                    int maxv = 1;
//                    for (int k = 1; k < j; k++) {
//                        if (a[i] > b[k])
//                            maxv = Math.max(maxv, dp[i - 1][k] + 1);
//                    }
//                    dp[i][j] = Math.max(dp[i][j], maxv);
//                }
//            }
//        }
        for (int i = 1; i <= n; i++) {
            int maxv = 1;
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (a[i] == b[j]) {
                    dp[i][j] = Math.max(dp[i][j], maxv);
                }
                if (a[i] > b[j]) {
                    maxv = Math.max(maxv, dp[i - 1][j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) res = Math.max(res, dp[n][i]);
        System.out.println(res);
    }
}
