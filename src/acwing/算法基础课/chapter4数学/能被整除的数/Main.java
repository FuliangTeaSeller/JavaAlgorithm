package acwing.算法基础课.chapter4数学.能被整除的数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = scanner.nextInt();
        }
        int N = 1 << m;
        int ans = 0;
        for (int i = 1; i < N; i++) {
            int cnt = 0;
            int prod = 1;
            boolean valid = true;
            for (int j = 0; j < m; j++) {
                int t = (i >> j) & 1;
                if (t > 0) {
                    if ((long) prod * p[j] > n) {
                        valid = false;
                        break;
                    }
                    cnt++;
                    prod *= p[j];
                }
            }
            if (!valid) {
                continue;
            }
            if (cnt % 2 == 1) {
                ans += n / prod;
            } else {
                ans -= n / prod;
            }
        }
        System.out.println(ans);
    }
}
