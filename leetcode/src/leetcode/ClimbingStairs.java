/**
 * 
 */
package leetcode;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * 
 * @author rexliu
 *
 */
public class ClimbingStairs {
	

	public int climbStairs(int n) {
		if (n==0) return 0;
		if (n==1) return 1;
		int[] dp = new int[n];
		// NOTE: dp[i] denotes the number of ways of climbing for i+1 stairs
		dp[0] = 1; dp[1] = 2;
		for (int i=2; i<n;i++){
			// transition
			dp[i] = dp[i-2]+dp[i-1];
		}
		return dp[n-1];

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(new ClimbingStairs().climbStairs(2));
	}

}
