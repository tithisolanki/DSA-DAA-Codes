#include <stdio.h>

#define MAX_JOBS 100

typedef struct Job {
    int id;
    int mt;
    char mn;
} Job;

// Function to sort the jobs array manually
void sort_jobs(Job arr[], int size) {
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (arr[j].mt > arr[j + 1].mt) {
                Job temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

void JhonsonJobs(Job arr[], int n, int ans[]) {
    int l = 0;
    int r = n - 1;

    // Sort the jobs array
    sort_jobs(arr, 2 * n);

    int arrSize = 2 * n;
    while (arrSize > 0) {
        Job j = arr[0];
        int id = j.id;

        if (j.mn == 'A') {
            ans[l++] = id;
        } else {
            ans[r--] = id;
        }

        int newSize = 0;
        for (int i = 1; i < arrSize; i++) { 
            if (arr[i].id != id) {
                arr[newSize++] = arr[i];
            }
        }
        arrSize = newSize;
        for (int i = 0; i < arrSize; i++) {
            arr[i] = arr[i + 1];
        }
    }
}

int main() {
    int n;
    printf("Enter number of jobs: ");
    scanf("%d", &n);

    Job arr[2 * MAX_JOBS];
    printf("Enter job no \t Machine 1 time \t Machine 2 time\n");
    for (int i = 0; i < n; i++) {
        printf("Seq %d==\n", i + 1);
        int id, mta, mtb;
        scanf("%d %d %d", &id, &mta, &mtb);
        arr[2 * i] = (Job){id, mta, 'A'};
        arr[2 * i + 1] = (Job){id, mtb, 'B'};
    }

    int ans[MAX_JOBS];
    JhonsonJobs(arr, n, ans);

    printf("The order of jobs by Jhonson are: ");
    for (int i = 0; i < n; i++) {
        printf("%d->", ans[i]);
    }
    printf("\n");

    return 0;
}

