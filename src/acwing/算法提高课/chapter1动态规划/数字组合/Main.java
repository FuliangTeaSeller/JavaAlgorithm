package acwing.算法提高课.chapter1动态规划.数字组合;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] dp = new int[M + 1];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            int v = scanner.nextInt();
            for (int j = M; j >= v; j--) {
                dp[j] += dp[j - v];
            }
        }
        System.out.println(dp[M]);
    }
}