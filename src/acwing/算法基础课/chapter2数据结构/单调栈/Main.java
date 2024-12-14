package acwing.算法基础课.chapter2数据结构.单调栈;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            int ans=-1;
            while (!deque.isEmpty() && deque.getLast() >= t) {
                deque.removeLast();
            }
            if(!deque.isEmpty()){
                ans=deque.getLast();
            }
            deque.addLast(t);
            System.out.printf("%d ",ans);
        }
    }
}
