/**
 * 
 */
package leetcode;

/**
 * @author rexliu
 *
 */
public class MaximumProductSubarray {
	
	public int maxProduct(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
        int numNeg = 0, lastNeg=-1, firstNeg=nums.length;
        for (int i = 0;i<nums.length;i++){
        	if (nums[i] <0) {
        		if (i < firstNeg) firstNeg = i;
        		if (i > lastNeg) lastNeg = i;
        		numNeg++;
        	}
        }
        if (numNeg % 2 == 0) return product(nums, 0, nums.length-1);
        else return Math.max(Math.max(product(nums,0,firstNeg-1), product(nums,firstNeg+1, nums.length-1)),
        		Math.max(product(nums,0,lastNeg-1), product(nums,lastNeg+1, nums.length-1)));
    }
	
	private int product(int[] a, int lo, int hi){
		int retVal = 1;
		for (int i=lo;i<=hi;i++){
			retVal *= a[i];
		}
		return retVal;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,3,-2,4,6,1,-2};
		System.out.println(new MaximumProductSubarray().maxProduct(a));
	}

}
