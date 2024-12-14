package acwing.算法提高课.chapter1动态规划.摘花生;

import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int r=scanner.nextInt();
            int c=scanner.nextInt();
            int[][] m=new int[r+1][c+1];
            int[][] dp=new int[r+1][c+1];
            for(int i=1;i<=r;i++){
                for(int j=1;j<=c;j++){
                    m[i][j]=scanner.nextInt();
                }
            }
            for(int i=1;i<=r;i++){
                for(int j=1;j<=c;j++){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+m[i][j];
                }
            }
            System.out.println(dp[r][c]);
        }
    }
}