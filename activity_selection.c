#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct act
{
    /* data */
    int no;
    int s;
    int f;
};
//sort act in asc wrt finish time
void sort(struct act item[], int n)
{
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n-i-1;j++)
        {
            if(item[j].f > item[j+1].f)
            {
                struct act temp = item[j];
                item[j] = item[j+1];
                item[j+1] = temp;
            }
        }
    }
}
void selection(struct act item[], int n)
{
    sort(item, n);
    int i=0;
    printf("%d ",item[i].no);
    for(int j=1; j<n; j++)
    {
        if(item[j].s >= item[i].f)
        {
            printf("%d ",item[j].no);
            i = j;
        }
    }   
}
void main(){
    int n;
    printf("No. of activities : ");
    scanf("%d",&n);
    struct act item[n];
    for(int i=0; i<n; i++)
    {
        printf("Start Time for %d:",(i+1));
        scanf("%d",&item[i].s);
        printf("Finish Time for %d:",(i+1));
        scanf("%d",&item[i].f);
        item[i].no = i+1;
    }

    selection(item, n);
}
