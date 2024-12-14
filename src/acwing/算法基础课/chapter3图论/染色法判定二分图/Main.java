package acwing.算法基础课.chapter3图论.染色法判定二分图;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[] st=new boolean[n+1];
        int[] col=new int[n+1];
        ArrayList<Integer>[] v=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            v[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<m;i++){
            int a= scanner.nextInt();
            int b= scanner.nextInt();
            v[a].add(b);
            v[b].add(a);
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            if(!st[i]){
                q.addLast(i);
                col[i]=1;
                while(!q.isEmpty()){
                    int t = q.getFirst();
                    q.removeFirst();
                    for(int ne:v[t]){
                        if(!st[ne]){
                            col[ne]=3-col[t];
                            st[ne]=true;
                            q.addLast(ne);
                        }
                        else if(col[ne]!=3-col[t]){
                            System.out.println("No");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Yes");
    }
}
