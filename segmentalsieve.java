import java.util.*;
public class segmentalsieve {
    static void segmented(int l,int r)
    {
        boolean[] sieve = new boolean[r+1];
        for(int i = 2; i*i<=r;i++)
        {
            int sm = (l/i)*i;
            if(sm < l) sm += i ; 
            for(int j = sm ; j <= r ; j+=i)
            sieve[j] = true ;
        }

        for(int i = l ; i <= r ; i++)
        {
            if (sieve[i] == false)  System.out.println(i+" "); 
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        segmented(l,r);
    }
}
