package acwing.算法提高课.chapter1动态规划.方格取数;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] m = new int[n + 1][n + 1];
        int[][][] dp = new int[n+n+1][n + 1][n + 1];
        while(true){
                int r= scanner.nextInt();
                int c= scanner.nextInt();
                int t= scanner.nextInt();
                if(r+c+t==0)break;
                m[r][c]=t;
        }
        for(int k=2;k<=n+n;k++){
            for (int i1 = 1; i1 <= n; i1++) {
                for (int i2 = 1; i2 <= n; i2++) {
                    int j1=k-i1;
                    int j2=k-i2;
                    if(j1<1||j1>n||j2<1||j2>n)continue;
                    int t=m[i1][j1];
                    if(i1!=i2)t+=m[i2][j2];
                    dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k-1][i1-1][i2]+t) ;
                    dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k-1][i1-1][i2-1]+t) ;
                    dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k-1][i1][i2]+t) ;
                    dp[k][i1][i2] = Math.max(dp[k][i1][i2], dp[k-1][i1][i2-1]+t) ;
                }
            }
        }
        System.out.println(dp[n+n][n][n]);
    }
}