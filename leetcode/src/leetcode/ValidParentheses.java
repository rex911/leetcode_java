/**
 * 
 */
package leetcode;

/**
 * 
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * @author RLiu
 *
 */
public class ValidParentheses {
	public boolean isValid(String s) {
        while (s.length() > 0) {
        	int oldLen = s.length();
        	s = s.replaceAll("\\(\\)|\\{\\}|\\[\\]", "");
        	if (s.length() == oldLen) return false;
        }
        return true;
    }
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new ValidParentheses().isValid("([)]"));

	}

}
