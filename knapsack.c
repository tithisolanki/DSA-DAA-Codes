#include<stdio.h>
#include<stdlib.h>

struct kp
{
    float w;
    float p;
    float pw;
};

int main()
{
    int cap, n;
    printf("Enter capacity: ");
    scanf("%d",&cap);
    printf("No. of items: ");
    scanf("%d",&n);
    struct kp item[n];
    for(int i=0; i<n; i++)
    {
        printf("Enter weight for item %d:",i+1);
        scanf("%f",&item[i].w);
        printf("Enter profit for item %d:",i+1);
        scanf("%f",&item[i].p);
        item[i].pw=item[i].p / item[i].w;
        printf("Profit per weigth : %f\n",item[i].pw);
    }
    //sorting in desc order wrt p/w
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n-i-1; j++)
        {
            if(item[j].pw < item[j+1].pw) 
            {
                struct kp temp = item[j];
                item[j] = item[j+1];
                item[j+1] = temp;
            }
        }
    }
    int currW = 0;
    float currP = 0;
    for(int i=0; i<n; i++)
    {
        if(currW + item[i].w <= cap)
        {
            // printf("%f",item[i].pw);
            currW += item[i].w;
            currP += item[i].p;
            // printf("%f\n",currP);
        }
        else
        {
            int rem = cap - currW;
            currP += item[i].p * (rem/item[i].w);
            
            break;
        }
    }
    printf("The maximum profit is : %f",currP);
    return 0;
}

