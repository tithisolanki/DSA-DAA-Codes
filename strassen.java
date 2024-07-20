import java.util.Scanner;

public class strassen {
    public static void main(String[] args) {
        int p,q,r,s,t,u,v;
        int a[][] = new int [3][3];
        int b[][] = new int [3][3];
        int z[][] = new int [3][3];
        int i,j;
        Scanner sc = new Scanner(System.in);
        System.out.println("A:");
        for(i=1; i<=2; i++)
        {
            for(j=1;j<=2;j++)
            {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("B:");
        for(i=1; i<=2; i++)
        {
            for(j=1;j<=2;j++)
            {
                b[i][j] = sc.nextInt();
            }
        }

        p = (a[1][1] + a[2][2]) * (b[1][1] + b[2][2]);
        q = b[1][1] * (a[2][1] + a[2][2]);
        r = a[1][1] * (b[1][2] - b[2][2]);
        s = a[2][2] * (b[2][1] - b[1][1]);
        t = b[2][2] * (a[1][1] + a[1][2]);
        u = (a[2][1] - a[1][1]) * (b[1][1] + b[1][2]);
        v = (b[2][1] + b[2][2]) * (a[1][2] - a[2][2]);

        z[1][1] = p + s - t + v;
        z[1][2] = r + t;
        z[2][1] = q + s;
        z[2][2] = p + r - q + u;

        for(i=1; i<=2; i++)
        {
            for(j=1; j<=2; j++)
            {
                System.out. print(z[i][j]+" "); 
            }
            System.out.println();
        }
        
        sc.close();

    }
}