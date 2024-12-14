package acwing.算法基础课.chapter3图论.走迷宫;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][m];
        int[][] v = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        ArrayDeque<Integer[]> queue = new ArrayDeque<>();
        queue.addLast(new Integer[]{0, 0});
        v[0][0] = 1;
        while (!queue.isEmpty()) {
            Integer[] pos = queue.getFirst();
            queue.removeFirst();
            if (pos[0] == n - 1 && pos[1] == m - 1) break;
            for (int i = 0; i < 4; i++) {
                int x = pos[0] + dx[i];
                int y = pos[1] + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && map[x][y] == 0 && v[x][y] <= 0) {
                    v[x][y] = v[pos[0]][pos[1]] + 1;
                    queue.addLast(new Integer[]{x, y});
                }
            }
        }
        System.out.println(v[n - 1][m - 1]-1);
    }
}
