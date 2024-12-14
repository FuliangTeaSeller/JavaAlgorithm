package acwing.算法基础课.chapter6贪心.货仓选址;

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
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(a[mid] - a[i]);
        }
        System.out.println(ans);
    }
}
