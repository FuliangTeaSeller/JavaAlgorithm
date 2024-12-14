package acwing.算法提高课.chapter1动态规划.怪盗基德的滑翔翼;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        while (k-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] dpl = new int[n];
            int[] dpr = new int[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                dpl[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (a[i] > a[j]) {
                        dpl[i] = Math.max(dpl[i], dpl[j] + 1);
                    }
                }
                ans = Math.max(ans, dpl[i]);
            }
            for (int i = n - 1; i >= 0; i--) {
                dpr[i] = 1;
                for (int j = n - 1; j > i; j--) {
                    if (a[i] > a[j]) {
                        dpr[i] = Math.max(dpr[i], dpr[j] + 1);
                    }
                }
                ans = Math.max(ans, dpr[i]);
            }
            System.out.println(ans);
        }
    }
}