/**
 * 
 */
package leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * @author rexliu
 *
 */


public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		if(l1 == null && l2 == null) return null; 
		// use multiple variables to keep track of the root
		ListNode result, retVal, longer, shorter;
		if (length(l1) > length(l2)) {
			result = l1;
			retVal = l1;
			longer = l1;
			shorter = l2;
		} else {
			result = l2;
			retVal = l2;
			longer = l2;
			shorter = l1;
		}
		while (shorter != null) {
			longer.val += shorter.val;
			longer = longer.next;
			shorter = shorter.next;
		}
		// doing the carry
		while (result != null) {
			if (result.val > 9) {
				result.val -= 10;
				if (result.next != null) {
					result.next.val += 1;
				} else {
					result.next = new ListNode(1);
				}
			}
			result = result.next;
		}
		return retVal;

	}
	private int length(ListNode l) {
		int retVal = 0;
		while (l != null) {
			retVal ++;
			l = l.next;
		}
		return retVal;
	}

	/**
	 * test case
	 * 
	 * @param args
	 */
	 public static void main(String[] args) {
		 ListNode a = new ListNode(5);
		 a.next = new ListNode(4);
		 //a.next.next = new ListNode(4);
		 
		 ListNode b = new ListNode(5);
		 b.next = new ListNode(6);
		 b.next.next = new ListNode(4);
		 ListNode c =new AddTwoNumbers().addTwoNumbers(a,b);
		 while (c != null){
			 System.out.println(c.val);
			 c = c.next;
		 }

	 }


}
