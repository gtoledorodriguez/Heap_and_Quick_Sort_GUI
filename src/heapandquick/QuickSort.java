package heapandquick;

public class QuickSort {
	int [] values;
	int splitVal;
	public QuickSort(int[] array) {
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
			splitVal = values[first];
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
			*/if(values[i]<splitVal) {
				swap(i,index);
				index++;
				
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
		QuickSort qs = new QuickSort(ex);
		/*
		System.out.println("\nBefore\nLength: "+ex.length);
		*/
		System.out.println("Unsorted List");
		for(int i=0;i<ex.length;i++) {
			System.out.print("  "+ex[i]);
		}
		
		qs.sort();
		int[] exa = qs.getValues();
		
		//System.out.println("\nAfter\nLength: "+exa.length);
		System.out.println("\nSorted List");
		for(int i=0;i<exa.length;i++) {
			System.out.print("  "+exa[i]);
		}
		
	}
}
