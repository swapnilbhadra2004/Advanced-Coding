import java.util.*;
public class toggle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int doors = sc.nextInt();
        boolean[] status = new boolean[doors+1];   //false == closed


        for(int i = 1; i <= doors ; i++)
        {
            for(int j = i ; j<=doors; j+=i)
            {
                 status[j] = !status[j];
            }
        }


        int open = 0,closed = 0 ;

        for(int i = 1; i <= doors ; i++)
        {
            if(status[i]) open++;
            else closed++;
        }
        System.out.println("closed: "+closed+" open:"+open);
    }
}
