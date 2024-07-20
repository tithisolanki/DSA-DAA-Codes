import java.util.Scanner;

public class naive_string {
    static void naive(String t, String p)
    {
        int n = t.length();
        int m = p.length();
        int j, k= 0;
        for(int i=0; i<=n-m; i++)
        {
            if(t.charAt(i) == p.charAt(0))
            {
                for(j=0; j<m; j++)
                {
                    if(t.charAt(i+j) != p.charAt(j))
                    {
                        break;
                    }
                }
                if(j == m)
                {
                    System.out.println("Pattern found at "+ (i+1));
                    k++;
                }
            }
        }
        if(k > 0)
        {
            return;
        }
        else
        {
            System.out.println("Pattern not found");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string t:");
        String t = sc.nextLine();
        System.out.println("Enter string p:");
        String p = sc.nextLine();

        naive(t, p);

        sc.close();
    }
}
