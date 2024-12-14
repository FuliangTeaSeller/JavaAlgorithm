package acwing.算法基础课.chapter5动态规划.滑雪;

import java.util.Scanner;

public class Main {
    static int N = 301;
    static int M = 301;
    static int n;
    static int m;
    static int[][] h = new int[N][M];
    static int[][] dp = new int[N][M];
    static boolean[][] st = new boolean[N][M];
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int solve(int x, int y) {
        if (st[x][y]) return dp[x][y];
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int xx = x + d[i][0];
            int yy = y + d[i][1];
            if (xx >= 1 && xx <= n && yy >= 1 && yy <= m && h[xx][yy] < h[x][y]) {
                dp[x][y] = Math.max(dp[x][y], solve(xx, yy) + 1);
            }
        }
        st[x][y] = true;
        return dp[x][y];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
//            Arrays.fill(dp[i], -1);
            for (int j = 1; j <= m; j++) {
                h[i][j] = scanner.nextInt();
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                ans = Math.max(ans, solve(i, j));
            }
        }
        System.out.println(ans);
    }
}
