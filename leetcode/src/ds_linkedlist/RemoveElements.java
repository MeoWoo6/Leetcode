// Remove elements
// Given the head of a linked list and an integer val, 
// remove all the nodes of the linked list that has Node.val == val, 
// and return the new head.
// https://leetcode-cn.com/leetbook/read/linked-list/f9izv/
package ds_linkedlist;

public class RemoveElements {
//	iteratively
	public static Node removeElements(Node head, int val) 
	{
		Node dummy = new Node(0);
		dummy.next = head;
		Node prev = dummy;
		while(prev.next != null)
		{
			if(prev.next.val == val)
			{
				prev.next = prev.next.next;
			}
			else
			{
				prev = prev.next;
			}
		}
		return dummy.next;
	}
// recursively
	public static Node removeElements2(Node head, int val) 
	{
		if(head == null)
		{
			return head;
		}
		head.next = removeElements2(head.next, val);
		if(head.val == val)
		{
			return head.next;
		}
		else
		{
			return head;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList2 testlist = new MyLinkedList2();
		testlist.addAtHead(3);
		testlist.addAtHead(4);
		testlist.addAtHead(5);
		testlist.addAtHead(6);
		testlist.addAtHead(5);
		testlist.addAtHead(6);
		removeElements(testlist.head.next, 6);
	}

}
