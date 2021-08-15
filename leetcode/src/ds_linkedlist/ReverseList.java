// 反转链表
// https://leetcode-cn.com/leetbook/read/linked-list/f58sg/
// 可以用迭代和递归两种方式
package ds_linkedlist;

public class ReverseList {
//	迭代
	public Node reverseList(Node head) 
	{
		Node prev = null;
		Node curr = head;
		while(curr != null)
		{
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
		
	}
//	递归
	public Node reverseList2(Node head) 
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		Node newhead = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return newhead;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
