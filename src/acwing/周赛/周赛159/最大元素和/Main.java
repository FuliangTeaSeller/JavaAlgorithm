package acwing.周赛.周赛159.最大元素和;

import java.util.Scanner;

public class Main {

    public static final int M = 110;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] sum = new int[n + 1][M];
        int[] c = new int[n + 1];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
            for (int j = 1; j <= c[i]; j++) {
                sum[i][j] = sum[i][j - 1] + scanner.nextInt();
            }
        }
        int[][] solution = new int[n + 1][M];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= c[i]; j++) {
                for (int k = j; k <= c[i]; k++) {
                    int selected = c[i] - (k - j);
                    solution[i][selected] = Math.max(solution[i][selected], sum[i][c[i]] - (sum[i][k] - sum[i][j]));
                }
            }
        }
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k <= c[i] && j - k >= 0; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k] + solution[i][k]);
                }
            }
        }
        System.out.println(dp[m]);
    }
}
