// 奇偶链表
// https://leetcode-cn.com/problems/odd-even-linked-list/solution/qi-ou-lian-biao-by-leetcode-solution/
package ds_linkedlist;

public class OddEvenList {
//	这个版本写得有点啰嗦
	public static Node oddEvenList(Node head)
	{
		if(head == null || head.next == null || head.next.next == null)
		{
			return head;
		}// 这个判断条件是不是有点多？
		Node evenhead = head.next;
		Node oddptr = head;
		Node evenptr = evenhead;
		Node curr = evenptr.next; // 这个应该可以省去？
		while(curr!=null)
		{
			oddptr.next = curr;
			oddptr = oddptr.next;
			curr = curr.next;
			evenptr.next = curr;
			evenptr = evenptr.next;
			if(curr == null)
			{
				break;
			}
			curr = curr.next;
		}
		oddptr.next = evenhead;
		return head;
		
	}
	public static Node oddEvenList2(Node head)
	{
		if(head == null)
		{
			return head;
		}
		Node oddptr = head;
		Node evenptr = head.next;
		Node evenhead = head.next;
		
		while(evenptr != null && evenptr.next != null)
		{
			oddptr.next = evenptr.next;
			oddptr = oddptr.next;
			evenptr.next = oddptr.next;
			evenptr = evenptr.next;
		}
		oddptr.next = evenhead;
		return head;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList1 testlist = new MyLinkedList1();
		oddEvenList(testlist.head);
		

	}

}
