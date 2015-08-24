/**
 * 
 */
package leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * @author rexliu
 *
 */
public class RemoveDuplicatesFromSortedArray {
	
	public int removeDuplicates(int[] a) {
		if (a == null) return 0;
		int i = 1;
        while (i < a.length){
        	if (a[i] <= a[i-1]) {
        		int j = i + 1;
        		// find the next value to insert at i, which must be > a[i-1]
        		while (j < a.length) {
        			if (a[j] > a[i-1]) break;
        			j ++;
        		}
        		if (j < a.length) {
        			a[i] = a[j];

        		}
        		
        		
        	}
        	i ++;
        }
        for (i = 1; i<a.length;i++){
        	if (a[i] <= a[i-1]) return i;
        }
        // return in the above for loop won't trigger if input is already non-duplicate
        return a.length;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {1,1,2};
		int j =new RemoveDuplicatesFromSortedArray().removeDuplicates(a);
		for (int i=0; i< j; i++){
			System.out.println(a[i]);
		}
	}

}
