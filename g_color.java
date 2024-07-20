import java.util.Scanner;

public class g_color {
    static int Max=100;
    static int adjacency[][] = new int[Max][Max];
    static int colors[] = new int[Max];
    static int numV, numC;
    static int b = 1;

    static boolean promising(int v)
    {
        int i;
        for(i=0; i<v; i++){
            if(adjacency[v][i] == 1 && colors[i] == colors[v]){
                return false;
            }
        }
        return true;
    }
    static void coloring(int v)
    {
        int i, c;
        if(v == numV)
        {
            System.out.print("Vertex Color " +(b++)+" : ");
            for(i=0; i<numV; i++)
            {
                System.out.print(""+colors[i]+" ");
            }
            System.out.println();
            return;
        }
        for(c=1; c<=numC; c++)
        {
            colors[v] = c;
            if(promising(v))
            {
                coloring(v+1);
            }
            colors[v] = 0;
        }
    }
    public static void main(String[] args) {
        int i,j;
        Scanner sc = new Scanner(System.in);
        System.out.println("ENter no. of vertices:");
        numV = sc.nextInt();
        System.out.println("Enter no. of colors:");
        numC=sc.nextInt();

        System.out.println("Enter adjacency matrix:");
        for(i=0; i<numV; i++)
        {
            for(j=0; j<numV;j++)
            {
                adjacency[i][j] = sc.nextInt();
            }
        }

        for(i=0; i<numV; i++)
        {
            colors[i] = 0;
        }

        coloring(0);
        
    }
}
