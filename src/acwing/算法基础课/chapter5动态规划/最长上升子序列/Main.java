package acwing.算法基础课.chapter5动态规划.最长上升子序列;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int N = n + 1;
        int[] a = new int[N];
        int[] dp = new int[N];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        int ans=Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        System.out.println(ans);
    }
}
