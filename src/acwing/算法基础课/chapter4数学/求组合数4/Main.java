package acwing.算法基础课.chapter4数学.求组合数4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> primes = new ArrayList<>();
    static boolean[] st;

    static void get_primes(int a) {
        st = new boolean[a + 1];
        for (int i = 2; i <= a; i++) {
            if (!st[i]) {
                primes.add(i);
            }
            for (int p : primes) {
                if (i * p > a) break;
                st[i * p] = true;
                if (i % p == 0) break;
            }
        }
    }

    static int get(int n, int p) {
        int res = 0;
        while (n > 0) {
            res += n / p;
            n /= p;
        }
        return res;
    }

    static BigDecimal c(int a, int b) {
        BigDecimal res = new BigDecimal(1);
        for (int p : primes) {
            int sum = get(a, p) - get(b, p) - get(a - b, p);
            for (int j = 0; j < sum; j++) {
                res = res.multiply(BigDecimal.valueOf(p));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        get_primes(a);
        System.out.println(c(a, b));
    }
}
