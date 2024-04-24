import java.util.*;
public class Palindrome1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int n1=n;
        int s=0;
        while (n>0)
        {
            int r=n%10;
            s=(s*10)+r;
            n=n/10;
        }
        if(n==1)
            System.out.println("Number is Palindrome");
        else
            System.out.println("Number is not Palindrome");
    }
}
