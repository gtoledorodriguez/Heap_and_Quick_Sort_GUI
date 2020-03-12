package heapandquick;

import java.util.ArrayList;
import java.util.Random;

public class Session implements Values{
		// message is the message that will be displayed to the user
		private String message;
		// numbers is the unsorted random array to be displayed to the user
		private String numbers;
		
		/**
		 * constructor
		 */
		public Session() {
			message = "Welcome! Click Heap and Quick to sort the above numbers.";
			numbers = "";
		}
		/**
		 * getMessage() gets the message
		 * @return message to the user
		 */
		public String getMessage() {
			return message;
		}
		/**
		 * getNumbers() gets the array of values
		 * @return the array of values
		 */
		public int[] getNumbers() {
			return values;
		}
		/**
		 * getNumbersString() converts the random unsorted number array to a string
		 * @return numbers, random unsorted array
		 */
		public String getNumbersString() {
			// resetting the welcome message
			message = "Welcome! Click Heap and Quick to sort the above numbers.";
			// resetting the numbers array
			numbers = "";
			// Calling the random numbers method
			// Adding each number in the values array to the string
			for (int i = 0; i < SIZE; i++) {
				numbers += String.valueOf(values[i]);
			}
			// Return the string
			return numbers;
		}
		/**
		 * randomNumbers() calculates an array of random unsorted numbers and puts it in values
		 * @return values, an array of randomly sorted numbers
		 */
		public int[] randomNumbers() {
			// New random
			Random rand = new Random();
			// Calculating and populating values, a global variable according to SIZE, which is a global variable
		    for(int i = 0; i < SIZE; i++){
		    	values[i] = rand.nextInt(SIZE);
		    }
		    // Returning values
		    return values;
		}
}
