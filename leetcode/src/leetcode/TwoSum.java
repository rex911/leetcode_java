/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum/
 * 
 * this is a O(n*log(n)) solution; can achieve O(n) with hashmap
 * can also use the "in" feature in python, but it's basically cheating...
 * 
 * @author rex
 *
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] ret = {-1, -1};
		// sort the array for log(n) binary search
		int[] sorted = new int[nums.length];
		for (int i=0;i<nums.length;i++) {sorted[i] = nums[i];}
		Arrays.sort(sorted);
		for (int i=0;i<nums.length;i++) {
			if (contains(sorted, target - nums[i], 0, nums.length-1)) {
				ret[0] = i+1;
				// locate from the next position, avoid locating itself
				ret[1] = locate(nums, target - nums[i], i+1)+1;
				if (ret[0] >0 && ret[1] >0) break;
			}
		}
		return ret;
	}
	/**
	 * helper method to locate an element in the original input array
	 * 
	 * @param nums
	 * @param n
	 * @param start
	 * @return
	 */
	private int locate(int[] nums, int n, int start){
		for (int i=start;i<nums.length;i++){
			if (n == nums[i]) {return i;}
		}
		return -1;

	}

	/**
	 * binary search an element
	 * 
	 * @param sorted
	 * @param n
	 * @param lo
	 * @param hi
	 * @return
	 */
	private boolean contains(int[] sorted, int n, int lo, int hi){
		
		int mid = (lo + hi) /2;
		// this is important to avoid stack over flow
		if (lo >= hi && sorted[mid] != n) return false;
		if (sorted[mid] == n) {return true;}	
		else if (n > sorted[mid]) {return contains(sorted, n, mid+1, hi);}
		else {return contains(sorted, n, lo, mid-1);}
	}
	
	/**
	 * tests
	 * @param args
	 */
	public static void main(String[] args){
		int[] nums = {3,2,4};
		int target = 6;
		System.out.println(new TwoSum().twoSum(nums, target)[0]);
	}

}
