import java.util.Scanner;

public class coin_change_dynamic{
    static int coinchange(int coins[], int sum, int n)
    {
        int res[]=new int [1000];
        int sol[]=new int[1000];

        int i,j,value;
        res[0] = 0; sol[0] = 0;
        for(j=1; j<=sum; j++)
        {
            int min = 10000;
            int c=0;
            for(i=0; i<n; i++)
            {
                if(j >= coins[i])
                {
                    if((1 + res[j-coins[i]]) < min)
                    {
                        min = 1 + res[j - coins[i]];
                        c = i;
                    }
                }
            }
            res[j] = min;
            sol[j] = c;
        }

        value = sum;
        while(value > 0)
        {
            System.out.print(""+coins[sol[value]]+" ");
            value -= coins[sol[value]];
        }
        System.out.println();
        return res[sum];
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("No. of coins: ");
        n = sc.nextInt();
        int coins[] = new int[n];
        for(int i=0; i<n; i++)
            coins[i] = sc.nextInt();
        System.out.println("Sum : ");
        int sum = sc.nextInt();

        int min;
        min = coinchange(coins, sum, n);
        System.out.println("Minimum coins : "+min);
        sc.close();
    }
}