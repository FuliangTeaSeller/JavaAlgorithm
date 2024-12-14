package acwing.算法基础课.chapter2数据结构.模拟散列表;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        scanner.nextLine();
        while (n-- > 0) {
            String[] s = scanner.nextLine().split(" ");
            if (s[0].equals("I")) {
                map.put(Integer.parseInt(s[1]), true);
            } else {
                String ans = "No";
                Boolean b = map.get(Integer.parseInt(s[1]));
                if (b != null && b) {
                    ans = "Yes";
                }
                System.out.println(ans);
            }
        }
    }
}
