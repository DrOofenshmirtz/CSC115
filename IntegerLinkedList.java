public class IntegerLinkedList {

	private IntegerNode	head;
	private int count;

	public IntegerLinkedList() {
		head = null;
		count = 0;
	}
	
	/*
	 * size
	 * Purpose: returns the size of this IntegerList
	 * Parameters: none
	 * Returns: int - the size
	 */
	public int size() {
		return count;
	}

	/*
	 * addFront
	 * Purpose: adds an element with given value to the front of this Integerlist
	 * Parameters: int - value
	 * Returns: nothing
	 */
	public void addFront (int value) {
		IntegerNode n = new IntegerNode(value, head);
		head = n;
		count++;
	}


	/*
	 * toString
	 * Purpose: returns a String representation of this IntegerList
	 * Parameters: none
	 * Returns: String - the String representation
	 */
	public String toString() {
		return toString(head);
	}

	private String toString(IntegerNode n) {
		if (n==null) {
			return "";
		} else {
			if(n.next != null) {
				return n.getData() + " " + toString(n.next);
			} else {
				return n.getData() + toString(n.next);
			}
		}
	}
		
	/*
	 * addOneRecursive
	 * Purpose: recursively adds 1 to every value in this IntegerList
	 * Parameters: none
	 * Returns: nothing
	 */
	public void addOneRecursive() {
		addOneRecursiveHelper(head);
	}

	/*
	 * addOneRecursiveHelper
	 * Purpose: recursively adds 1 to n and every element following n
	 * Parameters: IntegerNode - n
	 * Returns: nothing
	 */
	private void addOneRecursiveHelper(IntegerNode n) {
		if (n == null) {
			return;
		} else {
			// get data in current node and add 1 to it
			int valPlusOne = n.getData() + 1;
			
			// set data in current node to valPlusOne
			n.setData(valPlusOne);
			
			// add one to the elements in the REST of the list
			addOneRecursiveHelper(n.next);
		}
	}

	/*
	 * doubleValues
	 * Purpose: recursively doubles every element in this IntegerList
	 * Parameters: none
	 * Returns: nothing
	 */
	public void doubleValues() {
		if(head == null){
			return;
		}

		doubleValuesHelper(head, head);
		return;
		
	}

	private void doubleValuesHelper(IntegerNode prev, IntegerNode cur){
			if(cur == null){
				
				return;
			}
			int value = cur.getData() * 2;
			cur.setData(value);
			
			doubleValuesHelper(cur, cur.getNext());
			
			return;
	}


	/*
	 * doubleOddValues
	 * Purpose: recursively doubles every element with an odd data value
	 *  By "odd data value" we mean the Node's data value is an odd number
	 *  NOT that it is at an odd position in the list
	 * Parameters: none
	 * Returns: nothing
	 */
	public void doubleOddValues() {
		doubleOddValuesHelper(head, head);
		return;
		
	}

	private void doubleOddValuesHelper(IntegerNode prev, IntegerNode cur){
		if(cur == null){
			return;
		}
		if(cur.getData()%2 != 0){
			int value = cur.getData() * 2;
			cur.setData(value);
		}
		doubleOddValuesHelper(cur, cur.getNext());
		return;
	}




	/*
	 * sum
	 * Purpose: recursively sums every element in this IntegerList
	 * Parameters: none
	 * Returns: int - the sum
	 */
	public int sum() {
		return sum(head);
	}


	/*
	 * sum
	 * Purpose: recursively sums element in IntegerNode n and every element following n
	 * Parameters: IntegerNode - n
	 * Returns: int - the sum
	 */
	private int sum(IntegerNode n) {
		if (n==null) {
			return 0;
		} else {
			int first = n.getData();
			int sumRest = sum(n.next);
			
			return first + sumRest;
		}
	}

	/*
	 * product
	 * Purpose: recursively computes the product of every value in this IntegerList
	 *  Note: the product of an empty list is 1
	 * Parameters: none
	 * Returns: int - the product
	 */
	public int product() {
		int product = 1;
		return productHelper(head, head, product);
	}
	private static int productHelper(IntegerNode prev, IntegerNode cur, int product){
		if(cur == null){
			return product;
		}
		product*=cur.getData();
		return productHelper(cur, cur.getNext(), product);
	}
	/*
	 * doubleOddPositionValues
	 * Purpose: recursively doubles every value at an odd POSITION in this IntegerList
	 *          the first  element in this list is at position 0 (is not odd)
	 *          the second element in this list is at position 1 (is odd)
	 *          the third  element in this list is at position 2 (is not odd)
	 *          ...
	 * Parameters: none
	 * Returns: nothing
	 */
	public void doubleOddPositionValues() {
		doubleOddPositionValues(head, 0);
	}

	/*
	 * doubleOddPositionValues
	 * Purpose: recursively doubles the value of every element at
	 *          an odd position number in this IntegerLinkedList
	 * Parameters: IntegerNode - n, int - position
	 * Returns: nothing
	 */
	private void doubleOddPositionValues(IntegerNode n, int position) {
		if (n == null) {
			return;
		} else {
			if (position % 2 != 0) {
				int doubleVal = n.getData() * 2;
				n.setData(doubleVal);
			}
			doubleOddPositionValues(n.next, position+1);
		}
	}


	/*
	 * allNegative
	 * Purpose: recursively determines whether all node values are negative
	 * Parameters: none
	 * Returns: boolean - true if all negative, false otherwise
	 * Note: an empty list is considered to have all negative values (as there are no
	 *       non-negative values found in the list)
	 */
	public boolean allNegative() {
		if(head == null){
			return true;
		}
		return allNegativeHelper(head, head);
	}

	public boolean allNegativeHelper(IntegerNode prev, IntegerNode cur){
		if(cur == null){
			return true;
		}

		if(cur.getData() >= 0){
			return false;
		}
		return allNegativeHelper(cur, cur.getNext());
	}

	/*
	 * isSortedAscending
	 * Purpose: recursively determines whether the elements in this
	 *      IntegerList are sorted in ascending order:
	 *      {1, 2, 2, 5} is sorted in ascending order
	 *      {3, 2, 2, 5} is not sorted in ascending order
	 * Parameters: none
	 * Returns: boolean - true if sorted, false otherwise
	 * Note: an empty list is considered sorted
	 */
	public boolean isSortedAscending() {
		
		return isSortedAscendingHelper(head, head);
	} 
	
	private boolean isSortedAscendingHelper(IntegerNode prev, IntegerNode cur){
		if(cur == null){
			return true;
		}
		if(cur.getData()< prev.getData()){
			return false;
		}
		return isSortedAscendingHelper(cur, cur.getNext());
	}
	
}

