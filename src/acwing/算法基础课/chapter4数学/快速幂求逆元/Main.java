package acwing.算法基础课.chapter4数学.快速幂求逆元;

import java.util.Scanner;

public class Main {
    static long qmi(long a, long k, long mod) {
        long res = 1;
        while (k > 0) {
            long t = (k & 1);
            if (t > 0) {
                res = res * a % mod;
            }
            a = a * a % mod;
            k >>= 1;
        }
        return res % mod;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int a = scanner.nextInt();
            int p = scanner.nextInt();
            if (a % p == 0) System.out.println("impossible");
            else {
                System.out.println(qmi(a, p - 2, p));
            }
        }
    }
}
