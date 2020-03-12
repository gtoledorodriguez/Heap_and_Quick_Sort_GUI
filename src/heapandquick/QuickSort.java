package heapandquick;
import java.util.Random;

//import java.util.Date;

public class QuickSort {
	int [] values;
	int splitVal;
	int splitValL;
	String sorting;
	public QuickSort(int[] array) {
		values = array;
		sorting = "Unsorted List: \n";
	}
	public void sort() {
		//System.out.println("Sort");
		int first = 0;
		int last = values.length-1;
		//System.out.println("First: " + first + "\nLast: "+ last);
		quickSort(first,last);
	}
	
	public void quickSort(int first, int last) {
		//System.out.println("QuickSort");
		if(first < last) {
			for(int i=0;i<values.length;i++) { //Adds every step the algorithm is going on to a string to print in the 
				sorting = sorting + "  "+values[i];
				//System.out.print("  "+values[i]);
			}
			sorting = sorting +"\n";
			
			int splitPoint = split(first, last);
			//System.out.println("SplitPoint: " + splitPoint);
			
			quickSort(first, splitPoint-1);
			quickSort(splitPoint+1,last);
		}
	}
	
	public int split(int first, int last) {
		int index = first-1;
		int splitVal = values[last];
		for(int i = first; i<last;i++) {
			if(values[i]<splitVal) { //Checks moves the value so it is less than the split value
				index++;
				swap(index,i);
			}
		}
		swap(index+1,last);
		return index+1;
	}
	
	public void swap(int first, int second) {
		//System.out.println("Swap");
		int temp = values[first];
		values[first] = values[second];
		values[second] = temp;
	}

	public int[] getValues() {
		//System.out.println("getValues");
		return values;
	}
	
	public String toString() {
		sorting = sorting + "Sorted List: \n";
		for(int i=0;i<values.length;i++) {
			sorting = sorting + "  "+values[i];
			//System.out.print("  "+values[i]);
		}
		sorting = sorting +"\n";
		return sorting;
		
	}
	public static void main(String[] args) {
		Random rand = new Random();
		int SIZE = 100;
		int [] ex = new int[SIZE];
		for(int i = 0; i<100; i++) {
			ex[i] = rand.nextInt(SIZE);
		}
		QuickSort qs = new QuickSort(ex);
		
		
		long sTime = System.nanoTime();
		qs.sort();
		long eTime = System.nanoTime();
		int[] exa = qs.getValues();
		
		
		System.out.println("\n"+qs.toString());
		/**/
	}
}
