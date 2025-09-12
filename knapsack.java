class Solution
{
    int maxWeight(int[] val,int[] wt,int index,int W)
    {
        int n = val.length ;
        int[][] dp = new int[n][W+1];

        for(int i = 0 ; i < n ; i++)  dp[0][i] = val[i];
        for(int i = 0 ;i < n ; i++)   dp[i][0] = 0 ; 

        for(int i = 1; i < n ; i++)
        {
            for(int j = 1 ; j <= W ;j++)
            {
                int notpick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(wt[i] < j) pick = dp[i-1][j-wt[i]];
                dp[i][j] = Math.max(pick,notpick);
            }
        }
        return dp[n-1][W];
    }
}
public class knapsack {
    public static void main(String[] args) {
        int[] val = {5,11,13};
        int[] wt = {2,4,6};
        int W = 10;
        
        Solution obj = new Solution();
        System.out.println(obj.maxWeight(val,wt,val.length-1,W));
    }
}
