import java.util.Scanner;

public class hamiltonian_cycle {
    static int max =10;
    static int V;
    static int g[][] = new int[max][max];
    static void print(int path[])
    {
        System.out.println("Cycle: ");
        for(int i=0; i<V; i++)
        {
            System.out.print(""+path[i]+" ");
        }
        System.out.print(""+path[0]);
        System.out.println();
    }
    static boolean safe(int path[], int pos, int v)
    {
        if(g[path[pos-1]][v] == 0)
            return false;
        for(int i=0; i<V; i++)
        {
            if(path[i] == v)
                return false;
        }
        return true;
    }
    static int cycle(int pos, int path[])
    {
        int count, v;
        if(pos == V)
        {
            if(g[path[pos-1]][path[0]] == 1)
                {
                    print(path);
                    return 1;
                }
            else 
                return 0;
        }
        count = 0;
        for(v=0; v<V; v++)
        {
            if(safe(path, pos, v))
            {
                path[pos] = v;
                count += cycle(pos+1, path);
                path[pos]=-1;
            }
        }
        return count;
    }
    static void hami(){
        int count;
        int path[] = new int[V];
        for(int i=0; i<V; i++)
        {
            path[i]=-1;
        }
        path[0] = 0;

        count = cycle(1, path);
        if(count == 0)
        {
            System.out.println("fail");
        }
        else
        {
            System.out.println(count);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vertices:");
        V = sc.nextInt();
        for(int i=0; i<V; i++)
            for(int j=0; j<V; j++)
                g[i][j]=sc.nextInt();

        hami();
        sc.close();
    }
}
