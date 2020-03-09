package heapandquick;

public class HeapSort {
	int left(int i) {
		return 2 * i;
	}
	int right(int i) {
		return 2 * i + 1;
	}
	void max_heapify (int[] arr, int i) {
		int largest;
		int l = left(i);
		int r = right(i);
		if (l <= arr.length && arr[l] > arr[i]) {
			largest = l;
		}
		else {
			largest = i;
		}
		if (r <= arr.length && arr[l] > arr[largest]) {
			largest = r;
		}
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
		arr[largest] = temp;
			max_heapify(arr, largest);
		}
	}
	void build_max_heap (int[] arr){
		for (int i = arr.length / 2; i > 0; i--) {
			max_heapify(arr, i);
		}
	}
	void heapsort(int[] arr) {
		build_max_heap(arr);
		for (int i = arr.length; i < 1; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			max_heapify(arr, 1);
		}
	}
 }
