/**
 * 
 */
package leetcode;

/**
 * https://leetcode.com/problems/house-robber/
 * 
 * @author rexliu
 *
 */
public class HouseRobber {

	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		int [] dp = new int[nums.length];
		System.arraycopy(nums, 0, dp, 0, nums.length);
		if (dp[1] < dp[0]) dp[1] = dp[0];
		for (int i = 2; i< nums.length; i++){
			// dp transition
			dp[i] = Math.max(dp[i-2]+ nums[i], dp[i-1]);
		}
		return dp[dp.length-1];

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
