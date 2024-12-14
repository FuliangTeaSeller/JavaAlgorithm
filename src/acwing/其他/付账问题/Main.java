package acwing.其他.付账问题;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long s = scanner.nextLong();
        int[] a = new int[n];
        double[] b = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
//        double total = s;
        BigDecimal total = new BigDecimal(s);
        for (int i = 0; i < n; i++) {
            double avg = total.divide(BigDecimal.valueOf(n - i)).doubleValue();
            double cur = Math.min(a[i], avg);
            b[i] = cur;
//            total -= cur;
            total = total.subtract(BigDecimal.valueOf(cur));
        }
        double avg = b[0];
        for (int i = 1; i < n; i++) {
            avg = avg / (i + 1) * i + b[i] / (i + 1);
        }
        double ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.pow(b[i] - avg, 2) / n;
        }
        ans = Math.sqrt(ans);
        System.out.printf("%.4f", ans);
    }
}
