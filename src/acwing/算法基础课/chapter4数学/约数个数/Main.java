package acwing.算法基础课.chapter4数学.约数个数;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int n;
    static int MOD = (int) 1e9 + 7;
    static HashMap<Integer, Integer> factors = new HashMap<>();

    static void f(int a) {
        int t = a;
        for (int i = 2; i <= a / i; i++) {
            while (t % i == 0) {
                t /= i;
                factors.put(i,factors.getOrDefault(i,0)+1);
            }

        }
        if (t > 1) {
            factors.put(t,factors.getOrDefault(t,0)+1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        while (n-- > 0) {
            int a = scanner.nextInt();
            f(a);
        }
        long ans = 1l;
        for (Integer v : factors.values()) {
            ans *= (v+1) % MOD;
            ans %= MOD;
        }
        System.out.println(ans);
    }
}
