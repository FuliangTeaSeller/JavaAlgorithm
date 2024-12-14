package acwing.算法基础课.chapter4数学.试除法判定质数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-->0){
            int a= scanner.nextInt();
            boolean flag=true;
            for(int i=2;i<=a/i;i++){
                if(a%i==0){
                    flag=false;
                    break;
                }
            }
            if(a==1)flag=false;
            System.out.println(flag?"Yes":"No");
        }
    }
}
