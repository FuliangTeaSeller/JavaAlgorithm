package acwing.算法基础课.chapter3图论.有边数限制的最短路;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] edge = new int[m][3];
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            edge[i][0] = x;
            edge[i][1] = y;
            edge[i][2] = z;
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[1] = 0;
        for (int i = 0; i < k; i++) {
            int[] back = Arrays.copyOf(dist, n + 1);
            for (int j = 0; j < m; j++) {
                int x = edge[j][0];
                int y = edge[j][1];
                int z = edge[j][2];
                dist[y] = Math.min(dist[y], back[x] + z);

            }
        }
        System.out.println(dist[n] < Integer.MAX_VALUE / 2 - 1000 ? dist[n] : "impossible");
    }
}
