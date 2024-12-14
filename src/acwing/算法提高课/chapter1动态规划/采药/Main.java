package acwing.算法提高课.chapter1动态规划.采药;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] f = new int[110][1100];
        int[] v = new int[110];
        int[] w = new int[110];
        for (int i = 1; i <= m; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= t; j++) {
                int tmp = 0;
                if (j - v[i] >= 0) {
                    tmp = f[i - 1][j - v[i]] + w[i];
                }
                f[i][j] = Math.max(f[i - 1][j], tmp);
            }
        }
        System.out.println(f[m][t]);
    }
}