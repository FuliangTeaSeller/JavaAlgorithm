package acwing.算法基础课.chapter2数据结构.字符串哈希;

import java.util.Scanner;

public class Main {
    static long p = 131;
    static long[] a = new long[100010];
    static long[] pw = new long[100010];

    public static long hash(int l, int r, String s) {
        return a[r] - a[l - 1] * pw[r - l+1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        pw[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            a[i] = a[i - 1] * p + s.charAt(i - 1) - 'a' + 7;
            pw[i] = pw[i - 1] * p;
        }
        while (m-- > 0) {
            int l1 = scanner.nextInt();
            int r1 = scanner.nextInt();
            int l2 = scanner.nextInt();
            int r2 = scanner.nextInt();
            long h1 = hash(l1, r1, s);
            long h2 = hash(l2, r2, s);
            if (h1 == h2) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
