package leetcode;


/**
 * helper class from https://leetcode.com/problems/add-two-numbers/
 * 
 * @author rexliu
 *
 */
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	
	// to quickly build a list from an array
	ListNode(int[] a){
		val = a[0];
		ListNode buffer = this;
		for (int i =1; i<a.length; i++){
			buffer.next = new ListNode(a[i]);
			buffer = buffer.next;
		}
	}
}