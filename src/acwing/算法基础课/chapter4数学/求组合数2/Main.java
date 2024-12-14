package acwing.算法基础课.chapter4数学.求组合数2;

import java.util.Scanner;

public class Main {
    static int mod = (int) 1e9 + 7;
    static int N = (int) 1e5;
    static long[] fact = new long[N + 1];
    static long[] infact = new long[N + 1];

    static long qmi(long a, long k) {
        long res = 1;
        while (k > 0) {
            if ((k & 1) > 0) res = res * a % mod;
            a = a * a % mod;
            k >>= 1;
        }
        return res;
    }

    static long c(int a, int b) {
        long ret = fact[a];
        ret = ret * infact[b] % mod;
        ret = ret * infact[a - b] % mod;
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        fact[0] = 1;
        infact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i - 1] * i % mod;
            infact[i] = infact[i - 1] * qmi(i, mod - 2) % mod;
        }
        int n = scanner.nextInt();
        while (n-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(c(a, b));
        }
    }
}
