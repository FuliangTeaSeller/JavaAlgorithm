package acwing.算法基础课.chapter3图论.Dijkstra求最短路I;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static int N = (int) (1e5 + 10);
    static ArrayList<int[]>[] v = new ArrayList[N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
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
        for (int i = 0; i < n; i++) {
            int t = 0;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && dist[j] < dist[t]) {
                    t = j;
                }
            }

            st[t] = true;
            for (int[] pair : v[t]) {
                if (dist[pair[0]] > dist[t] + pair[1]) {
                    dist[pair[0]] = dist[t] + pair[1];
                }
            }
        }
        System.out.println(dist[n] != Integer.MAX_VALUE ? dist[n] : -1);
    }
}
