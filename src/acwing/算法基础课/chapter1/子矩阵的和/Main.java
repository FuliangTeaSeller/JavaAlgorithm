package acwing.算法基础课.chapter1.子矩阵的和;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), q = scanner.nextInt();
        int[][] a = new int[n + 1][m + 1];
        int[][] s = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = scanner.nextInt();
                s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + a[i][j];
//                System.out.printf("%d ",s[i][j]);
            }
//            System.out.println("");
        }
        for(int i=0;i<q;i++){
            int x1= scanner.nextInt();
            int y1= scanner.nextInt();
            int x2= scanner.nextInt();
            int y2= scanner.nextInt();
            int ans=s[x2][y2]+s[x1-1][y1-1]-s[x2][y1-1]-s[x1-1][y2];
//            System.out.println(ans);
        }
    }
}
