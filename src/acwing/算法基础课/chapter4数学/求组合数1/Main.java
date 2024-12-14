package acwing.算法基础课.chapter4数学.求组合数1;

import java.util.*;

public class Main {
    static int mod = (int) 1e9 + 7;
    static int N = 2010;
    static long[][] dp = new long[N][N];

    static long c(int a, int b) {
//        System.out.printf("caculate c %d %d\n", a, b);
        if (dp[a][b] != 0) {
//            System.out.printf("found\n");
            return dp[a][b];
        }
        dp[a][b] = c(a - 1, b - 1) + c(a - 1, b);
        dp[a][b] %= mod;
//        System.out.println();
        return dp[a][b];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
            dp[i][i] = 1;
        }
        int n = scanner.nextInt();
        while (n-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(c(a, b));
        }
    }
}