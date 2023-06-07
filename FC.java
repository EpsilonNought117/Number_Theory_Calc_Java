package java_project;
import java.util.Scanner;
import java.util.ArrayList;

class FC 
{
    public static void main(String[] args) 
    {

        Scanner s1 = NT_Calc.sc;
        long num[] = new long[1];
        int i = 0;

        System.out.println("This is a factorization calculator. Enter an Integer to factor into primes.");

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
                if ((num[i] = Func.parse_long(c)) > 0)
                {
                    i++;
                }
                else
                {
                    System.out.println("The Integer 0 cannot be factored!");
                    continue;
                }
            }
        }

        System.out.printf("\nThe Factors of %d are: ", num[0]);
        System.out.print(factors(num[0]) + "\n");
    }

    
    public static ArrayList<Long> factors(long x)
    {
        long i = 2;
        ArrayList<Long> arr =  new ArrayList<Long>();

        while (i*i <= x)
        {
            while (x % i == 0)
            {
                arr.add(i);
                x = x / i;   
            }
            

            i++;
        }

        if (x > 1)
        {
            arr.add(x);
        }

        return arr;

    }
}

