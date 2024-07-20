public class matrixmulti {
    static int matrix(int m[], int n)
    {
        int cost[][]=new int[n][n];
        for(int i=1; i<n; i++)
            cost[i][i] = 0;
        
        for(int l=2; l<n; l++)
        {
            for(int i=1; i<n-l+1; i++)
            {
                int j = i + l -1;
                cost[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++)
                {
                    int q = cost[i][k] + cost[k+1][j] + m[i-1]* m[k]*m[j];
                    if(q < cost[i][j])
                    {
                        cost[i][j] = q;
                    }
                }
            }
        }
        return cost[1][n-1];
    }
    public static void main(String[] args) {
        int a[] = {3,2,4,2,5};
        int n = 5;
        int min = matrix(a, n);
        System.out.println("Minimum Cost : "+min);
    }
}