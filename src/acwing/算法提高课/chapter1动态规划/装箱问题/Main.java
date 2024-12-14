package acwing.算法提高课.chapter1动态规划.装箱问题;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] f = new int[n + 1][V + 1];
        int[] v = new int[110];
        for (int i = 1; i <= n; i++) {
            v[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                int tmp = 0;
                if (j - v[i] >= 0) {
                    tmp = f[i - 1][j - v[i]] + v[i];
                }
                f[i][j] = Math.max(f[i - 1][j], tmp);
            }
        }
        System.out.println(V - f[n][V]);
    }
}