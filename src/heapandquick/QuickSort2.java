package heapandquick;

import java.util.Date;

public class QuickSort2 {
	int [] values;
	int splitVal;
	int splitValL;
	public QuickSort2(int[] array) {
		values = array;
	}
	public void sort() {
		//System.out.println("Sort");
		int first = 0;
		int last = values.length;
		//System.out.println("First: " + first + "\nLast: "+ last);
		quickSort(first,last);
	}
	
	public void quickSort(int first, int last) {
		//System.out.println("QuickSort");
		if(first < last) {
			for(int i=0;i<values.length;i++) {
				System.out.print("  "+values[i]);
			}
			System.out.println();
			splitVal = values[first];
			splitValL = values[last-1];
			System.out.println("SplitVal: " + splitVal);
			System.out.println("SplitValL: " + splitValL);
			
			int splitPoint;
			splitPoint = split(first, last);
			//System.out.println("SplitPoint: " + splitPoint);
			
			quickSort(first, splitPoint-1);
			quickSort(splitPoint+1,last);
		}
	}
	
	public int split(int first, int last) {
		int index = 0;
		for(int i = 0; i<values.length;i++) {
			/*System.out.println("\nValue["+i+"]: " + values[i]);
			System.out.println("SplitVal: " + splitVal);
			System.out.println("Value["+i+"] < splitVal: " + (values[i]<splitVal) );
			*/
			if(values[i]<splitVal) {
				swap(i,index);
				index++;
			}else if(values[i]>splitValL) {
				swap(i,index);
			}
		}
		return index;
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
	public static void main(String[] args) {
		int [] ex = {9,20,6,10,14,8,60,11};
		QuickSort2 qs = new QuickSort2(ex);
		Date d = new Date();
		/*
		System.out.println("\nBefore\nLength: "+ex.length);
		*/
		System.out.println("Unsorted List");
		/*for(int i=0;i<ex.length;i++) {
			System.out.print("  "+ex[i]);
		}*/
		
		long sTime = System.nanoTime();
		qs.sort();
		long eTime = System.nanoTime();
		int[] exa = qs.getValues();
		
		//System.out.println("\nAfter\nLength: "+exa.length);
		System.out.println("\nSorted List");
		for(int i=0;i<exa.length;i++) {
			System.out.print("  "+exa[i]);
		}
		System.out.println("\n\nStart Time: "+ sTime + "\nEnd Time: "+ eTime +"\nTotal time: " + (eTime-sTime));
		
		
	}
}
