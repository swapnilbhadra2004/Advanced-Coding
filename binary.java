import java.util.*;

class binarypallindrome
{
    boolean isPallindrome(int x)
    {
        int y = x ; 
        int rev = 0 ;
        while(x>0)
        {
            rev <<= 1;
            rev |= (x&1);
            x >>= 1 ;
        }
        return (rev == y);
    }
}
public class binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bin = sc.nextLine();
        int binary = Integer.parseInt(bin,2);
        binarypallindrome obj = new binarypallindrome();
        if(obj.isPallindrome(binary))
        System.out.println("It is a binary pallindrome");
        else
        System.out.println("It is not a binary pallindrome");
    }
}


//o(logn)
//o(1)