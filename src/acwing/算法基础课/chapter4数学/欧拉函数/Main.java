package acwing.算法基础课.chapter4数学.欧拉函数;

import java.util.*;

public class Main {
    static int f(int a) {
        int ret = a;

        for (int i = 2; i <= a / i; i++) {
            if (a % i == 0) {
                while (a % i == 0) a /= i;
                ret = ret / i * (i - 1);
            }
        }
        if (a > 1) {
            ret = ret / a * (a - 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int a = scanner.nextInt();
            System.out.println(f(a));
        }
    }
}
