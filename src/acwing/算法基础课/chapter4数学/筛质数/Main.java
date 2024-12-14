package acwing.算法基础课.chapter4数学.筛质数;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N = (int) 1e6 + 10;
    static int n;
    static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes.add(i);
            }
            for (int p : primes) {
                if (i > n / p) break;
                st[i * p] = true;
                if (i % p == 0) break;
            }
        }
        System.out.println(primes.size());
    }
}
