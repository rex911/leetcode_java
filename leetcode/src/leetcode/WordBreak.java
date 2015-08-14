/**
 * 
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/word-break/
 * 
 * @author rexliu
 *
 */
public class WordBreak {

	public boolean wordBreak(String s, Set<String> wordDict) {
		//corner cases:
		if (s == "") return true;
		if (s == null) return false;
		if (wordDict.size()==0) return false;
		
		// NOTE: dp[i+1] is true if the s.substring(0,i+1) can be broken with the dictionary
		// this should be bottom-up to avoid duplicate dub problems
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for (int  i = 0; i < s.length();i++){
			for (String w: wordDict){
				if (i - w.length()+1 >= 0)
					// transition: dp[i] = dp[i-w.length()] if true
					// NOTE, dp[i-w.length()] must be true to avoid overwriting true with false
					if (s.substring(i - w.length()+1, i+1).equals(w) && dp[i-w.length()+1]) {
						dp[i+1] = true;
					}
			}
		}
		return dp[s.length()];

	}
	



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "dogs";
		Set<String> wd = new HashSet<String>();
		wd.add("dog");
		wd.add("gs");
		wd.add("s");
		/*wd.add("aaaa");
		wd.add("aaaaa");
		wd.add("aaaaaa");
		wd.add("aaaaaaa");
		wd.add("aaaaaaaa");
		wd.add("aaaaaaaaa");
		wd.add("aaaaaaaaaa");*/
		
		long startTime = System.currentTimeMillis();
		System.out.println(new WordBreak().wordBreak(s, wd));
		long endTime = System.currentTimeMillis();
		System.out.println("Took "+(endTime - startTime) + " ms"); 

	}

}
