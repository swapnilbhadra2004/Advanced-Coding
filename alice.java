import java.util.*;
public class alice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0 ;
        int count = 0; 
        int apples=0 ;
        apples = sc.nextInt();

        while(sum<apples)
        {
            count++;
            sum += 12*count*count;
        }

        System.out.println(8*count);
    }
}
