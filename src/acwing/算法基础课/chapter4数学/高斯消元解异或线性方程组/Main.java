package acwing.算法基础课.chapter4数学.高斯消元解异或线性方程组;

import java.util.*;

public class Main {

    static int gauss(int[][] a) {
        int n = a.length;
        int row = 0;
        int col = 0;
        for (col = 0; col < n; col++) {

            int t = row;
            for (int i = t; i < n; i++) {
                if (a[i][col] > 0) {
                    t = i;
                    break;
                }
            }
            if (a[t][col] == 0) {
                continue;
            }

            for (int i = 0; i < n + 1; i++) {
                int tmp = a[t][i];
                a[t][i] = a[row][i];
                a[row][i] = tmp;
            }

            for (int i = row + 1; i < n; i++) {
                if (a[i][col] == 0) {
                    continue;
                }
                for (int j = n; j >= col; j--) {
                    a[i][j] ^= a[row][j];
                }
            }
            row++;
        }
        if (row < n) {
            for (int i = row; i < n; i++) {
                if (a[i][n] > 0) {
                    return 2;
                }
            }
            return 1;
        } else {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    a[i][n] ^= a[j][n] & a[i][j];
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        int ret = gauss(a);
        if (ret == 0) {
            for (int i = 0; i < n; i++) {
                System.out.printf("%d\n", a[i][n]);
            }
        } else if (ret == 1) {
            System.out.println("Multiple sets of solutions");
        } else {
            System.out.println("No solution");
        }
    }
}