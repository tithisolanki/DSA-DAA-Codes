#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
struct job
{
   int p;
   int d;
   int no;
};
int min(int a, int b)
{
    return a>b?b:a;
}
//sorting desc order wrt to profit
void sort(struct job item[], int n)
{
    for(int i=1; i<=n; i++)
    {
        for(int j=1; j<=n-i-1; j++)
        {
            if(item[j].p < item[j+1].p)
            {
                struct job temp = item[j];
                item[j] = item[j+1];
                item[j+1] = temp;
            }
        }
    }
}

void sequencing(struct job item[], int n)
{
    sort(item,n);

    int res[n+1];
    bool slot[n+1];

    for(int i=1; i<=n; i++)
        slot[i] = false;

    for(int i=1; i<=n; i++)
    {
        for(int j=min(n, item[i].d); j>0; j--)
        {
            if(slot[j] == false)
            {
                res[j] = i;
                slot[j] = true;
                break;
            }
        }
    }

    for(int i=1; i<n; i++)
    {
        if(slot[i])
        {
            printf("%d -> ",item[res[i]].no);
        }
    }

}
void main()
{
    int n;
    printf("No. of jobs:");
    scanf("%d",&n);
    struct job item[10];

    for(int i=1; i<=n; i++)
    {
        scanf("%d",&item[i].p);
        scanf("%d",&item[i].d);
        item[i].no = i;
    }

    sequencing(item,n);
}


//No. of jobs:5
// 20
// 2
// 15
// 2
// 10
// 1
// 5
// 3
// 1
// 3
// 2 -> 1 -> 4 ->