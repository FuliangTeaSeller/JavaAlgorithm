package acwing.算法基础课.chapter3图论.排列数字;

import java.util.Scanner;

public class Main {
    static int n;
    static int[] path=new int[10];
    static boolean[] picked=new boolean[10];
    static void dfs(int cur){
        if(cur==n+1){
            for(int i=1;i<=n;i++){
                System.out.printf("%d ",path[i]);
            }
            System.out.println();
            return;
        }
        for(int i=1;i<=n;i++){
            if(!picked[i]){
                picked[i] = true;
                path[cur] = i;
                dfs(cur + 1);
                picked[i] = false;
            }
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        n= scanner.nextInt();
        dfs(1);
    }
}
