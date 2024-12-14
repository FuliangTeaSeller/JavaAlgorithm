package acwing.算法基础课.chapter6贪心.最大不相交区间数量;

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
        int cur = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (cur >= r[i].l && cur <= r[i].r) {
                continue;
            }
            ans++;
            cur = r[i].r;
        }
        System.out.println(ans);
    }
}
