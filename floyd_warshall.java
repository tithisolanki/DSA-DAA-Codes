import java.util.Scanner;

public class floyd_warshall {
    static int V;
    static int c[][] = new int[1000][1000];
    static int min(int a, int b)
    {
        return a<b ? a:b;
    }
    static void floyd()
    {
        for(int i=1; i<=V; i++)
            for(int j=1; j<=V; j++)
                for(int k=1; k<=V; k++)
                {
                    c[i][j] = min( c[i][j], c[i][k] + c[k][j] );
                }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vertices :"); V = sc.nextInt();
        System.out.println("Cost:");
        // read infinity as 999
        for(int i=1; i<=V; i++)
            for(int j=1; j<=V; j++)
            {
                c[i][j] = sc.nextInt();
            }

        floyd();

        System.out.println("All pair Shortest Path:");
        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++)
            {
                System.out.print(""+c[i][j]+" ");
            }
            System.out.println();
        }

        sc.close();
    }
}


