package acwing.算法基础课.chapter3图论.有向图的拓扑序列;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static int N = (int) (1e5 + 10);
    static ArrayList<Integer>[] v = new ArrayList[N];
    static int[] in = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            v[i] = new ArrayList<Integer>();
        }
        while (m-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            v[x].add(y);
            in[y]++;
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ArrayDeque<Integer> ans = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (in[i] <= 0) {
                q.addLast(i);
            }
        }
        while (!q.isEmpty()) {
            int t = q.getFirst();
            q.removeFirst();
            ans.addLast(t);
            for(Integer i:v[t]){
                in[i]--;
                if(in[i]<=0){
                    q.addLast(i);
                }
            }
        }
        if(ans.size()==n){
            ans.forEach(x-> System.out.print(x+" "));
        }
        else{
            System.out.println(-1);
        }
    }
}
