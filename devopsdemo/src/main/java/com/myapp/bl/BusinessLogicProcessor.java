package com.myapp.bl;

import java.util.Arrays;

public class BusinessLogicProcessor {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isEven(int num) {
		// TODO Auto-generated method stub
		if (num % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	
	public int[] generatePrimeNums(int numOfDigits) {
		
		int primeArr[] = new int[numOfDigits];
		int arrIncrementor = 2;

		if (numOfDigits == 1) {
			primeArr[0] = 1;
			return primeArr;
		} else if (numOfDigits == 2) {
			primeArr[0] = 1;
			primeArr[1] = 2;
			return primeArr;
		} else {
			primeArr[0] = 1;
			primeArr[1] = 2;
		}

		boolean isPrime;
		for (int counter = 3; arrIncrementor < numOfDigits; counter++) {
			isPrime = false;
			isPrime = isNumberPrime(counter);
			if (isPrime) {
				primeArr[arrIncrementor] = counter;
				arrIncrementor++;
			}
		}
		return primeArr;
	}
	
	public String generatePrimeNums(String str) {
		String primeNumStr = null;
		if (stringIsAValidPositiveNumber(str)) {
			
			int numOfPrimeDigits = Integer.parseInt(str);
			primeNumStr = Arrays.toString(generatePrimeNums(numOfPrimeDigits));
		} else {
			primeNumStr = "Enter a valid number";
		}
		return primeNumStr;
	}
	
	
	private boolean stringIsAValidPositiveNumber(String str) {
		boolean isValid = false;
		try {
			int num = Integer.parseInt(str);
			if (num > 0 && (num % 1 == 0)) {
				isValid = true;
				return isValid;
			}
		} catch (NumberFormatException ex) {
			isValid = false;
			return isValid;
		}
		return isValid;
		
	}
	private boolean isNumberPrime(int i) {
		boolean isPrime = true;
		for (int counter = 2; counter < i; counter++) {
			if (i % counter == 0) {
				isPrime = false; // this is the CORRECT logic uncomment this to pass the test case
				//isPrime = true; // this is the WRONG logic uncomment this to fail the test case
				return isPrime;
			}
		}
		return isPrime;
	}

	public long[] generateFibSeries(int len) {
		// This is my second commit for BLP class only.
		long arr[] = new long[len];
		arr[0] = 0;
		arr[1] = 1;

		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2]; // this line is the correct logic
			//arr[i] = arr[i - 1] + arr[i - 1]; // this line is the wrong logic if this is included unit test will fail
		}
		return arr;
	}

	public String generateFibSeries(String str) {
		
		String strOfFibSeries = null;
		if(stringIsAValidPositiveNumber(str)) {
			int inumOfFibSeries = Integer.parseInt(str);
			strOfFibSeries = Arrays.toString(generateFibSeries(inumOfFibSeries));
		} else {
			strOfFibSeries = "Enter a valid number"; // this is good logic
			//strOfFibSeries = "Enter"; // - this is bad logic
		}
		return strOfFibSeries;
	}
	
	/**
	 * @param arr
	 *            - This takes in an Integer Arr
	 * @return - Returns the array which is sorted in Ascending order
	 */
	public int[] sortArrayInAscnOrder(int[] arr) {
		// System.out.println("unsorted array before sorting : " + Arrays.toString(arr));

		
		 ///////////////////////////////// ----- Selection sort algorithm starts
		  
		 // Outer loop - need n-1 iteration to sort n elements 
		 
		 for(int i=0; i<arr.length-1; i++){           /// this line is the correct logic 
		 // for(int i=1; i<arr.length-1; i++) {        /// uncomment this line to introduce a logical bug
		 
		 		//Inner loop to perform comparision and swapping between adjacent numbers 
		 		//After each iteration one index from last is sorted 
		 	for(int j= 1; j<arr.length-i; j++){
		 	//If current number is greater than swap those two 
		 		if(arr[j-1] > arr[j]){ 
		 			int temp = arr[j]; 
		 			arr[j] = arr[j-1]; 
		 			arr[j-1] = temp; 
		 		} 
		 	}
		  
		 } 
		 ///////////////////////////////////// ----- Selection sort algorithm ends
		 
		/*
		////////////////////////////////////////////// Bubble sort logic starts
		int n = arr.length;
		int k;
		for (int m = n; m >= 0; m--) {
			for (int i = 0; i < n - 1; i++) {
				k = i + 1;
				if (arr[i] > arr[k]) {
					swapNumbers(i, k, arr);
				}
			}
		}
		//////////////////////////////////////////////// Bubble sort logic ends
		*/
		// System.out.println("Sorted array >>"+ Arrays.toString(arr));
		return arr;
	}

	private void swapNumbers(int i, int j, int[] arr) {

		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


}
