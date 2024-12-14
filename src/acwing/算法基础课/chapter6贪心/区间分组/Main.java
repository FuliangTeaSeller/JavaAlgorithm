package acwing.算法基础课.chapter6贪心.区间分组;

import java.util.*;

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
        int n = scanner.nextInt();
        Range[] range = new Range[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            range[i] = new Range(a, b);
        }
        Arrays.sort(range);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            Integer t = queue.peek();
            if (t == null || t >= range[i].l) {
                queue.add(range[i].r);
            } else {
                queue.poll();
                queue.add(range[i].r);
            }
        }
        System.out.println(queue.size());
    }
}
