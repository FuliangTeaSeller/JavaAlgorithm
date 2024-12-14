package leetcode.统计不是特殊数字的数字数量;

import java.util.ArrayList;

class Solution {
    public int nonSpecialCount(int l, int r) {
        int N = r - l + 1;
        int ans = N;
        int n = (int) Math.sqrt(r);
        boolean[] st = new boolean[n+10];
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes.add(i);
            }
            for (int p : primes) {
                if (i > n / p) break;
                st[i * p] = true;
                if (i % p == 0) break;
            }
        }
        System.out.println(primes);
        for (int p : primes) {
            if (p * p >= l && p * p <= r) {
                ans--;
            }
        }
        return ans;
    }
}