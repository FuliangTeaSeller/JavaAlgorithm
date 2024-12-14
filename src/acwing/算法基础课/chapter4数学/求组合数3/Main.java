package acwing.算法基础课.chapter4数学.求组合数3;

import java.util.Scanner;

public class Main {
    static long qmi(long a, long k, long p) {
        long res = 1;
        while (k > 0) {
            if ((k & 1) > 0) res = (int) ((long) res * a % p);
            a = a * a % p;
            k >>= 1;
        }
        return res;
    }

    static long lucas(long a, long b, long p) {
        if (a < p && b < p) return c(a, b, p);
        return c(a % p, b % p, p) * lucas(a / p, b / p, p) % p;
    }

    static long c(long a, long b, long p) {
        if (b > a) return 0;
        long res = 1;
        for (long i = a; i > a - b; i--) {
            res = res * i % p;
        }
        for (int i = 1; i <= b; i++) {
            res = res * qmi(i, p - 2, p) % p;
        }
//        long i = 1;
//        long j = a;
//        while (i <= b) {
//            res = res * j % p;
//            res = res * qmi(i, p - 2, p) % p;
//            i++;
//            j--;
//        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long p = scanner.nextLong();
            System.out.println(lucas(a, b, p));
        }
    }
}
