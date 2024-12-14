package acwing.算法基础课.chapter1.数的范围;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        while (q-- > 0) {
            int k = scanner.nextInt();
            int ans1 = -1, ans2 = -1;
            int l = 0, r = n - 1;
            while (l < r) {
                int m = l + r >> 1;
                if (a[m] < k) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            if (a[l] == k) {
                ans1 = l;
            }

            l = 0;
            r = n;
            while (l + 1 < r) {
                int m = l + r >> 1;
                if (a[m] <= k) {
                    l = m;
                } else {
                    r = m;
                }
            }
            if (a[l] == k) {
                ans2 = l;
            }
            System.out.printf("%d %d\n", ans1, ans2);
        }
    }
}
