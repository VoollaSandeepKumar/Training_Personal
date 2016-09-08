
public class LinkedListTest {

	int data;
	LinkedListTest next;
	public LinkedListTest(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.next = null;
	}
	
	private static LinkedListTest build123()
	{
		LinkedListTest head = new LinkedListTest(1);
		head.next = new LinkedListTest(2);
		head.next.next = new LinkedListTest(3);
		return head;
	}
	private static int count(LinkedListTest head)
	{
		LinkedListTest local = head;
		int count =0;
		while(local != null)
		{
			count++;
			local = local.next;
		}
		return count;
	}
	
	private static LinkedListTest push(LinkedListTest head, int data)
	{
		LinkedListTest temp = new LinkedListTest(data);
		
		temp.next = head;
		head = temp;
		return head;
	}
	private static int getNth(LinkedListTest head ,int index)
	{
		int count =0;
		while(head!=null)
		{
			if(count == index)
				return head.data;
			count++;
			head = head.next;
		}
		return -1;
	}
	private static LinkedListTest deleteList(LinkedListTest head)
	{
		LinkedListTest current = head;
		LinkedListTest next = null;
		while(current != null)
		{
			next = current.next;
			current.next = null;
			current = next;
		}
		return current;
	}
	public static void main(String[] args) {
		
		LinkedListTest head = build123();
		System.out.println(count(head)+"\n");
		head = push(head,4);
		System.out.println(count(head)+"\n");
		System.out.println(getNth(head, 5)+"\n");
		LinkedListTest delNode = deleteList(head);
	}
	}
