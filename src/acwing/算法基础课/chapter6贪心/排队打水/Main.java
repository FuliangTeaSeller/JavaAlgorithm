package acwing.算法基础课.chapter6贪心.排队打水;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) (n - i - 1) * a[i];
        }
        System.out.println(ans);
    }
}
