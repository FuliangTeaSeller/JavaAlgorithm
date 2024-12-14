package acwing.算法基础课.chapter5动态规划.石子合并;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N = 310;
    static int n;
    static int[][] dp = new int[N][N];
    static boolean[][] st = new boolean[N][N];
    static int[] a = new int[N];
    static int[] p = new int[N];

    static void solve(int l, int r) {
        for (int i = l; i < r; i++) {
            if (!st[l][i]) solve(l, i);
            if (!st[i + 1][r]) solve(i + 1, r);
            dp[l][r] = Math.min(dp[l][r], dp[l][i] + dp[i + 1][r] + p[r] - p[l - 1]);
        }
        st[l][r] = true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            p[i] = p[i - 1] + a[i];
            dp[i][i] = 0;
        }
        solve(1, n);
        System.out.println(dp[1][n]);
    }
}
