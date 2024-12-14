package leetcode.统计满足K约束的子字符串数量2;

class Solution {
    public int minFlips(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i <= n / 2; i++) {
            for (int j = 0; j <= m / 2; j++) {
                int a = grid[i][j];
                int b = grid[i][m - j - 1];
                int c = grid[n - i - 1][j];
                int d = grid[n - i - 1][m - j - 1];
                int sum = a + b + c + d;
                int t = Math.min(sum, 4 - sum);
                if ((i == n / 2 && n % 2 > 0) || (j == m / 2 && m % 2 > 0)) {
                    t /= 2;
                }
                if ((i == n / 2 && n % 2 > 0) && (j == m / 2 && m % 2 > 0)) {
                    t = grid[i][j];
                }
                ans += t;
                grid[i][j] = 0;
                grid[i][m - j - 1] = 0;
                grid[n - i - 1][j] = 0;
                grid[n - i - 1][m - j - 1] = 0;
            }
        }
        return ans;
    }
}