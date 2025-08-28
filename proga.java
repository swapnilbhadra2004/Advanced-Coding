import java.util.Scanner ;
public class proga
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() ;
        
        int result = n ; 
        for(int i = 2; i <= n ; i++)
        {
            if(n%i == 0)
            {
                while(n%i == 0) n = n / i;
            }

            result -= result/i;
        }

        if(n>1) result -= result/n;


        System.out.println(result);
        
    }
} 