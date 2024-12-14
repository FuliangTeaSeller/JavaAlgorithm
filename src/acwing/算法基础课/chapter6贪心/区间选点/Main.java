package acwing.算法基础课.chapter6贪心.区间选点;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static class Range implements Comparable<Range> {
        public int l;
        public int r;

        public Range(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Range range) {
            return this.r - range.r;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Range[] r = new Range[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            r[i] = new Range(a, b);
        }
        Arrays.sort(r);
        int ans = 0;
        int cur = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (r[i].l > cur) {
                ans++;
                cur = r[i].r;
            }
        }
        System.out.println(ans);
    }
}
