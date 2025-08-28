import java.util.* ; 
class binarypallindrome{
    boolean ispallindrome(int x)
    {
        int y = x ; 
        int rev = 0 ;
        while(x>0)
        {
            rev <<= 1 ; 
            rev |= (x&1);
            x >>= 1;
        }

        return(y == rev);
    }
}
public class prog1 {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in) ; 
    String input = sc.nextLine();
    int bin = Integer.parseInt(input,2);
    binarypallindrome obj = new binarypallindrome();
    if(obj.ispallindrome(bin)) System.out.println("binary pallindrome");
    else System.out.println("not a binary pallindrome");
}
}
