/**
 * 
 */
package leetcode;

/**
 * https://leetcode.com/problems/palindrome-number/
 * 
 * @author rex
 *
 */
public class PalindromeNumber {
	
    public boolean isPalindrome(int x) {
    	// the problem defines negative int to be non palindrome
        return x >= 0 && x == new ReverseInteger().reverse(x);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new PalindromeNumber().isPalindrome(2147447412));

	}

}
