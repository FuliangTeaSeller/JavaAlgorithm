package acwing.算法基础课.chapter6贪心.区间覆盖;

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
            return this.l - range.l;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int t = scanner.nextInt();
        int n = scanner.nextInt();
        Range[] range = new Range[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            range[i] = new Range(a, b);
        }
        Arrays.sort(range);
        int ans = 0;
        int cur = s;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            int val = Integer.MIN_VALUE;
            for (int j = i; j < n && range[j].l <= cur; j++) {
                val = Math.max(val, range[j].r);
                i = j;
            }
            if (cur > val) {
                flag = false;
                break;
            }
            cur = val;
            ans++;
            if (cur >= t) {
                flag = true;
                break;
            }
        }
        System.out.println(flag ? ans : -1);
    }
}
