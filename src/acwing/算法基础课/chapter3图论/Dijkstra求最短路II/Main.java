package acwing.算法基础课.chapter3图论.Dijkstra求最短路II;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int n;
    static int N = (int) (1e5 + 10);
    static ArrayList<int[]>[] v = new ArrayList[N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];

    static class Cmp implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Cmp());
        for (int i = 0; i <= n; i++) {
            v[i] = new ArrayList<int[]>();
            dist[i] = Integer.MAX_VALUE;
            st[i] = false;
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            v[x].add(new int[]{y, z});
        }
        dist[1] = 0;
        pq.add(new int[]{1, 0});
        while (!pq.isEmpty()){
            int t=pq.poll()[0];
            if(st[t])continue;
            st[t] = true;
            for (int[] pair : v[t]) {
                if (dist[pair[0]] > dist[t] + pair[1]) {
                    dist[pair[0]] = dist[t] + pair[1];
                    pq.add(new int[]{pair[0],dist[pair[0]]});
                }
            }
        }
        System.out.println(dist[n] != Integer.MAX_VALUE ? dist[n] : -1);
    }
}

