package leetcode.适龄的朋友;

import java.util.Arrays;

class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans=0;
        int n=ages.length;
        int[] bages = Arrays.copyOf(ages, n);
        for(int i=0;i<n;i++){
            bages[i]=2*bages[i]-14;
        }
        for(int i=0;i<n;i++){
            int x=ages[i];
            int l=Arrays.binarySearch(bages,x);
            int r=Arrays.binarySearch(ages,x);
        }
        return 0;
    }
}