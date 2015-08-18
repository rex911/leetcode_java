/**
 * 
 */
package leetcode;

/**
 * @author rexliu
 *
 */
public class SwapNodesInPairs {
	
	public ListNode swapPairs(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return head;
		// prev: the last node of the previous pair
        ListNode tmp, buffer = head, ret = head.next, prev = null;
        
        while (buffer != null){
        	if (buffer.next == null) break;
        	tmp = buffer.next;
        	buffer.next = buffer.next.next;
        	tmp.next = buffer;
        	// so far tmp is the root node of the list with the first pair swapped 
        	
        	if (prev != null) prev.next = tmp;
        	// move to the next pair
        	buffer = tmp.next.next;
        	// update the previous pair
        	prev = tmp.next;
        }
        return ret;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {5};
		ListNode b = new ListNode(a), c = new SwapNodesInPairs().swapPairs(b);
		while (c != null) {
			System.out.println(c.val);
			c = c.next;
		}

	}

}
