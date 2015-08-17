/**
 * 
 */
package leetcode;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
/**
 * @author rexliu
 *
 */
public class Triangle {
	
	public int minimumTotal(List<ArrayList<Integer>> t) {
		List<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(t.get(0).get(0));
		dp.add(list);
		for (int i=1;i<t.size();i++){
			list = new ArrayList<Integer>();
			for (int j=0;j<t.get(i).size();j++){
				if (j==0) list.add(dp.get(i-1).get(j) + t.get(i).get(j));
				else if (j==t.get(i).size()-1) list.add(dp.get(i-1).get(j-1) + t.get(i).get(j));
				else list.add(Math.min(dp.get(i-1).get(j), dp.get(i-1).get(j-1)) +  t.get(i).get(j));
				
			}
			dp.add(list);
		}
		
		return Collections.min(dp.get(t.size()-1));
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(-10);
		t.add(list);
		System.out.println(new Triangle().minimumTotal(t));
		
	}

}
