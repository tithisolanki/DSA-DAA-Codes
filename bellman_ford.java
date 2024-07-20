import java.util.Scanner;

public class bellman_ford{
    static int V;
    static int g[][] = new int[1000][1000];
    static int d[] = new int[10];

    static void bell(int s)
    {
        for(int i=1; i<=V; i++)
        {
            d[i] = 999;
        }
        d[s] = 0;
        for(int i=1; i<V; i++)
            for(int u=1; u<=V; u++)
            {
                for(int v=1; v<=V; v++)
                {
                    if( u == v)
                    {
                        continue;
                    }
                    if(d[u] + g[u][v] < d[v])
                    {
                        d[v] = d[u] + g[u][v];
                    }
                }
            }

    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vertices :");
        V = sc.nextInt();
        System.out.println("Cost:");
        for(int i=1; i<=V; i++)
        {
            for(int j=1; j<=V; j++)
            {
                g[i][j] = sc.nextInt();
                if(g[i][j] == 0)
                {
                    g[i][j] = 999;
                }
            }
        }
        System.out.println("Source: ");
        int s = sc.nextInt();

        bell(s);

        for(int i=1; i<=V; i++)
        {
            if(s!=i)
            {
                System.out.println(""+s+ "->"+i+":"+d[i]);
            }
        }

        sc.close();
    }
}
