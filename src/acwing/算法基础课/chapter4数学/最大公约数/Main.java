package acwing.算法基础课.chapter4数学.最大公约数;

import java.util.Scanner;

public class Main {
    static int gcd(int a, int b) {
        if (b > 0) {
            return gcd(b, a % b);
        }else{
            return a;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(gcd(a, b));
        }
    }
}
