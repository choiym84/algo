#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#pragma warning(disable:4996)

int knowfirstindex(int *a) {

	int min = a[0];
	int index = 0;

	for (int i = 1; i < 3; i++) {

		if (min > a[i]) {
			min = a[i];
			index = i;
		}

	}

	return index;


}



int main() {

	int N;

	scanf("%d", &N);

	int arr[1002][3] = {0,};

	for (int i = 0; i < N; i++) {

		scanf("%d %d %d", &arr[i][0], &arr[i][1], &arr[i][2]);

	}

	for (int i = 0; i < N; i++) {

		int index = knowfirstindex(arr[i]);

		if (index == 0) {
			
			arr[i + 1][1] += arr[i][0];
			arr[i + 1][2] += arr[i][0];

			if (arr[i][1] > arr[i][2]) {
				arr[i + 1][0] += arr[i][2];
			}

			else {
				arr[i + 1][0] += arr[i][1];
			}
		
		
		
		}

		else if (index == 1) {
			arr[i + 1][0] += arr[i][1];
			arr[i + 1][2] += arr[i][1];

			if (arr[i][0] > arr[i][2]) {
				arr[i + 1][1] += arr[i][2];
			}

			else {
				arr[i + 1][1] += arr[i][0];
			}

		}

		else {
			arr[i + 1][0] += arr[i][2];
			arr[i + 1][1] += arr[i][2];

			if (arr[i][0] > arr[i][1]) {
				arr[i + 1][2] += arr[i][1];
			}

			else {
				arr[i + 1][2] += arr[i][0];
			}
		
		}





	}

	int min = arr[N-1][0];

	for (int i = 0; i < 3; i++) {
		if (min > arr[N - 1][i]) {
			min = arr[N - 1][i];
		}
	}

	printf("%d", min);




}