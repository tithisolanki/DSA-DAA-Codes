import java.util.Scanner;

public class subsetsum {
    static int n;
    static int x[] = new int[10];
    static int w[] = new int[10];
    static int sum;
    static int b=1;

    static void subset(int s, int k, int r)
    {
        int i;
        x[k] = 1;

        if(s + w[k] == sum)
        {
            System.out.println("Subset : " +b++);
            for(i = 1; i<=k; i++)
            {
                if(x[i] == 1)
                System.out.print(""+w[i]+" ");
            }
            System.out.println();
            return;
        }
        
        if (k > n || s > sum) 
        {
            return;
        }


        if(s + w[k] + w[k+1] <= sum)
        {
            subset(s+w[k], k+1, r-w[k]);
        }
        

        if(s - r + w[k] >= sum && s + w[k+1] <= sum)
        {
            x[k] = 0;
            subset(s, k+1, r-w[k]);
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Sum: ");
        sum = sc.nextInt();
        System.out.print("No. of Elements:"); 
        n = sc.nextInt();
        int total = 0;
        for(int i=1;i<=n; i++)
        {
            System.out.print("Element:");
            w[i] = sc.nextInt();
            total += w[i];
        }
        if(total < sum || w[1] > sum)
        {
            System.out.println("No solutions..!");
            sc.close();
            return;
        }
        
        subset(0,1,total);

        sc.close();
    }
}
