import java.util.Scanner;

public class kmp_string_matching {
    static int [] lpp(String p)
    {
        int m = p.length();
        int lpp[] = new int[m+1];
        int i=1; int j=0;
        while(i < m)
        {
            if(p.charAt(i) == p.charAt(j))
            {
                lpp[i] = j+i;
                j++;
                i++;
            }
            else
            {
                if(j > 0)
                {
                    j = lpp[j-1];
                }
                else
                {
                    lpp[i] = 0;
                    i++;
                }
            }
        }
        return lpp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string t:");
        String t = sc.nextLine();
        System.out.println("Enter string p:");
        String p = sc.nextLine();

        int n = t.length();
        int m = p.length();

        int []lpp = new int[m+1];
        lpp = lpp(p);//calling funct

        int i=0; int j=0;
        while(i < n)
        {
            if(p.charAt(j) == t.charAt(i))
            {
                if(j == m-1)
                {
                    System.out.println("String found at "+(i-m+1));
                    return;
                }
                i++;
                j++;
            }
            else
            {
                if(j > 0)
                {
                    j = lpp[j-1];
                }
                else
                {
                    i++;
                }
            }
        }
        System.out.println("Pattern not found");
        sc.close();
    }
}
