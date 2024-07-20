import java.util.Scanner;

public class hamiltonian {
    static int max=10;
    static int g[][]=new int[max][max];
    static int V;

    static void print(int path[])
    {
        int i;
        System.out.println("Hamiltonian Cycle : ");
        for(i=0; i<V; i++)
        {
            System.out.print(""+(path[i]+1)+" ");
        }
        System.out.print(""+(path[0]+1));
        System.out.println();
    }   
    static boolean isSafe(int v, int path[], int pos)
    {
        int i;
        if(g[path[pos-1]][v] == 0) //edge between current vertex and last vertex
        {
            return false;
        }
        for(i=0; i<pos;i++) // vertex already selected
        {
            if(path[i] == v)
            {
                return false;
            }
        }
        return true;
    }
    static int cycle(int path[], int pos)
    {
        int count,v;
        if(pos == V)
        {
            if(g[path[pos-1]][path[0]] == 1)
            {
                print(path);
                return 1;
            }
            return 0;
        }
        count = 0;
        for(v=1; v<V; v++)
        {
            if(isSafe(v, path, pos))
            {
                path[pos]=v;
                count += cycle(path, pos+1);

                path[pos] = -1;
            }
        }
        return count;
    }
    static void hamil()
    {
        int i;
        int count;
        int path[] = new int[max];
        for(i=0; i<V; i++)
        {
            path[i] = -1;
        } 
        path[0] = 0;
        count = cycle(path, 1);

        if(count == 0)
        {
            System.out.println("No hamiltonian cycle");
        }
        else
        {
            System.out.println("Total : " +count);
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Vertices: ");
        V = sc.nextInt();
        System.out.println("Adajency MAtrix : ");
        for(int i=0; i<V; i++)
            for(int j=0; j<V; j++)
                g[i][j] = sc.nextInt();

        hamil();
        sc.close();
    }
    }