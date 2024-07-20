import java.util.Scanner;

public class rabin_karp {
    static void rabin(String t, String p)
    {
        int n = t.length();
        int m = p.length();
        int thash=0; int phash = 0;
        int d =1;
        for(int j=1; j<=m; j++)
        {
            phash += p.charAt(j-1)*d;
            thash += t.charAt(j-1)*d;
            d = d*10;
        }
        // System.out.println("thash :"+thash);
        // System.out.println("phash :"+phash);
        int i;

        for(i=0; i<n-m; i++)
        {
            if(thash == phash)
            {
                boolean flag = true;
                for(int k=1; k<m; k++)
                {
                    // System.out.println(""+p.charAt(k)+ " "+t.charAt(i+k-1));
                    if(p.charAt(k) != t.charAt(i+k-1))
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag == true)
                {
                    System.out.println("Pattern found at "+i);
                    return;
                }
            }
            else
            {
                thash = 0;
                d=1;
                for(int j=0; j<m; j++)
                {
                    thash += t.charAt(i+j)*d;
                    d *= 10;
                }
                // System.out.println("*thash :"+thash);
            }
        }
        if(i==n-m)
        {
            System.out.println("Pattern not found");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t, p;
        System.out.println("Enter string t:");
        t = sc.nextLine();
        System.out.println("Enter string p:");
        p = sc.nextLine();

        rabin(t, p);
        sc.close();
    }
}