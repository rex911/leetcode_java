/**
 * 
 */
package leetcode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 * 
 * This is a Catalan number. (See https://en.wikipedia.org/wiki/Catalan_number)
 * 
 * @author rexliu
 *
 */
public class UniqueBinarySearchTrees {
	
	public int numTrees(int n) {
		ArrayList<Integer> dp = new ArrayList<Integer>();
		dp.add(1);
		dp.add(1);
		for (int i=2;i<=n;i++){
			int sum = 0;
			for (int j=1;j<=i;j++){
				sum += dp.get(i-j) * dp.get(j-1);
			}
			dp.add(sum);
		}
		return dp.get(n);

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new UniqueBinarySearchTrees().numTrees(19));
	}

}
