package acwing.算法基础课.chapter4数学.筛法求欧拉函数;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> primes;
    static boolean[] st;
    static int n;

    static void init() {
        primes = new ArrayList<Integer>();
        st = new boolean[n + 1];
        for (int i = 2; i < n; i++) {
            if (!st[i]) {
                primes.add(i);
                for (int p : primes) {
                    int t = i * p;
                    if (t > n) break;
                    st[t] = true;
                    if (i % p == 0) break;
                }
            }
        }
    }

    static long f(int a) {
        long ret = a;
        for (int p : primes) {
            if (p > a / p) break;
            if (a % p == 0) {
                while (a % p == 0) a /= p;
                ret = ret / p * (p - 1);
            }
        }
        if (a > 1) {
            ret = ret / a * (a - 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        init();
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += f(i);
        }
        System.out.println(ans);
    }
}
