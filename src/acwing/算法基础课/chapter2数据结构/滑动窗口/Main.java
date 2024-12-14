package acwing.算法基础课.chapter2数据结构.滑动窗口;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int t = a[i];
            while (!deque.isEmpty() && t < deque.getLast()) {
                deque.removeLast();
            }
            int head = i - k + 1;
            if (head - 1 >= 0 && !deque.isEmpty() && a[head - 1] == deque.getFirst()) {
                deque.removeFirst();
            }
            deque.addLast(t);
            if (head >= 0) {
                stringBuilder.append(deque.getFirst()).append(" ");
//                System.out.printf("%d ", deque.getFirst());
            }
        }
        System.out.println(stringBuilder);
        deque.clear();
        stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int t = a[i];
            while (!deque.isEmpty() && t > deque.getLast()) {
                deque.removeLast();
            }
            int head = i - k + 1;
            if (head - 1 >= 0 && !deque.isEmpty() && a[head - 1] == deque.getFirst()) {
                deque.removeFirst();
            }
            deque.addLast(t);
            if (head >= 0) {
                stringBuilder.append(deque.getFirst()).append(" ");
//                System.out.printf("%d ", deque.getFirst());
            }
        }
        System.out.println(stringBuilder);
    }
}
