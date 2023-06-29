  //import java.lang.Math;

class MtBT implements IBinTree {
	MtBT() {
	}

	// returns false since empty tree has no elements
	public boolean hasElt(int e) {
		return false;
	}

	// returns 0 since empty tree has no elements
	public int size() {
		return 0;
	}

	// returns 0 since tree has no branches
	public int height() {
		return 0;
	}

	

	/**
	 * Checks if the structure of a binary tree that of a heap.
	 * 
	 * @return true since an empty binary tree is considered to be a heap
	 */
	@Override
	public boolean isHeap() {
		return true;
	}

	@Override
	public boolean isSmallest(int data) {
		// TODO Auto-generated method stub
		return true;
	}
}
