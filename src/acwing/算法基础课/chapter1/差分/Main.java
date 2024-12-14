package acwing.算法基础课.chapter1.差分;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    static void add(int l,int r,int c,int[] b){
        b[l]+=c;
        b[r+1]-=c;
    }
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n= scanner.nextInt();
        int m= scanner.nextInt();
        int[] a=new int[n+2];
        int[] b=new int[n+2];
        for(int i=1;i<=n;i++){
            a[i]= scanner.nextInt();
        }
        for(int i=1;i<=n;i++){
            add(i,i,a[i],b);
        }
        for(int i=1;i<=m;i++){
            int l= scanner.nextInt();
            int r= scanner.nextInt();
            int c= scanner.nextInt();
            add(l,r,c,b);
        }
        for(int i=1;i<=n;i++){
            b[i]+=b[i-1];
            System.out.printf("%d ",b[i]);
        }
    }
}
