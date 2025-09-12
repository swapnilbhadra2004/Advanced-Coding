class Solution {
    public boolean isSubsetSum(int[] arr,int index, int target) {
      int n = arr.length ;
      boolean[][] dp = new boolean[n][target+1];

      for(int i = 0 ; i < n ; i++)
      {
        dp[i][0] = true ; 
      }

      dp[0][arr[0]] = true ; 


      for(int i = 1 ; i < n ; i++)
      {
        for(int j = 0 ; j <= target ; j++)
        {
            boolean notpick = dp[i-1][j];
            boolean pick = false ; 
            if(arr[i] <= j) pick = dp[i-1][j-arr[i]];
            dp[i][j] = (pick | notpick) ; 
        }
      }
      return dp[n-1][target];
    }
}

public class subset{
    public static void main(String[] args) {
        int[] arr = {1,2,7,3};
        int target = 20;
        Solution obj = new Solution();
        System.out.println(obj.isSubsetSum(arr,arr.length-1,target));
    }
}