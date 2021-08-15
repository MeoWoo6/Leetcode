// Remove elements
// Given the head of a linked list and an integer val, 
// remove all the nodes of the linked list that has Node.val == val, 
// and return the new head.
// https://leetcode-cn.com/leetbook/read/linked-list/f9izv/
package ds_linkedlist;

public class RemoveElements {
	public ListNode removeElements(ListNode head, int val) 
	{
		removeElements(head.next, val)
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
