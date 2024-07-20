#include<stdio.h>
// #include<stdlib.h>
// #include<limits.h>
#define MAX 100
#define MAX_VAL 1000
int coin_change(int coins[], int total, int n)
{
    int res[MAX_VAL + 1];
    int sol[MAX_VAL + 1];

    int i, j;
    int value;
    res[0] = 0;
    sol[0] = 0;
    for(j=1; j<=total; j++)
    {
        int min = 10000;
        int c=0;
        for(i=0; i<n; i++){
            if(j >=coins[i]){
                if((1 + res[j-coins[i]]) < min)
                {
                    min = 1 + res[j-coins[i]];
                    c = i;
                }
            }
        }
        res[j] = min;
        sol[j] = c;
    }
    printf("Selected Coins: ");
    value = total;
    while(value > 0)
    {
        printf("%d\n", coins[sol[value]]);
        value -= coins[sol[value]];
    }
    // free(sol);
    return res[total];
}

void main(){
    int coin, total;
    int min_coin, i;
    int coins[MAX];
    printf("No. of coins :");
    scanf("%d",&coin);
    printf("Sum :");
    scanf("%d",&total);
    printf("Coins : ");
    for(i=0;i<coin;i++)
        scanf("%d",&coins[i]);
    min_coin = coin_change(coins, total, coin);
    printf("Minimum coins: %d",min_coin);
    // free(coins);
}
