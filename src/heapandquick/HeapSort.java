package heapandquick;
import java.util.*;
public class HeapSort {
	static int left(int i) {
		return 2 * i + 1;
	}
	static int right(int i) {
		return 2 * i + 2;
	}
	static void max_heapify (int[] arr, int i, int heap_size) {
		int largest;
		int l = left(i);
		int r = right(i);
		if (l <= heap_size && arr[l] > arr[i]) {
			largest = l;
		}
		else {
			largest = i;
		}
		if (r <= heap_size && arr[r] > arr[largest]) {
			largest = r;
		}
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			max_heapify(arr, largest, heap_size);
		}
	}
	static String build_max_heap (int[] arr){
		String max_heap = "";
		int heap_size = arr.length-1;
		for (int i = arr.length / 2; i >= 0; i--) {
			max_heapify(arr, i, heap_size);
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (j == Math.pow(2, count) - 1) {
					count = count + 1;
					max_heap = max_heap + "\n";
				}
				max_heap = max_heap + arr[j] + " ";
			}
			max_heap = max_heap + "\n";	
		}
		max_heap = max_heap + "Max heap built. Now sorting.\n";
		return max_heap;
	}
	static String heapsort(int[] arr) {
		long sTime = System.nanoTime();
		String result = build_max_heap(arr);
		int heap_size = arr.length-1;
		for (int i = arr.length-1; i > 0; i--) {	
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heap_size = heap_size - 1;
			max_heapify(arr, 0, heap_size);
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (j == Math.pow(2, count) -1) {
					count = count + 1;
					result = result + "\n";
				}
				result = result + arr[j] + " ";
			}
			result = result + "\n";
		}
		result = result + "Sorted array:\n";
		for (int i = 0; i < arr.length; i++) {
			result = result + arr[i] + " ";
		}
		long eTime = System.nanoTime();
		long tTime = eTime - sTime;
		result = result + "\nTotal time: " + tTime + " ns";
		return result;
	}
	public static void main(String[] args) {
		int[] heap2 = {3, 5, 2, 6, 1, 4};
		int[] heap3 = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		//System.out.println(heapsort(heap3));
		//for (int i = 0; i < heap2.length; i++) {
		//	System.out.print(heap2[i] + " ");
		//}
	}
 }
