public class frogjump {
    static int energy = Integer.MIN_VALUE ; 
    static int dp(int[] arr,int index,int sum)
    {
        if(index < arr.length)
             sum += arr[index];

        int left = dp(arr,index+1,sum);
        int right = dp(arr,index+2,sum);

        if(index == arr.length) 
        {
        energy = Math.min(left,right);
        return energy;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,3,5,4};
        System.out.println(dp(arr,0,0));
    }    
}
