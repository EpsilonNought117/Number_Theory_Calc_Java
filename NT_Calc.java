package java_project;
import java.util.*;

class NT_Calc 
{   
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) 
    {

        System.out.println("\nThis is a Number Theory Calculator!");

        while (true)
        {
            System.out.println("\nPress 1 to use Strong Form Chinese Remainder Theorem Calculator.");
            System.out.println("Press 2 to use Euler Totient Function Calculator.");
            System.out.println("Press 3 to use Factorization Calculator.");
            System.out.println("Press 4 to use GCD Calculator");
            System.out.println("Press 5 to use Linear Congruence Calculator.");
            System.out.println("Press 6 to use Linear Diophantine Equation Calculator");
            System.out.println("Press 7 to Exit.");

            int n = 0;
            
            for (int i = 0; i < 1;)
            {
                System.out.printf("\nEnter your choice: ");
                String s = sc.next();
                char c[] = s.toCharArray();

                if (Func.check_if_int(c) == false || Func.check_max_int(c) == false)
                {   
                    System.out.println("The Input is too long or Invalid!");
                    continue;
                }
                else
                {

                    n = Func.parse_int(c);

                    if (n >= 1 && n <= 7)
                    {
                        i++;
                    }
                    else
                    {
                        System.out.println("Enter a Number between 1 and 7!!");
                        continue;
                    }
                }
            }


            if (n == 1)
            {
                CRT.main(args);
            }
            else if (n == 2)
            {
                ETF.main(args);
            }
            else if (n ==3)
            {
                FC.main(args);      
            }
            else if (n == 4)
            {
                GCD.main(args);
            }
            else if (n == 5)
            {
                LC.main(args);
            }
            else if (n == 6)
            {
                LDE.main(args);
            }
            else if (n == 7)
            {
                System.out.println("----------------------- Thank You for Using this Number Theory Calculator! -----------------------\n");
                System.exit(0);
            }

            System.out.println("\n--------------------------------------------------------------------------------------------------");
        }
    }
}
