package acwing.算法基础课.chapter3图论.spfa求最短路;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<int[]>[] v = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            v[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            v[x].add(new int[]{y, z});
        }
        int[] dist = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[1] = 0;
        st[1] = true;
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        q.addLast(1);
        while (q.size() > 0) {
            int t = q.getFirst();
            q.removeFirst();
            st[t] = false;
            for (int[] a : v[t]) {
                if (dist[a[0]] > dist[t] + a[1]) {
                    dist[a[0]] = dist[t] + a[1];
                    if (!st[a[0]]) {
                        st[a[0]] = true;
                        q.addLast(a[0]);
                    }
                }
            }
        }
        System.out.println(dist[n] != Integer.MAX_VALUE / 2 ? dist[n] : "impossible");
    }
}
