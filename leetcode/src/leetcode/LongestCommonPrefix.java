/**
 * 
 */
package leetcode;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * catch: it wants "" when input has length 0
 * 
 * @author rexliu
 *
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {

		if (strs == null ) return null;
		if (strs.length == 0) return "";
		int i = 0;
		// StringBuffer is actually unnecessary; simply return strs[0].subString(0,i)
		StringBuffer sb = new StringBuffer();
		boolean cool = true;
		
		// terminate when some strings hit boundary
		// or when common prefix ends
		try {
			while (true) {
				
				for (String s: strs){
					if (s.charAt(i) != strs[0].charAt(i)) {
						cool = false;
						break;
					}
				}
				if (cool) {
					sb.append(strs[0].charAt(i));
					i++;
				} else break;
			}
		} catch (StringIndexOutOfBoundsException e) {
			return sb.toString();
		}
		
		
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {};
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));

	}

}
