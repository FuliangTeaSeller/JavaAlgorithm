package 码题集.兔子炸弹;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int i = 0, j = 1;
        int ans = a[i];
        int cur = a[i];
        while (i < n) {
            while (j - i < m && j < n) {
                j++;
                cur += a[j - 1];
                ans = Math.max(ans, cur);
            }
            while (i + 1 < j && a[i] < 0) {
                cur -= a[i];
                i++;
                ans = Math.max(ans, cur);
            }
            if (i + 1 < j && a[i] >= 0) {
                cur -= a[i];
                i++;
                ans = Math.max(ans, cur);
            }
            while (i + 1 < j && a[i] < 0) {
                cur -= a[i];
                i++;
                ans = Math.max(ans, cur);
            }
        }
        System.out.println(ans);
    }
}
