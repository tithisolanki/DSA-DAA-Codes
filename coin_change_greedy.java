import java.util.Scanner;

public class coin_change_greedy {
    static void greedy(int coin[], int sum, int n)
    {
        int i,j,temp;
        for(i=0; i<n; i++)
        {
            for(j=0; j<n-i-1; j++)
            {
                if(coin[j] < coin[j+1])
                {
                    temp = coin[j+1];
                    coin[j+1] = coin[j];
                    coin[j] = temp;
                }
            }
        }
        for(i=0; i<n; i++)
        {
            while(coin[i] <= sum)
            {
                System.out.print(""+coin[i]+" ");
                sum = sum - coin[i];
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("No. of coins: ");
        int n = sc.nextInt();
        int coin[] = new int[n];
        for(int i=0; i<n;i++)
        {
            coin[i] = sc.nextInt();
        }
        System.out.println("Sum : ");
        int sum = sc.nextInt();
        greedy(coin, sum, n);
        sc.close();
    }
}
