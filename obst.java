import java.util.Scanner;

public class obst {
    static int max = 100;

    static void obst(float p[], int n)
    {
        float c[][] = new float[max][max];
        int i, k, len;
        float cost;

        float sum[] = new float[max];

        sum[0]=0;
        for(i=1; i<=n; i++)
        {
            c[i][i] = p[i];
            sum[i] = sum[i-1] + p[i];
        }

        for(len=2; len <= n; len++)
        {
            for(i=1; i<=(n-len+1); i++)
            {
                int j = i + len - 1;
                c[i][j] = Integer.MAX_VALUE;

                for(k = i; k<=j; k++)
                {
                    cost = c[i][k-1] + c[k+1][j] + sum[j] - sum[i-1];
                    if(cost < c[i][j])
                    {
                        c[i][j] = cost;
                    }
                }
            }
        }
        System.out.println("Cost of OBST : "+c[1][n]);
        return;

    }
    public static void main(String[] args) {
        int n, i;
        float p[] = new float[max];
        Scanner sc = new Scanner(System.in);
        System.out.println("No. of node: ");
        n = sc.nextInt();

        for(i=1; i<=n; i++)
        {
            System.out.println("p for node "+i+":");
            p[i] = sc.nextFloat();
        }

        obst(p, n);
        sc.close();
    }
}
