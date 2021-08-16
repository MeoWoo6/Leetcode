// Is Palindrome?
// https://leetcode-cn.com/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/
package ds_linkedlist;

import java.util.ArrayList;
import java.util.List;
public class IsPalindrome {
//	Method1
//	Using the ArrayList to store the values of the linked list
	public boolean isPalindrome(Node head)
	{
		List <Integer> vals= new ArrayList<Integer>();
		while(head!=null)
		{
			vals.add(head.val);
			head = head.next;
		}
		int i = 0;
		int j = vals.size()-1;
		while(i<j)
		{
			if(vals.get(i) != vals.get(j))
			{
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
//	Method2
//	Use the fast and slow pointer to find the middle node
//	then reverse the second half linked list
//	compare the reversed one with the first half
	public boolean isPalindrome2(Node head)
	{
		
		Node sechead = SecondHead(head);
		Node secend = reverseList(sechead);
		while(head != null && secend != null)
		{
			if(head.val != secend.val)
			{
				return false;
			}
			head = head.next;
			secend = secend.next;
		}
		return true;
	}
	
	public static Node SecondHead(Node head)
	{
//		return the head of second half linked list
//		the list is not null
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast == null)
		{
			return slow;
		}
		else
		{
			return slow.next;
		}
	}
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
	
//	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
