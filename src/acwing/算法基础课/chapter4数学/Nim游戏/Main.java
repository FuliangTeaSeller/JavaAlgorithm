package acwing.算法基础课.chapter4数学.Nim游戏;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = 0;
        while (n-- > 0) {
            int t = scanner.nextInt();
            res ^= t;
        }
        if (res != 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
