/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 * 
 * @author rexliu
 *
 */
public class CombinationSum {
	
	private List<List<Integer>> solution;
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<Integer> sofar = new ArrayList<Integer>();
       solution = new ArrayList<List<Integer>>();
       recursion(candidates, sofar, target);
       return solution;
        
    }
	
	
	/**
	 * Brutal recursive DFS solution
	 * 
	 * @param candidates
	 * @param sofar
	 * @param target
	 */
	private void recursion( int[] candidates, List<Integer> sofar, int target){
		if (sum(sofar) == target) {
			// sofar is mutable, must add a copy
			if (!solution.contains(sofar))
				solution.add(clone(sofar));
			return;
		}
		if (sum(sofar) > target) {
			return;
		}
		for (int i:candidates){
			if (sofar.size()==0 || i>=sofar.get(sofar.size()-1)) {
				sofar.add(i);
				recursion(candidates, sofar, target);
				sofar.remove(sofar.size()-1);
			}
		}
	}
	
	private List<Integer> clone(List<Integer> l) {
		List<Integer> ret = new ArrayList<Integer>();
		for (int i:l) ret.add(i);
		return ret;
	}

	private int sum(List<Integer> l ){
		int ret = 0;
		for (int i:l) ret+=i;
		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<List<Integer>> a = new CombinationSum().combinationSum(new int[] {2,2,2,2}, 6);
		for (List<Integer> b:a){
			for (int i: b)
				System.out.println(i);
			System.out.println("Next");
		}
	}

}
