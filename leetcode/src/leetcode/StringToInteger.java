/**
 * 
 */
package leetcode;

/**
 * @author rexliu
 *
 */
public class StringToInteger {
	
public int myAtoi(String str) {
        if (str.equals("") || str == null) return 0;
        int retVal = 0, positive = 1;
        str = str.trim();
        // use while clause if multiple plus/minus signs are possible
        // use if clause if at most one plus/minus sign and additional signs are deemed illegal
        // apparently this problem adopts the second case
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
        	if (str.charAt(0) == '-') positive = -positive;
        	str = str.substring(1);
        }
        for (int i=0;i<str.length();i++){
        	if ((str.charAt(i)-'0' < 0 || str.charAt(i)-'0' > 9) && i == 0) return 0;
        	if (str.charAt(i)-'0' < 0 || str.charAt(i)-'0' > 9)  break;
        	// check if out of boundary
        	if (retVal + (str.charAt(i)-'0') / 10. > Integer.MAX_VALUE/10.) return Integer.MAX_VALUE * positive + (positive - 1) /2;
        	retVal = retVal*10 + str.charAt(i)-'0';
        }
        return retVal * positive;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "";
		System.out.println(new StringToInteger().myAtoi(s));
	}

}
