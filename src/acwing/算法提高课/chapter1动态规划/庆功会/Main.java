package acwing.算法提高课.chapter1动态规划.庆功会;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
//        int[] v = new int[n + 1];
//        int[] w = new int[n + 1];
//        int[] s = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            v[i]= scanner.nextInt();
//            w[i]= scanner.nextInt();
//            s[i]= scanner.nextInt();
//        }
//        int[][] dp = new int[n + 1][m + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                for (int k = 0; k <= s[i] && k * v[i] <= j; k++) {
//                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i]] + k * w[i]);
//                }
//            }
//        }
        List<Integer> v = new ArrayList<Integer>();
        List<Integer> w = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            int tv = scanner.nextInt();
            int tw = scanner.nextInt();
            int ts = scanner.nextInt();
            int t = 1;
            while (ts > 0) {
                ts -= t;
                if (ts < 0) t = t + ts;
                v.add(t * tv);
                w.add(t * tw);
                t *= 2;
            }
        }
        n = v.size();
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= v.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[j - v.get(i)] + w.get(i));
            }
        }
        System.out.println(dp[m]);
    }
}