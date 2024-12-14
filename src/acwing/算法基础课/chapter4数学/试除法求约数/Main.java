package acwing.算法基础课.chapter4数学.试除法求约数;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;

    static void f(int a) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= a / i; i++) {
            if (a % i == 0) {
                ans.add(i);
                if (i != a / i) {
                    ans.add(a / i);
                }
            }
        }
        ans.sort(null);
        ans.forEach((Integer i) -> {
            System.out.printf("%d ", i);
        });
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        while (n-- > 0) {
            int a = scanner.nextInt();
            f(a);
        }
    }
}
