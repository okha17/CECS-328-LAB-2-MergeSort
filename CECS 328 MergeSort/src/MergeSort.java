// ============================================================================
// CECS 328 Lab Assignment 2
// ============================================================================
// Team Members:
// Kevin Vu
// Osman Khan
// Anthony Dawson
// ============================================================================

// ==== MergeSort =============================================================
// MergeSort class that contains the main, mergeSort, and Merge functions. The 
// program will use MergeSort algorithm using recursion to sort the given array 
// of integers. Once sorted, it will display the unsorted array, sorted array 
// and number of comparison
// ============================================================================
class MergeSort {
	
	static int comparisons = 0; //Integer variable that will store the total number of comparisons from MergeSort
	
	public static void main(String []args)
	{
		int sorted[] = new int[args.length]; // Array that will store the sorted integers
		int unsorted[] = new int[args.length]; // Array that will store the unsorted integers
		
		for(int index = 0; index < args.length; ++index) //for loop that initializes the unsorted and sorted arrays
		{
			sorted[index] = Integer.parseInt(args[index]);
			unsorted[index] = Integer.parseInt(args[index]);
		}
		System.out.println("Unsorted Array"); // displays the unsorted array
		for(int index = 0; index < args.length; ++index) //for loop that loops until it reaches the length of the string
		{
			System.out.print(unsorted[index] + " "); //displays each index of the unsorted array
		}
		mergeSort(sorted, 0, (args.length - 1)); // calls the mergeSort function and sends in the array, index of 0, and length of the string
		System.out.println("\n\nSorted Array"); // displays the sorted array
		for(int index2 = 0; index2 < args.length; ++index2) // for loop that loops until it reaches the length of the string
		{
			System.out.print(sorted[index2] + " "); // displays the sorted array
		}
		System.out.println("\n\nNumber of comparisons: " + comparisons ); // displays the number of comparisons
	}
	
	//==== mergeSort ==================================================================
	// mergeSort that uses recursion to sort the array of integers
	//=================================================================================
	static void mergeSort(int []array, int left, int right)
	{
		if (left<right)
		{ 
			int midpoint = (left+right)/2; //midpoint
			mergeSort(array, left, midpoint); // recursively calls the mergeSort function sending in the array of integers, first index, and the midpoint
			mergeSort(array, midpoint + 1, right); // recursively calls the mergeSort function sending in the array, midpoint + 1, and the end index of the array
			Merge(array, left, midpoint, right);	// calls the Merge function sending in array, first index, midpoint, and the end index of the array
		}
	}
	
	//==== Merge ======================================================================
	// merge function that will split the array into two arrays then will sort them
	//=================================================================================
	static void Merge(int array[], int left, int mid, int right) 
	{ 
		int sizeOfArrayOne = mid - left + 1; //Size of first array
	    int sizeOfArrayTwo = right - mid; //Size of second array
	    int L[] = new int [sizeOfArrayOne]; //Temporary first array
	    int R[] = new int [sizeOfArrayTwo]; //Temporary second array
	  
	    for (int i=0; i<sizeOfArrayOne; ++i) //For loop that will store the integers in the first array
	    {
	    	L[i] = array[left + i];  
	    }
	    for (int j=0; j<sizeOfArrayTwo; ++j) //For loop that will store the integers in the second array
	    {
	    	R[j] = array[mid + 1+ j]; 
	    }
	  
	    int i = 0; //Integer variable that will store the index. It is initialized to 0 
	    int j = 0; //Integer variable that will store the index. It is initialized to 0
	    int k = left; //Integer variable that will store the index. It is initialized to left
	    
	    for (;(i < sizeOfArrayOne && j < sizeOfArrayTwo);) //If index i is less than the size of array one and index j is less than the size of array two then it will loop
	    { 
	    	++comparisons; //increments comparisons
	    	if (L[i] <= R[j]) //if the index i of the left array is less than or equal to the index j of the right array it will enter this if statement
	        { 
	    		array[k] = L[i]; //Initialize array index of k to the left array of index i
	            i++; //increments index i
	        } 
	        else
	        { 
	        	array[k] = R[j]; //Initialize array index of k to the right array of index j
	            j++; //increments index j
	        } 
	            k++; //increments index k
	    } 
	  
	    //Copy the remaining elements 
	    while (i < sizeOfArrayOne) 
	    { 
	    	array[k] = L[i]; //array of index k is initialized to left array of index i
	        i++; //increments index i 
	        k++; //increments index k
	    } 
	  
	    //Copy the remaining elements
	    while (j < sizeOfArrayTwo)
	    { 
	        array[k] = R[j]; //array of index k is initialized to the right array of index j
	        j++; //increments index j
	        k++; //increments index k
	    }  
	 } 
}

