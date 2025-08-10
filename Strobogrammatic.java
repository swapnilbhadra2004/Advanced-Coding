import java.util.*;
public class Strobogrammatic
{
    static boolean isStrobogrammatic(String num)
    {
        HashMap<Character,Character>map = new HashMap<>();
        map.put('6','9');
        map.put('9','6');
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');
        int l = 0 ;
        int r = num.length() - 1 ; 
        while(l<=r)
        {
            if(!map.containsKey(num.charAt(l)) || !map.containsKey(num.charAt(r))) return false;
            if(!(map.get(num.charAt(l)) == num.charAt(r))) return false;
            l++;
            r--; 
        }
        return true;
    }
    public static void main(String[] args)
    {
           Scanner sc = new Scanner(System.in);
           String num = sc.next() ;
           if(isStrobogrammatic(num)) 
           System.out.println("It is strobogrammatic");
           else
           System.out.println("It is not strobogrammatic");
    }
}