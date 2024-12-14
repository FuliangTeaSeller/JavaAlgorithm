package acwing.其他.波动数列;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int S = s + b + 1;

        int[][] dp = new int[n + 1][S];
        for (int i = 0; i < S; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= s; j++) {
                dp[i][j] = dp[i - 1][Math.max(j - a, 0)] + dp[i - 1][j + b];
            }
        }
        System.out.println(dp[n][s]);
    }
}
