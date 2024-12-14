package acwing.算法基础课.chapter3图论.八数码;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static String swap(String s, int a, int b) {
        StringBuilder stringBuilder = new StringBuilder(s);
        char ca = stringBuilder.charAt(a);
        stringBuilder.setCharAt(a, stringBuilder.charAt(b));
        stringBuilder.setCharAt(b, ca);
        return stringBuilder.toString();
    }

    public static int getPos(String s) {
        return s.lastIndexOf("x");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();

        String ans = "12345678x";

        String s = scanner.nextLine().replace(" ", "");
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.addLast(s);
        map.put(s, 0);

        while (!queue.isEmpty()) {
            String t = queue.getFirst();
            if (t.equals(ans)) break;
            queue.removeFirst();
            int idx = getPos(t);
            int x = idx / 3;
            int y = idx % 3;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!(nx >= 0 && nx < 3 && ny >= 0 && ny < 3)) continue;
                int ni = nx * 3 + ny;
                String swapped = swap(t, idx, ni);
                if (map.get(swapped) == null) {
                    map.put(swapped, map.get(t) + 1);
                    queue.addLast(swapped);
                }
            }
        }
        System.out.println(map.get(ans) != null ? map.get(ans) : -1);
    }
}
