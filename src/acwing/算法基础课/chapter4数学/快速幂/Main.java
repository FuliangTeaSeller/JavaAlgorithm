package acwing.算法基础课.chapter4数学.快速幂;

import java.util.Scanner;

public class Main {
    static long pow(long a, int b, int p) {
        long ret = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ret = ret * a % p;
            }
            b >>= 1;
            a = a * a % p;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int p = scanner.nextInt();
            System.out.println(pow((long)a, b, p));
        }
    }
}
