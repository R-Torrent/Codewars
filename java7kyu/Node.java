package java7kyu;

/** Linked Lists - Get Nth Node
 *  7 kyu */
public class Node {
	
	public int data;
	public Node next = null;
	
	public static int getNth(Node n, int index) throws Exception {
		do {
			if(n == null) throw new Exception("Node does not exist!");
			if(index-- == 0)
				return n.data;
			n = n.next;
		} while(true);
	}
	
}