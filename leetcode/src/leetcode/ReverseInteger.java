/**
 * 
 */
package leetcode;

/**
 * https://leetcode.com/problems/reverse-integer/
 * 
 * @author rex
 *
 */
public class ReverseInteger {
	
    public int reverse(int x) {
    	if (x == 0) return x;
        StringBuilder sb = new StringBuilder();
        if (x<0) {
        	sb.append('-');
        	x = -x;
        }
        // use modulus to reverse the integer
        while (x>0) {
        	sb.append(x % 10);
        	x /= 10;
        }
        // return 0 if output overflows
        try {
        return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
        	return 0;
        }
    }

	/**
	 * 1534236469 is a case where input does not overflow, but output does
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse(1534236469));
	}

}
