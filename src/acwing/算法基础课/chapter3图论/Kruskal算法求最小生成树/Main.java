package acwing.算法基础课.chapter3图论.Kruskal算法求最小生成树;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static int N = (int) 1e5+10;
    static int INF = Integer.MAX_VALUE / 2;
    static int[] p = new int[N];

    static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    static class Cmp implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] e = new int[m][3];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            e[i][0] = c;
            e[i][1] = a;
            e[i][2] = b;
        }
        for (int i = 0; i <= n; i++) {
            p[i] = i;
        }
        Arrays.sort(e, new Cmp());
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int c = e[i][0];
            int a = e[i][1];
            int b = e[i][2];
            if (find(a) != find(b)) {
                p[find(a)] = find(b);
                ans += c;
            }
        }
        boolean flag = true;
        int parent = find(1);
        for (int i = 1; i <= n; i++) {
            if (find(i) != parent) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? ans : "impossible");
    }
}
