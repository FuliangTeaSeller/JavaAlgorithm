package acwing.算法基础课.chapter5动态规划.蒙德里安的梦想;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static void solve(int n, int m) {
        boolean[] st = new boolean[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            boolean flag = true;
            int cnt = 0;
            for (int j = 0; j < n && flag; j++) {
                int t = (i >> j) & 1;
                if (t == 1) {
                    if (cnt % 2 != 0) {
                        flag = false;
                        break;
                    }
                } else {
                    cnt++;
                }
            }
            if (cnt % 2 != 0) {
                flag = false;
            }
            st[i] = flag;
        }
        ArrayList<Integer>[] state = new ArrayList[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            state[i] = new ArrayList<Integer>();
            for (int j = 0; j < (1 << n); j++) {
                if ((i & j) == 0 && st[i | j]) {
                    state[i].add(j);
                }
            }
        }
        long[][] dp = new long[m + 1][1 << n];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < (1 << n); j++) {
                for (int k : state[j]) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
        System.out.println(dp[m][0]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = -1;
        int m = -1;
        while (true) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            if (n == 0 && m == 0) break;
            solve(n, m);
        }
    }
}
