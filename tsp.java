import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class tsp {
    static int g[][] = new int [100][100];
    static int visited[];
    static int n;
    static int cost=0;
    static void tsp(int c)
    {
        int k;
        int index = 999;
        int min = 999;

        visited[c] = 1;
        System.out.print((c+1)+" ");
        for(k=0; k<n; k++)
        {
            if((g[c][k] != 0) && (visited[k] == 0))
            {
                if(min > g[c][k])
                {
                    min = g[c][k];
                    index = k;
                }
            }
        }
        if(min != 999)
        {
            cost += min;
        }
        if(index == 999)
        {
            index = 0;
            System.out.print(""+(index+1));
            cost += g[c][index];
            return;
        }
        tsp(index);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vertices: "); n = sc.nextInt();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                g[i][j] = sc.nextInt();
            }
        }
        visited = new int[n];
        Arrays.fill(visited, 0);
        System.out.println("Shortest path :");
        tsp(0);
        System.out.println(cost);
    }
}
