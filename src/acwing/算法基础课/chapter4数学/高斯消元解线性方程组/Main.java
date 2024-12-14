package acwing.算法基础课.chapter4数学.高斯消元解线性方程组;

import java.util.*;

public class Main {
    static double eps = 1e-6;

    static double[] swap(double a, double b) {
        return new double[]{b, a};
    }

    static int gauss(double[][] a) {
        int n = a.length;
        int row = 0;
        int col = 0;
        for (col = 0; col < n; col++) {

            int t = row;
            for (int i = t; i < n; i++) {
                if (Math.abs(a[i][col]) > Math.abs(a[t][col])) {
                    t = i;
                }
            }
            if (Math.abs(a[t][col]) < eps) {
                continue;
            }

            for (int i = 0; i < n + 1; i++) {
                double tmp = a[t][i];
                a[t][i] = a[row][i];
                a[row][i] = tmp;
            }
            for (int i = n; i >= col; i--) {
                a[row][i] /= a[row][col];
            }

            for (int i = row + 1; i < n; i++) {
                if (Math.abs(a[i][col]) < eps) {
                    continue;
                }
//                for (int j = col; j < n + 1; j++) {
//                    a[i][j] -= a[row][j] * a[i][col];
//                }
                for (int j = n; j >= col; j--) {
                    a[i][j] -= a[row][j] * a[i][col];
                }
            }
            row++;
        }
        if (row < n) {
            for (int i = row; i < n; i++) {
                if (Math.abs(a[i][n]) > eps) {
                    return 2;
                }
            }
            return 1;
        } else {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    a[i][n] -= a[j][n] * a[i][j];
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[][] a = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                a[i][j] = scanner.nextDouble();
            }
        }
        int ret = gauss(a);
        if (ret == 0) {
            for (int i = 0; i < n; i++) {
                System.out.printf("%.2f\n", a[i][n]);
            }
        } else if (ret == 1) {
            System.out.println("Infinite group solutions");
        } else {
            System.out.println("No solution");
        }
    }
}