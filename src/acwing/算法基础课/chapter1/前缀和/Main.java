package acwing.算法基础课.chapter1.前缀和;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[] a=new int[n+1];
        int[] s=new int[n+1];
        for(int i=1;i<=n;i++){
            a[i]=scanner.nextInt();
            s[i]=s[i-1]+a[i];
        }
        for(int i=0;i<m;i++){
            int l=scanner.nextInt();
            int r=scanner.nextInt();
            System.out.printf("%d\n",s[r]-s[l-1]);
        }
    }
}
