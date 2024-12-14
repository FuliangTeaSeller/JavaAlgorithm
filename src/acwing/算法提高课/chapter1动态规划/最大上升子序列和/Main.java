package acwing.算法提高课.chapter1动态规划.最大上升子序列和;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            dp[i] = a[i];
            for (int j = 0; j < i; j++) {
                if (dp[j] < dp[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + a[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
        ;
    }
}
