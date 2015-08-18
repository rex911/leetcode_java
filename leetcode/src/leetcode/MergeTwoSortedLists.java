/**
 * 
 */
package leetcode;

/**
 * @author rexliu
 *
 */
public class MergeTwoSortedLists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
        ListNode ret, buffer;
        if (l1.val < l2.val) {
        	ret = l1;
        	l1 = l1.next;
        } else {
        	ret = l2;
        	l2 = l2.next;
        }
        buffer = ret;
        while (l1 != null || l2 != null){
        	if (l2 == null){
        		buffer.next = l1;
        		break;
        	}
        	if (l1 == null){
        		buffer.next = l2;
        		break;
        	}
        	if (l1.val < l2.val) {
            	buffer.next = l1;
            	l1 = l1.next;
            	buffer = buffer.next;
            }  else{
            	buffer.next = l2;
            	l2 = l2.next;
            	buffer = buffer.next;
            }
        }
        return ret;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-10,-10,-9,-4,1,6,6};
		int[] b = {-7};
		ListNode l1 = new ListNode(a);
		ListNode l2 = new ListNode(b);
		ListNode merged = new MergeTwoSortedLists().mergeTwoLists(l1, l2);
		while (merged != null) {
			System.out.println(merged.val);
			merged = merged.next;
		}

	}

}
