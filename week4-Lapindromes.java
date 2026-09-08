import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T-->0)
		{
		    String s=sc.next();
		    int n = s.length();

            int[] a = new int[26];
            int[] b = new int[26];

            for (int i = 0; i < n / 2; i++)
                a[s.charAt(i) - 'a']++;

            for (int i = (n + 1) / 2; i < n; i++)
                b[s.charAt(i) - 'a']++;

            if (Arrays.equals(a, b))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
	}
}