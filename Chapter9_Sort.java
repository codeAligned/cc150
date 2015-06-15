Mergesort divides the array in half, sorts each of those halves, and then merge them back together.
Runtime O(nlogn) average and worst case. Memory: Depends

void mergesort(int[] array) {
	int[] helper = new int[array.length];
	mergesort(array, helper, 0, array.length-1);
}

void mergesort(int[] array, int[] helper, int low, int high) {
	if(low<high) {
		int mid = (low+high)/2;
		mergesort(array, helper, low, mid);
		mergesort(array, helper, mid+1, high);
		merge(array, helper, low, mid, high);
	}
}

void merge(int[] array, int[] helper, int low, int mid, int high) {
	for(int i=low; i<=high; i++)
		helper[i] = array[i];

	int left = low, right = mid+1, current = low;

}


Quicksort


Radix Sort Runtime: O(kn)
Iterate through each digit of the number, grouping numbers by each digit. First sort by the first digit, so the 0s are grouped
together. Then we sort each of these groupings by the next digit. Repeat this process sorting by each subsequent digit