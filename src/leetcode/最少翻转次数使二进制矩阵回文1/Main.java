package leetcode.最少翻转次数使二进制矩阵回文1;

class Solution {
    public int minFlips(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int a1=0;
        for(int i=0;i<m;i++){
            int l=0;
            int r=n-1;
            while(l<r){
                a1+=grid[i][l]^grid[i][r];
                l++;
                r--;
            }
        }
        int a2=0;
        for(int i=0;i<n;i++){
            int l=0;
            int r=m-1;
            while(l<r){
                a2+=grid[l][i]^grid[r][i];
                l++;
                r--;
            }
        }
        return Math.min(a1,a2);
    }
}