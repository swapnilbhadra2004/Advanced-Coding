import java.util.* ; 
public class sieve {
    static void Sieve(int n)
    {
        boolean[] sieve = new boolean[n+1];
        for(int i = 1 ; i <= n ; i++)
        {
            sieve[i] = true ;
        }
    
        for(int i = 2 ; i * i <= n ; i++)
        {
            if(sieve[i] == true)
            {
                for(int j = i * i ; j<=n ; j=j+i)
                {
                    sieve[j] = false;
                }
            }
        }

        for(int i = 1; i <= n ; i++)
        {
            if(sieve[i] == true) System.out.println(i+" ");
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Sieve(n);
    }
}
