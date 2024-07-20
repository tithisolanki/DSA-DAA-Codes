public class longest_common_subsequence {
    static int max(int a, int b)
        {return a>b?a:b;}

    static int bottomup(String s, String t)
    {
        int n = s.length();
        int m = t.length();
        String words = "";
        int lcs[][] = new int[n+1][m+1];

        for(int i=0; i<=n; i++)
        {
            for(int j=0; j<=m; j++)
            {
                if( i == 0 || j == 0)
                {
                    lcs[i][j] = 0;
                    continue;
                }
                if(s.charAt(i-1) == t.charAt(j-1))
                {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                }
                else
                {
                    lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        if(words != "")
        {
            System.out.println(words);
        }

        return lcs[n][m];
    }
    public static void main(String[] args) {
        int max = bottomup("flongest", "stone");
        System.out.println(max);
    }
}
