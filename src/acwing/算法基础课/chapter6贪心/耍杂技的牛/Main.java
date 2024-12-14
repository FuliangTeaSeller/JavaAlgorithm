package acwing.算法基础课.chapter6贪心.耍杂技的牛;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static class Node implements Comparable<Node> {
        public int w;
        public int s;

        @Override
        public int compareTo(Node o) {
            return (w + s) - (o.w + o.s);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] a = new Node[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Node();
            a[i].w = scanner.nextInt();
            a[i].s = scanner.nextInt();
        }
        Arrays.sort(a);
        int ans = Integer.MIN_VALUE;
        int total = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, total - a[i].s);
            total += a[i].w;
        }
        System.out.println(ans);
    }
}
