/**
 * 
 */
package leetcode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * @author rexliu
 *
 */
public class SearchInRotatedSortedArray {
	
	/**
	 * find the pivot then BS on both side
	 * 
	 * @param a
	 * @param target
	 * @return
	 */
	public int search(int[] a, int target) {
		if (a==null || a.length == 0) return -1;
        int i;
        for ( i =0; i<a.length -1; i++){
        	if (a[i] > a[i+1]) break;
        }
        int j = locate(a, target, 0, i);
        int k = locate(a, target, i+1, a.length-1);
        if (j == -1 && k == -1) return -1;
        else if (j == -1) return k;
        else return j;
    }
	
	private int locate(int[] sorted, int n, int lo, int hi){
		
		int mid = (lo + hi) /2;
		// this is important to avoid stack over flow
		if (lo >= hi && sorted[mid] != n) return -1;
		if (sorted[mid] == n) {return mid;}	
		else if (n > sorted[mid]) {return locate(sorted, n, mid+1, hi);}
		else {return locate(sorted, n, lo, mid-1);}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4};
	    int target = 4;
		System.out.println(new SearchInRotatedSortedArray().search(a, target));

	}

}
