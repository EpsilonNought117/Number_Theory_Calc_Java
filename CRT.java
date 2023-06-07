package java_project;
import java.util.*;

public class CRT 
{
    public static void main(String[] args) 
    {
        
        Scanner s1 = NT_Calc.sc;
        System.out.println("This is a Strong Form Chinese Remainder Theorem Calculator!");
        int n = 0;

        for (int i = 0; i < 1;)
        {
            System.out.printf("\nEnter the total number of Simulataneous Congruences: ");
            String s = s1.next();
            char c[] = s.toCharArray();

            if (Func.check_if_int(c) == false || Func.check_max_int(c) == false)
            {   
                System.out.println("The Input is too long or Invalid!");
                continue;
            }
            else
            {
                if ((n = Func.parse_int(c)) > 0)
                {
                    i++;
                }
                else
                {
                    System.out.println("There Cannot be 0 Congruences!");
                    continue;
                }
            }
        }

        long[] coeffs = new long[n];
        long[] residue = new long[n];
        long[] moduli = new long[n];

        ArrayList<Long> coeffs_new = new ArrayList<Long>();
        ArrayList<Long> residue_new = new ArrayList<Long>();
        ArrayList<Long> co_prime_moduli = new ArrayList<Long>();

        for (int j = 0; j < n; j++)
        {

            System.out.printf("Enter Details of Congruence %d: ", j+1);
            System.out.println("First Number will be the coefficient, second will be the residue, third will be the modulus.");

            for (int i = 0; i < 3;)
            {
                System.out.printf("\nEnter Number %d: ", i+1);
                String s = s1.next();
                char c[] = s.toCharArray();

                if (Func.check_if_int(c) == false || Func.check_max_long(c) == false)
                {   
                    System.out.println("The Input is too long or Invalid!");
                    continue;
                }
                else
                {
                    if (Func.parse_long(c) > 0)
                    {
                        long u = Func.parse_long(c);
                        switch (i)
                        {
                            case 0:
                            coeffs[j] = u;
                            break;

                            case 1:
                            residue[j] = u;
                            break;

                            case 2:
                            moduli[j] = u;
                            break;
                        }
                        
                        i++;
                    }
                    else if (Func.parse_int(c) == 0)
                    {
                        if (i == 1)
                        {
                            residue[j] = 0;
                            i++;
                        }
                        else
                        {
                            System.out.println("The Moduli or Coefficient cannot be 0!!");
                            continue;
                        }
                    }
                }
            }
        }

        System.out.println("For the following system of congruences: ");

        for (int i = 0; i < n; i++)
        {
            if (i == (n-1))
            {
                System.out.printf("\n%dx = %d(mod %d)", coeffs[i], residue[i], moduli[i]);
                System.out.printf("\nThe solution is: \n");
            }
            else
            {
                System.out.printf("\n%dx = %d(mod %d)", coeffs[i], residue[i], moduli[i]);
            }
        }

        for(int k = 0; k < n; k++)
        {
            ArrayList<Long> temp = Func.factors_crt(moduli[k]);
            co_prime_moduli.addAll(temp);

            for (int i = 0; i < temp.size(); i++)
            {
                residue_new.add(residue[k]);
                coeffs_new.add(coeffs[k]);
            }
        }

        coeffs = null;
        residue = null;
        moduli = null;

        for (int j = 0; j < co_prime_moduli.size(); j++)
        {
            long g = GCD.gcd(coeffs_new.get(j), co_prime_moduli.get(j));

            if (g != 1)
            {   
                if (residue_new.get(j) % g == 0)
                {
                    coeffs_new.set(j, Long.valueOf(-1));
                    residue_new.set(j, Long.valueOf(-1));
                    co_prime_moduli.set(j, Long.valueOf(-1));

                }
                else
                {
                    System.out.println("No Solutions possible!");
                    return;
                }
            }
        }

        coeffs_new.removeAll(Collections.singleton(Long.valueOf(-1)));
        co_prime_moduli.removeAll(Collections.singleton(Long.valueOf(-1)));
        residue_new.removeAll(Collections.singleton(Long.valueOf(-1)));

        for (int i = 0; i < coeffs_new.size();i++)
        {
            Long x = LC.linearcong(coeffs_new.get(i), co_prime_moduli.get(i), 1);
            residue_new.set(i, ((x*residue_new.get(i)) % co_prime_moduli.get(i)));
            coeffs_new.set(i ,Long.valueOf(1));

            if (residue_new.get(i) < 0)
            {
                residue_new.set(i , residue_new.get(i) + co_prime_moduli.get(i));
            }
        }

        coeffs_new = null;

        for (int i = 0; i < co_prime_moduli.size() ; i++)
        {

            if(co_prime_moduli.get(i) == -1)
            {
                continue;
            }

            for (int j = i+1 ; j < co_prime_moduli.size(); j++)
            {

                if (co_prime_moduli.get(j) == -1)
                {
                    continue;
                }

                long g = GCD.gcd(co_prime_moduli.get(i), co_prime_moduli.get(j));
            
                if (g != 1 && (residue_new.get(i) - residue_new.get(j)) % g != 0)
                {
                    System.out.println("No Solutions Possible!");
                    return;
                }
                else if (g != 1)
                {
                    if (co_prime_moduli.get(i) > co_prime_moduli.get(j))
                    {
                        co_prime_moduli.set(j, Long.valueOf(-1));
                        residue_new.set(j, Long.valueOf(-1));
                    }
                    else
                    {
                        co_prime_moduli.set(i, Long.valueOf(-1));
                        residue_new.set(i, Long.valueOf(-1));
                        break;
                    }
                }
            }
        }

        co_prime_moduli.removeAll(Collections.singleton(Long.valueOf(-1)));
        residue_new.removeAll(Collections.singleton(Long.valueOf(-1)));

        long[] final_moduli = new long[co_prime_moduli.size()];
        long[] final_residue = new long[residue_new.size()];

        for (int i = 0; i < co_prime_moduli.size(); i++)
        {
            final_moduli[i] = co_prime_moduli.get(i);
            final_residue[i] = residue_new.get(i);
        }

        co_prime_moduli = null;
        residue_new = null;

        long lcm = 1;

        for (int k = 0; k < final_moduli.length; k++)
        {
            lcm *= final_moduli[k];
        }

        System.out.printf("The Solution to following Simulatenous Congruences is %d (mod %d).", chinese_remainder(final_residue, final_moduli), lcm);

        final_moduli = null;
        final_residue =  null;

        
    }

    public static long chinese_remainder(long[] residue, long[] moduli)
    {
        long X = 0;
        long N = 1;

        for (int i = 0; i < moduli.length; i++)
        {
            N *= moduli[i];
        }

        long[] N_i = new long[moduli.length];

        for (int j = 0; j < moduli.length; j++)
        {
            N_i[j] = N/(moduli[j]);
        }

        for (int k = 0; k < moduli.length; k++)
        {
            long N_i_inv = LC.linearcong(N_i[k], moduli[k], 1);

            X += (N_i[k])*(N_i_inv)*(residue[k]);

        }

        X = (X > 0 ? X % N:(X % N) + N);
        return X;
    }

}
