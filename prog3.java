import java.util.*;
public class prog3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] status = new boolean[n+1];

        for(int i = 1; i <= n ; i++)
        {
            for(int j = i ; j<=n ; j+=i)
            status[j] = !status[j];
        }

        int closed = 0;
        int open = 0 ; 

        for(int i =1 ; i<=n ; i++)
        {
            if(status[i]) open++;
            else closed++;
        }

        System.out.println("Open:"+open+" closed:"+closed);
    }
}
