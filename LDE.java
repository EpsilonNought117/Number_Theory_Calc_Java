package java_project;
import java.util.Scanner;
import java.util.Arrays;

public class LDE 
{
    public static void main(String[] args) 
    {
        Scanner s1 = NT_Calc.sc;
        System.out.println("This is a linear Diophantine Equation Solver.");
        int n_ = 0;

        for (int i = 0; i < 1;)
        {
            System.out.printf("\nEnter the total number of Integer coefficients in the LDE: ");
            String s = s1.next();
            char c[] = s.toCharArray();

            if (Func.check_if_int(c) == false || Func.check_max_int(c) == false)
            {   
                System.out.println("The Input is too long or Invalid!");
                continue;
            }
            else
            {
                if ((n_= Func.parse_int(c)) > 0)
                {
                    i++;
                }
                else
                {
                    System.out.println("There Cannot be 0 coefficients!");
                    continue;
                }
            }
        }

        long N = 0;

        for (int i = 0; i < 1;)
        {
            System.out.printf("\nEnter RHS of LDE: ");
            String s = s1.next();
            char c[] = s.toCharArray();

            if (Func.check_if_int(c) == false || Func.check_max_long(c) == false)
            {   
                System.out.println("The Input is too long or Invalid!");
                continue;
            }
            else
            {
                if ((N = Func.parse_long(c)) > 0)
                {
                    i++;
                }
                else
                {
                    System.out.println("0 cannot be in the RHS!");
                    continue;
                }
            }
        }

        long coeff[] = new long[n_];

        for (int i = 0; i < n_;)
        {
            System.out.printf("\nEnter Coefficient %d: ", i+1);
            String s = s1.next();
            char c[] = s.toCharArray();

            if (Func.check_if_int(c) == false || Func.check_max_long(c) == false)
            {   
                System.out.println("The Input is too long or Invalid!");
                continue;
            }
            else
            {
                if ((coeff[i] = Func.parse_int(c)) > 0)
                {   
                    for (int j = 0; j < i; j++)
                    {
                        if (coeff[j] == coeff[i])
                        {
                            System.out.println("There Cannot be Duplicate Coefficients!");
                            i--;
                            break;
                        }
                    }
                    i++;
                }
                else
                {
                    System.out.println("0 cannot be a coefficient!");
                    continue;
                }
            }
        }

        if (N % Func.reduce_gcd_arr(coeff) != 0)
        {
            System.out.println("No Integer Solutions Possible!");
            return;
        }
        
        System.out.println("\nThe Solution of the following Linear Diophantine Equation is: \n");

        long[] sol = lde(coeff, N);

        for (int i = 0; i < coeff.length; i++)
        {
            if (i != coeff.length - 1)
            {
                System.out.printf(" %d*(%d) +", coeff[i], sol[i]);
            }
            else
            {
                System.out.printf("%d*(%d) = %d\n", coeff[i], sol[i], N);
            }

        }
        
        

    }

    public static long[] lde(long[] coeff, long N)
    {
        long[] sol = new long[coeff.length];
        
        for (int i = (coeff.length - 1); i > 0; i--)
        {   
    
            long[] temp = Arrays.copyOfRange(coeff, 0, i);

            if (i > 1)
            {
                long g = Func.reduce_gcd_arr(temp);
                long b = coeff[i];

                sol[i] = LC.linearcong(b, g, N);
                N = (N - sol[i]*coeff[i]);
            }
            else
            {
                sol[1] = LC.linearcong(coeff[1], coeff[0], N);
                sol[0] = (N - sol[1]*coeff[1])/coeff[0];     
            }
        }

        return sol;
    }
}