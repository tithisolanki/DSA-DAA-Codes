import java.util.Scanner;

public class dijkstra{
    static int V;
    static int [][]g = new int[1000][1000];
    static int d[] = new int[1000];

    static void dij(int s){
        int visited[] = new int[10];
        int min;
        for(int i=1; i<=V; i++)
        {
            visited[i] = 0;
            d[i] = g[s][i];
        }
        visited[s] = 1;
        d[s] = 0;

        int ctr = 1, v=0;
        while(ctr <= V)
        {
            min = 999;
            for(int i=1; i<=V; i++)
            {
                if(min > d[i] && visited[i] == 0)
                {
                    min = d[i];
                    v = i;
                }
            }

            visited[v] = 1;
            ctr++;

            for(int i=1; i<=V; i++)
            {
                if(d[i] > d[v] + g[v][i])
                {
                    d[i] = d[v] + g[v][i];
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

        dij(s);

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