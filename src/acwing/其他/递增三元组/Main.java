package acwing.其他.递增三元组;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[3][n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
            Arrays.sort(a[i]);
        }
        long ans = 0;
//        前缀和
//        int l = 0, r = 0;
//        for (int i = 0; i < n; i++) {
//            int x = a[1][i];
//            while (l < n && a[0][l] < x) l++;
//            while (r < n && a[2][r] <= x) r++;
//            ans += (long) l * (n - r);
//        }
//        二分
        for (int i = 0; i < n; i++) {
            int x = a[1][i];
            int l = Arrays.binarySearch(a[0], x);
            if (l < 0) {
                l = -l - 1;
            }
            int r = Arrays.binarySearch(a[2], x + 1);
            if (r < 0) {
                r = -r - 1;
            }
//            System.out.printf("%d %d\n", l, r);
            ans += (long) (l) * (n - r);
        }
        System.out.println(ans);
    }
}
