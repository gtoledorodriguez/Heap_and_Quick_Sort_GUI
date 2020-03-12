package heapandquick;
import java.util.*;
public class HeapSort {
	/**
	 * left() returns the index of the left child of the given index
	 * @param i is the given index
	 * @return the index of the left child of the given index
	 */
	static int left(int i) {
		// The left child is that of index 2 * i + 1
		return 2 * i + 1;
	}
	/**
	 * right() returns the index of the right child of the given index
	 * @param i is the given index
	 * @return the index of the right child of the given index
	 */
	static int right(int i) {
		// The right child is that of index 2 * i + 2
		return 2 * i + 2;
	}
	/**
	 * max_heapify() maintains the max heap property of a given heap
	 * @param arr is the integer array of the heap
	 * @param i is index to compare
	 * @param heap_size is the size of the heap
	 */
	static void max_heapify (int[] arr, int i, int heap_size) {
		// largest is the index of the largest value
		int largest;
		// l is the index of the left child of the index i
		int l = left(i);
		// r is the index of the right child of the index i
		int r = right(i);
		// if l is less than the heap size and its value is larger than that of index i
		if (l <= heap_size && arr[l] > arr[i]) {
			// the index of the largest value is set to l
			largest = l;
		}
		// else
		else {
			// the index of the largest value is set to to i
			largest = i;
		}
		// if r is less than the heap size and its value is larger than that of the current largest value
		if (r <= heap_size && arr[r] > arr[largest]) {
			// the index of the largest value is set to r
			largest = r;
		}
		// if the index of the largest value is not i
		if (largest != i) {
			// then the values of i and largest are switched
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			// and max_heapify is called again, this time on largest
			max_heapify(arr, largest, heap_size);
		}
	}
	/**
	 * build_max_heap() builds a max_heap from a given array
	 * @param arr is the integer array to make a heap
	 * @return the integer array, heapified, as a string to print in the GUI
	 */
	static String build_max_heap (int[] arr){
		// max_heap is the string to print in the GUI
		String max_heap = "";
		// heap_size is the size of the heap
		int heap_size = arr.length-1;
		for (int i = arr.length / 2; i >= 0; i--) {
			// it first calls max_heapify on each element of the given array
			max_heapify(arr, i, heap_size);
			// count helps print as a heap
			int count = 0;
			// This for loop puts the heap into an array to print in the GUI
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
	/**
	 * heapsort makes the array into a max heap, then sorts it
	 * @param arr is the array to heap sort
	 * @return the string of the sorted array to be printed in the GUI
	 */
	static String heapsort(int[] arr) {
		// sTime helps calculate the time it takes to run the program 
		long sTime = System.nanoTime();
		// first it builds a max heap of the array by calling build_max_heap()
		String result = build_max_heap(arr);
		// heap_size is the size of the heap
		int heap_size = arr.length-1;
		for (int i = arr.length-1; i > 0; i--) {	
			// it first switches the value of the current element with the value of the first element
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			// the heap_size is decreased
			heap_size = heap_size - 1;
			// max_heapify is called on the first element
			max_heapify(arr, 0, heap_size);
			// count helps print as a heap
			int count = 0;
			// This makes the string to print in the GUI
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
		// the time is calculated then and added to the print string
		long eTime = System.nanoTime();
		long tTime = eTime - sTime;
		result = result + "\nTotal time: " + tTime + " ns";
		return result;
	}
 }
