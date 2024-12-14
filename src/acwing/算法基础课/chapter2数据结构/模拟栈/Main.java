package acwing.算法基础课.chapter2数据结构.模拟栈;

import java.io.BufferedInputStream;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int m= scanner.nextInt();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        scanner.nextLine();
        while(m-->0){
            String[] s = scanner.nextLine().split(" ");
            if(s[0].equals("push")){
                int x=Integer.parseInt(s[1]);
                deque.addLast(x);
            }
            else if(s[0].equals("pop")){
                deque.removeLast();
            }
            else if(s[0].equals("empty")){
                String result=deque.isEmpty()?"YES":"NO";
                System.out.println(result);
            }
            else if(s[0].equals("query")){
                System.out.println(deque.getLast());
            }
        }
    }
}
