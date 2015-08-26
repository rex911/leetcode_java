/**
 * 
 */
package leetcode;

/**
 * https://leetcode.com/problems/search-for-a-range/
 * 
 * @author rexliu
 *
 */
public class SearchForARange {
	
	/**
	 * The O(log n) solution is achieved by two modified version of BST, aims at finding the leftmost and the right most 
	 * target respectively
	 * 
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0|| nums == null) return new int[] {-1, -1};
        return new int [] {locateLeft(nums, target, 0, nums.length-1), locateRight(nums, target, 0, nums.length-1)};
    }

	private int locateLeft(int[] sorted, int n, int lo, int hi){

		int mid = (lo + hi) /2;
		// this is important to avoid stack over flow
		if (lo >= hi && sorted[mid] != n) return -1;
		if (sorted[mid] == n) {
			if (mid == 0)
				return mid;
			if (sorted[mid-1] < n)
				return mid;
			// haven't find the leftmost target yet; proceed onto the left part
			else return locateLeft(sorted, n, lo, mid-1);
		}	
		else if (n > sorted[mid]) {return locateLeft(sorted, n, mid+1, hi);}
		else {return locateLeft(sorted, n, lo, mid-1);}
	}
	
	private int locateRight(int[] sorted, int n, int lo, int hi){

		int mid = (lo + hi) /2;
		// this is important to avoid stack over flow
		if (lo >= hi && sorted[mid] != n) return -1;
		if (sorted[mid] == n) {
			if (mid == sorted.length-1)
				return mid;
			if (sorted[mid+1] > n)
				return mid;
			else return locateRight(sorted, n, mid+1, hi);
		}	
		else if (n > sorted[mid]) {return locateRight(sorted, n, mid+1, hi);}
		else {return locateRight(sorted, n, lo, mid-1);}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {};
		// TODO Auto-generated method stub
		for (int i: new SearchForARange().searchRange(nums, 4)){
		System.out.println(i);
		}
	}

}
