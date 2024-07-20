public class prim {
    static int V=6;
    public static int minKey(int []cost, boolean []visited)
    {
        int min = Integer.MAX_VALUE;
        int min_index=0;

        for(int v=0; v<V; v++)
        {
            if(visited[v] == false && cost[v] < min)
            {
                min = cost[v];
                min_index=v;
            }
        }
        return min_index;
    }
    public static void print(int parent[], int graph[][])
    {
        int mincost = 0;
        for(int i=1;i<V; i++)
        {
            System.out.println("("+(parent[i]+1)+", "+(i+1)+" -> " +graph[i][parent[i]]);
            mincost+=graph[i][parent[i]];
        }
        System.out.println("The total MINCOST :" +mincost);
    }
    public static void prims(int graph[][])
    {
        int parent[] = new int[V];
        int cost[]=new int[V];
        boolean visited[]= new boolean[V];
        
        for(int i=0; i<V; i++)
        {
            cost[i]=Integer.MAX_VALUE;
            visited[i] = false;
        }
        cost[0]=0; parent[0]=-1;

        for(int i=0; i<V-1; i++)
        {
            int u=minKey(cost, visited);
            visited[u] = true;
            for(int v=0; v<V; v++)
            {
                if(graph[u][v] > 0 && visited[v] == false && graph[u][v] < cost[v])
                {
                    cost[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }
        print(parent, graph);
    }
    public static void main(String args[])
    {
        int graph[][] = {{0,8,1,0,0,0},
                        {8,0,5,2,0,0},
                        {1,5,0,0,7,0},
                        {0,2,0,0,2,3},
                        {0,0,7,2,0,15},
                        {0,0,0,3,15,0}};
        prims(graph);
    }
}
