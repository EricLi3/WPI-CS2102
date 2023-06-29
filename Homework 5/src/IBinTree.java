
	
interface IBinTree {
	// determines whether element is in the tree
	boolean hasElt(int e);

	// returns number of nodes in the tree; counts duplicate elements as separate
	// items
	int size();

	// returns depth of longest branch in the tree
	int height();
	
	
	//Added Helper Methods
	
	
    /**
	 * Checks if the structure of a binary tree that of a heap.
	 * 
	 * @return Boolean indicating if the structure of a binary tree matches that of
	 *         a heap.
	 */
    boolean isHeap();
    
    /**
     * Checks if the given int is the smallest value in the given data set
     * @param data
     * @return Boolean indicating if a elt is the the smallest in the given set
     */
	boolean isSmallest(int data);


}

