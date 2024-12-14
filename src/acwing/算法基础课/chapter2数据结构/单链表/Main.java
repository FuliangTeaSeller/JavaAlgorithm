package acwing.算法基础课.chapter2数据结构.单链表;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int m = scanner.nextInt();
        int N = 100010;
        int[] a = new int[N];
        int[] next = new int[N];
        int head = 0, idx = 0;
        scanner.nextLine();
        while (m-- > 0) {
            String[] s = scanner.nextLine().split(" ");
            if (s[0].equals("H")) {
                int x = Integer.parseInt(s[1]);
                a[++idx] = x;
                next[idx] = head;
                head=idx;
                next[0]=head;
            } else if (s[0].equals("D")) {
                int k = Integer.parseInt(s[1]);
                if (k == 0) {
                    head = next[head];
                } else {
                    next[k] = 0;
                }
            } else {
                int k = Integer.parseInt(s[1]);
                int x = Integer.parseInt(s[2]);
                a[++idx] = x;
                next[idx] = next[k];
                next[k] = idx;
            }
            for (int i = head; ; i = next[i]) {
                System.out.printf("%d ", a[i]);
                if(next[i] == 0)break;
            }
            System.out.println();
        }
    }
}
