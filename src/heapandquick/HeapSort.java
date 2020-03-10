package heapandquick;

public class HeapSort {
	static int left(int i) {
		return 2 * i;
	}
	static int right(int i) {
		return 2 * i + 1;
	}
	static void max_heapify (int[] arr, int i, int heap_size) {
		int largest;
		int l = left(i);
		int r = right(i);
		if (l < heap_size && arr[l] > arr[i]) {
			largest = l;
		}
		else {
			largest = i;
		}
		if (r < heap_size && arr[r] > arr[largest]) {
			largest = r;
		}
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heap_size = heap_size + 1;
			max_heapify(arr, largest, heap_size);
		}
	}
	static void build_max_heap (int[] arr){
		int heap_size = arr.length;
		for (int i = arr.length / 2; i > 0; i--) {
			max_heapify(arr, i, heap_size);
		}
	}
	static void heapsort(int[] arr) {
		build_max_heap(arr);
		for (int i = arr.length-1; i > 1; i--) {
			int temp = arr[1];
			arr[1] = arr[i];
			arr[1] = temp;
			max_heapify(arr, 1, 0);
		}
	}
	public static void main(String[] args) {
		int[] heap = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
		int[] heap2 = {3, 5, 2, 6, 1, 4};
		heapsort(heap);
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i] + " ");
		}
	}
 }