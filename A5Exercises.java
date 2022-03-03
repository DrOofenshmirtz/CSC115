public class A5Exercises {

	// PART 1

	/*
	 * Purpose: get a count of the number of elements in the array
	 *          with a value that is a multiple of x
	 * Parameters: int[] arr
	 * Returns: int - the number multiples of x
	 * Pre-condition: x > 0
	 * Post-condition - the array contents are unchanged
	 */
	public static int countMultiples(int[] arr, int x) {
		
		if(arr.length == 0){
			return 0;
		}
		int index = 0;
		int count = 0;
		return countMultiplesRec(arr, x, index, count);
		 
	}

	private static int countMultiplesRec(int arr[], int x, int i, int count){
		if(i > arr.length-1){
			return count;
		}
		if(arr[i]%x == 0){
			count++;
		}
		return countMultiplesRec(arr, x, i+1, count);

	}
		
	/*
	 * Purpose: double all values in the given array
	 * Parameters: int[] array - the array to modify
	 * Returns: void - nothing
	 */
	public static void doubleAll(int[] array) {
		if(array.length == 0){
			return;
		}
		int index = 0;
		doubleAllRec(array, index);
	}
	
	private static void doubleAllRec(int[]arr, int i){
		if(i > arr.length-1){
			return;
		}else{
			arr[i] = arr[i] * 2;
			doubleAllRec(arr, i + 1);
		}
		return;
	}
	/*
	 * Purpose: get the minimum value found in the array
	 * Parameters: int[] array - the array to search
	 * Returns: int - minimum value found in the array
	 *                or -1 if the array is empty
	 * Post-condition - the array contents are unchanged
	 */
	public static int getMinimum(int[] array) {
		if(array.length == 0){
			return -1;
		}
		int min = array[0];
		int index = 0;
		return getMinimumRec(array, index, min); // so it compiles
	}
	
	private static int getMinimumRec(int[] arr, int i, int min){
		if(i > arr.length -1){
			return min;
		}
		if(arr[i] <= min){
			min = arr[i];
		}
		getMinimumRec(arr, i + 1, min);
		return min;
	}



	// PART II

	/*
	 * Purpose: get the total number of books in s
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: int - the total number of books
	 * Post-condition: s is not modified
	 */
	public static int totalBooks(Stack<Book> s) {
		return -1; // so it compiles
	}

	/*
	 * Purpose: get the total number of pages of all 
	 *          books in the stack
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: int - the total number of pages
	 * Post-condition: s is not modified
	 */
	public static int totalPages(Stack<Book> s) {
		return -1; // so it compiles
	}
	
	/*
	 * Purpose: get the average number of pages of books in s
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: double - the average number of pages
	 *                   0.0 if there are no books in s
	 * Post-condition: s is not modified
	 */
	public static double averagePages(Stack<Book> s) {
		// You don't need to change this, if you have
		// completed the previous two exercises
		// correctly, it should pass all the tests
		if (s.isEmpty()) {
			return 0.0;
		} else {
			double sum = totalPages(s);
			int count = totalBooks(s);
			return sum/count;
		}
	}

	/*
	 * Purpose: determine whether toFind is contained in s
	 * Parameters: Stack<Book> s - the stack of books
	 *             Book toFind - the book to search for
	 * Returns: boolean - true if s contains toFind, false otherwise
	 * Post-condition: s is not modified
	 */
	public static boolean containsBook(Stack<Book> s, Book toFind) {
		return false; // so it compiles
	}

	/*
	 * Purpose: determine the books in s are stacked correctly
	 *          (ie. there is never a book stacked on top of 
	 *               another book with fewer pages)
	 * Parameters: Stack<Book> s - the stack of books
	 * Returns: boolean - true if books in s are stacked correctly
	 * Post-condition: s is not modified
	 */
	public static boolean stackedCorrectly(Stack<Book> s) {
		return false; // so it compiles
	}
}