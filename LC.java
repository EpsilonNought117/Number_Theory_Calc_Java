package java_project;
import java.util.Scanner;

public class LC
{
    public static void main(String[] args) 
    {
        Scanner s1 = NT_Calc.sc;
        long arr[] = new long[3];

        int i = 0;

        System.out.println("\nEnter 3 Integers where the 1st Integer is the coefficient, 2nd Integer is modulus, and 3rd Integer is the residue.");
        
        while (i < 3)
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
                    System.out.println("The congruence cannot be solved for 0!");
                    continue;
                }
            }
        }

        if (Func.check_div(arr[0], arr[1], arr[2]) == false)
        {   
            System.out.println("No Solution Possible!");
            return;
        }
        else if (linearcong(arr[0], arr[1], arr[2]) % arr[1] > 0)
        {
            long k = linearcong(arr[0], arr[1], arr[2]) % arr[1];
            System.out.printf("The Solution to linear congruence %dx = %d (mod %d) is %d", arr[0], arr[2], arr[1], k);
        }
        else
        {
            long k = (linearcong(arr[0], arr[1], arr[2]) % arr[1]) + arr[1];
            System.out.printf("The Solution to linear congruence %dx = %d (mod %d) is %d", arr[0], arr[2], arr[1], k);
        }        
    }

    public static long linearcong(long a, long b, long c)
    {
        long g = GCD.gcd(a, b);

        if (g > 1)
        {
            a /= g;
            b /= g;
            c /= g;
        }

        if (b == 1)
        {
            return 1;
        }
        else
        {   
            long temp = a;
            a = b;
            b = temp % b;

            long u = linearcong(a, b, c);

            return (c - a*u)/b;
        }
    }

}
