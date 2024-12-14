package acwing.其他.倍数问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int N = (int) 1e5 + 10;

    static int mod(int x, int y) {
        return (x % y + y) % y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int K = scanner.nextInt();
        ArrayList<Integer>[] bucket = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            bucket[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            int t = scanner.nextInt();
            bucket[t % K].add(t);
        }
        int[][] dp = new int[4][K + 1];
        for (int j = 0; j <= 3; j++) {
            Arrays.fill(dp[j], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        for (int u = 0; u < K; u++) {
            bucket[u].sort((Integer a, Integer b) -> {
                return b - a;
            });
            for (int i = 0; i < 3 && i < bucket[u].size(); i++) {
                int t = bucket[u].get(i);
                for (int j = 3; j >= 1; j--) {
                    for (int k = 0; k < K; k++) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - 1][mod(k - t, K)] + t);
                    }
                }
            }
        }
        System.out.println(dp[3][0]);
    }
}
