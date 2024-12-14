package acwing.算法基础课.chapter3图论.Prim算法求最小生成树;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N = (int) 1000;
    static int INF = Integer.MAX_VALUE / 2;
//    static int[] p = new int[N];
//
//    static int find(int x) {
//        if (p[x] != x) {
//            p[x] = find(p[x]);
//        }
//        return p[x];
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] g = new int[n + 1][n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        for(int i=0;i<=n;i++){
            Arrays.fill(g[i],INF);
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }
        boolean[] st = new boolean[n + 1];

        int sum = 0;
        dist[1] = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            int t = 0;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && dist[j] < dist[t]) {
                    t = j;
                }
            }
            if (dist[t] == INF) {
                flag = false;
                break;
            }
            st[t] = true;
            sum += dist[t];
            for (int k = 1; k <= n; k++) {
                if (dist[k] > g[t][k] && !st[k]) {
                    dist[k] = g[t][k];
                }
            }
        }
        System.out.println(flag ? sum : "impossible");

    }
}
