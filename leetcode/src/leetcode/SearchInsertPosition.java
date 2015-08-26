/**
 * 
 */
package leetcode;

/**
 * 
 * https://leetcode.com/problems/search-insert-position/
 * 
 * 
 * @author rexliu
 *
 */
public class SearchInsertPosition {
	
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length==0) return 0; 
        return locate(nums, target, 0, nums.length-1);
    }

private int locate(int[] sorted, int n, int lo, int hi){
		
		int mid = (lo + hi) /2;
		// this is important to avoid stack over flow
		if (lo >= hi && sorted[mid] != n) {
			if (sorted[mid] < n) return mid+1;
			else return mid;

		}
		if (sorted[mid] == n) {return mid;}	
		else if (n > sorted[mid]) {return locate(sorted, n, mid+1, hi);}
		else {return locate(sorted, n, lo, mid-1);}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {};
		System.out.println(new SearchInsertPosition().searchInsert(nums, 6) );
	}

}
