package acwing.算法基础课.chapter1.立方根;

import java.util.Scanner;

public class Main {
    static double getCubeRoot(double n) {
        double l = -100, r = 100;
        while (r - l >= 1e-8) {
            double mid = (l + r) / 2;
            if (Math.pow(mid, 3) <= n) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        System.out.printf("%.6f",getCubeRoot(n));
    }
}
