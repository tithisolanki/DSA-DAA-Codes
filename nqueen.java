import java.util.Scanner;

public class nqueen{
    static boolean place(int b[][], int r, int c, int N)
    {
        int i, j;
        for(i=0; i<c; i++)
            if(b[r][i] == 1)
                return false;
        
        for(i=r, j=c; i>=0 && j>=0; i--, j--)
            if(b[i][j] == 1)
                return false;

        for(i=r, j=c; i<N && j>=0; i++, j--)
            if(b[i][j] == 1)
                return false;

        return true;
    }
    static boolean solve(int b[][], int c, int N)
    {
        if (c >= N)
            return true;

        for(int i=0; i<N; i++)
        {
            if(place(b, i, c, N))
            {
                b[i][c] = 1;
                if(solve(b, c+1, N))
                    return true;

                b[i][c] = 0;
            }
        }
        return false;
    }
    static void print(int b[][], int N)
    {
        System.out.println("1.");
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                System.out.print(""+b[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("2.");
        for(int i=N-1; i>=0; i--)
        {
            for(int j=0; j<N; j++)
            {
                System.out.print(""+b[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of queens:");
        int N = sc.nextInt();
        int b[][] = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                b[i][j] = 0;

        if(!solve(b, 0, N))
        {
            System.out.println("Cannot Solve..!");
            sc.close();
            return;
        }

        print(b, N);
        sc.close();
    }
}