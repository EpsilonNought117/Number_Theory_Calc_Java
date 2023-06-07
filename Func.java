package java_project;
import java.util.ArrayList;

class Func        //Class of all Useful Functions to be used in the NT calculator
{
    public static void main(String[] args) 
    {}

    public static boolean check_max_int(char s[])       
    {   
        return (s.length > 9 ? false: true);  // Make sure size less than 9 digits
    }
    
    public static boolean check_max_long(char s[])       
    {   
        return (s.length > 18 ? false: true);  // Make sure size less than 18 digits
    }

    public static boolean check_if_int(char s[])
    {
        for (int i = 0; i < s.length; i++)
        {
            if (s[i] < '0' || s[i] > '9')
            {
                return false;                  //Check if parsing to long int is possible
            }
        }
        
        return true;
    }

    public static boolean check_div(long a, long b, long c)
    {
       return ((c % GCD.gcd(a, b)) == 0 ? true: false);
    }

    public static long parse_long(char s[])     //change input to long int if check_int returns true
    {   
        long num = 0;

        for ( int i = 0; i < s.length ; i++)
        {
            num += (s[i] - '0')*(Math.pow(10, (double) (s.length - i - 1 )));
        }
        return num;
    }

    public static int parse_int(char s[])     //change input to int if check_int returns true
    {   
        int num = 0;

        for ( int i = 0; i < s.length ; i++)
        {
            num += (s[i] - '0')*(Math.pow(10, (double) (s.length - i - 1 )));
        }
        return num;
    }

    public static ArrayList<Long> factors_once(long x) //find unique prime factors
    {
        long i = 2;
        ArrayList<Long> arr =  new ArrayList<Long>();

        while (i*i <= x)
        {
            if (x % i == 0)
            {
                arr.add(i);

                while (x % i == 0)
                {
                    x = x / i;
                }
            }

            i++;
        }

        if (x > 1)
        {
            arr.add(x);
        }

        return arr;

    }

    public static long reduce_gcd_arr(long[] arr)
    {   
        long g = arr[0];

        if (arr.length > 0)
        {
            for (int i = 1; i < arr.length; i++)
            {
                g = GCD.gcd(g, arr[i]);

                if (g == 1)
                {
                    return 1;
                }
            }
        }

        return g;
    }

    public static ArrayList<Long> factors_crt(long x)
    {
        long i = 2;
        long temp = 1;
        ArrayList<Long> arr =  new ArrayList<>();

        while (i*i <= x)
        {
            if (x % i == 0)
            {
                while (x % i == 0)
                {
                    temp *= i;
                    x = x / i;
                }

                arr.add(temp);
            }

            temp = 1;
            i++;
        }

        if (x > 1)
        {
            arr.add(x);
        }

        return arr;

    }

}