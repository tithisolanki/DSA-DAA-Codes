import java.util.Scanner;

public class knapsack {
    static int MAX = 1000;
    static int max(int a, int b)
    {
        return a<b ? b:a;
    }
    static int knapsack(int p[],int w[], int cap, int n)
    {
        int profit[][] = new int [MAX][MAX];
        for(int i=0; i<=n; i++)
        {
            for(int j=0; j<=cap; j++)
            {
                if( i == 0 || j == 0 )
                {
                    profit[i][j] = 0;
                }
                else if(w[i] <= j)
                {
                    profit[i][j] = max(profit[i-1][j], profit[i-1][j-w[i]]+p[i]);
                }
                else
                {
                    profit[i][j] = profit[i-1][j];
                }
            }
        }
        return profit[n][cap];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("No. of items: ");
        int n = sc.nextInt();
        int p[]=new int[n+1];
        int w[] = new int[n+1];
        for(int i=0; i<n; i++)
            p[i] = sc.nextInt();
        for(int i=0; i<n; i++)
            w[i] = sc.nextInt();
        System.out.println("Capacity : ");
        int cap = sc.nextInt();
        int profit = knapsack(p, w, cap, n);
        System.out.println(profit);
        sc.close();
    }
}
