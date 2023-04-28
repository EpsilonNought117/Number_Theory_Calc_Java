package java_project;
import java.util.Scanner;
import java.util.ArrayList;

public class ETF 
{
    public static void main(String[] args)
    {
        Scanner s1 = NT_Calc.sc;
        long arr1[] = new long[1];
        int i = 0;

        System.out.println("This is an Euler Totient Function Calculator.");

        while (i < 1)
        {
            System.out.printf("\nEnter the Integer: ");
            String s = s1.next();
            char c[] = s.toCharArray();

            if (Func.check_if_int(c) == false || Func.check_max_long(c) == false)
            {   
                System.out.println("The Input is too long or Invalid!");
                continue;
            }
            else
            {
                if ((arr1[i] = Func.parse_long(c)) > 0)
                {
                    i++;
                }
                else
                {
                    System.out.println("The positive integers co-prime to 0 cannot be found!");
                    continue;
                }
            }
        }

        System.out.printf("\nThe number of positive Integers less than %d and Co-prime to it are %d", arr1[0], euler_tot(arr1[0]));

        
    }

    public static long euler_tot(long x)
    {
        ArrayList<Long> arr = Func.factors_once(x);
        long prod = x;

        for (int i = 0; i < arr.size(); i++)
        {
            long y = arr.get(i);

            prod *= (y-1);
            prod /= y;
        }

        return prod;
    }
}
