/**
 * 
 */
package leetcode;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * 
 * @author rexliu
 *
 */
public class MaximumProductSubarray {
	
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int retVal = nums[0], max = retVal, min = retVal;
		for (int i=1; i < nums.length; i++){
			// choose between continuing multiplying and starting new
			if (nums[i] >= 0){
				max = Math.max(nums[i], nums[i]*max);
				min = Math.min(nums[i], nums[i]*min);
			} else {
				int tmp = max;
				max = Math.max(nums[i], nums[i]*min);
				min = Math.min(nums[i], nums[i]*tmp);
			}
			retVal = Math.max(retVal, max);
		}
		return retVal;

    }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,3,0,4};
		System.out.println(new MaximumProductSubarray().maxProduct(a));
	}

}
