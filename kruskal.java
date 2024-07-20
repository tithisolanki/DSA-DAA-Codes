import java.util.Scanner;

public class kruskal {
    static int [][]c = new int[100][100];
    static int []p = new int[10];
    static int cost = 0;
    static int find(int i)
    {
        while(p[i] > 0)
        {
            i = p[i];
        }
        return i;
    }
    static int union(int i, int j)
    {
        if(i!=j)
        {
            p[j] = i;
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of Vertices:");
        int n = sc.nextInt();
        int i,j, a=0,b=0,u=0,v=0;


        for(i=1; i<=n; i++)
        {
            for(j=1; j<=n; j++)
            {
                c[i][j] = sc.nextInt();
                if(c[i][j] == 0)
                    c[i][j] = Integer.MAX_VALUE;
            }
        }
        int ctr = 1; int min=999;
        while(ctr < n)
        {
            for(i=1,min=999; i<=n; i++)
            {
                for(j=1; j<=n; j++)
                {
                    if(min > c[i][j])
                    {
                        min = c[i][j];
                        a=u=i;
                        b=v=j;
                    }
                }
            }
            u = find(u);
            v = find(v);
            if(union(u, v) == 1)
            {
                System.out.println(""+(ctr)+" edge ("+a+","+b+") -> "+min);
                cost += min;
                ctr++;
            }
            c[a][b] = 999;
            c[b][a] = 999;
        }
        System.out.println("Minimum cost: "+cost);
    }
}
