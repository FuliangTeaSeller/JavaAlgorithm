package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static int INF = Integer.MAX_VALUE / 2;
    static int[][] dp;
    static ArrayList<Integer> a;
    static ArrayList<Integer> b;

    static int f(int l, int r) {
        if (dp[l][r] != INF) return dp[l][r];
        if (l > r) {
            return INF;
        }
        for (int k = l; k + 1 <= r; k++) {
            dp[l][r] = Math.min(dp[l][r], f(l, k) + f(k + 1, r) + b.get(r + 1) - b.get(l));
        }
        return dp[l][r];
    }

    public static int minCost(int n, int[] cuts) {
        a = new ArrayList<>();
        b = new ArrayList<>();
        Arrays.sort(cuts);
        int t = 0;
        b.add(0);
        for (int i = 0; i < cuts.length; i++) {
            a.add(cuts[i] - t);
            b.add(b.get(i) + a.get(i));
            t = cuts[i];
        }
        a.add(n - t);
        b.add(n);
        int m = a.size();
        dp = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }
        return f(0, m - 1);
    }

    public static void main(String[] args) {
        System.out.println(minCost(9, new int[]{5, 6, 1, 4, 2}));
    }
}