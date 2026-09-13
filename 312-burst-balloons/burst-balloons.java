class Solution {
    public int maxCoins(int[] nums) {
    int n = nums.length;
    int[] arr = new int[n+2];
    arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }
    int[][] dp = new int[n+2][n+2];
    return helper(arr,1,n,dp);
    }
    public int helper (int[] arr, int i, int j, int dp[][]){
        int max = 0;
        if(i>j) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        for(int k=i;k<=j;k++){
            int left = helper(arr,i,k-1,dp);
            int right = helper(arr,k+1,j,dp);
            int current = arr[i-1]*arr[k]*arr[j+1];
            int total = left + current + right;
            max = Math.max(max,total);
        }
        dp[i][j] = max;
        return max; 
    }
}