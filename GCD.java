package java_project;
import java.util.Scanner;

public class GCD
{
    public static void main(String[] args) 
    {
        Scanner s1 = NT_Calc.sc;
        long arr[] = new long[2];
        int i = 0;

        System.out.println("\nEnter 2 Integers to find their GCD.");
        
        while (i < 2)
        {
            System.out.printf("\nEnter Integer %d: ", i+1);
            String s = s1.next();
            char c[] = s.toCharArray();

            if (Func.check_if_int(c) == false || Func.check_max_long(c) == false)
            {   
                System.out.println("The Input is too long or Invalid!");
                continue;
            }
            else
            {
                if ((arr[i] = Func.parse_long(c)) > 0)
                {
                    i++;
                }
                else
                {
                    System.out.println("The GCD Cannot be found for 0!");
                    continue;
                }
            }
        }
        
        System.out.printf("\nThe GCD of %d and %d is %d.\n", arr[0], arr[1], gcd(arr[1], arr[0]));

    }

    public static long gcd(long a, long b)
    {
        long temp = 0;
        
        if (b > a)
        {
            temp = a;
            a = b;
            b = temp;
        }

        if (b == 0)
        {
            return a;
        }
        else
        {
            return gcd(b, a % b);
        }
    }

}