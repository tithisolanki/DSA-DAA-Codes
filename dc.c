#include<stdio.h>
#include<stdlib.h>
struct item 
{
    int min;
    int max;
};
struct item minmax(int a[], int low, int high)
{
    struct item i;
    if (low == high)
    {
        i.max = a[low];
        i.max = a[high];
    }
    else if(low == high-1)
    {
        if(a[low] > a[high])
        {
            i.max = a[low];
            i.min = a[high];
        }
        else
        {
            i.max = a[high];
            i.min = a[low];
        }
    }
    else
    {
        int mid = (low+high)/2;
        struct item l = minmax(a, low, mid);
        struct item r = minmax(a, mid+1, high);

        if(l.min > r.min)
        {
            i.min = r.min;
        }
        else
        {
            i.min = l.min;
        }

        if(l.max > r.max)
        {
            i.max = l.max;
        }
        else
        {
            i.max = r.max;
        }
    }
    return i;
}
    void main()
    {
        int n;
        printf("Enter no. of elements: ");
        scanf("%d",&n);
        int a[n];
        for(int i=0; i<n; i++)
        {
            scanf("%d",&a[i]);
        }

        struct item res = minmax(a, 0, n-1);
        printf("%d",res.min);
        printf("%d",res.max);
    }
