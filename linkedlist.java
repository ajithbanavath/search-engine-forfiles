public class linkedlist<X>{
	Node<X> head;

	public void add(X a){
		Node<X> n = new Node<X>(a);
		if(head == null){
			head = n;
		}
		else{
			Node<X> h = head;
			while(h.next != null){
				h = h.next;
			}
			h.next = n;
		}
	}

	public int n_nodes(){
		Node<X> n = head;
		if(n == null){
			return 0;
		}
		else{
			int i=0;
			while(n != null){
				i++;
				n = n.next;
			}
			return i;
		}
	}

	public Node<X> count(int i){
		Node<X> n = head;
		int j=0;
		while(n != null){
			if(i==j){
				return n;
			}
			else n = n.next;
		}
		return null;
	}

	public Node<X> mergeSort(){
		Node<X> h = head;
		if(h == null || h.next == null){
			return h;
		}
		Node<X> middle = middleElement(h);
		Node<X> n_o_Middle = middle.next;
		middle.next = null;
		linkedlist<X> l1 = new linkedlist<X>();
		l1.head = h;
		linkedlist<X> l2 = new linkedlist<X>();
		l2.head = n_o_Middle;

		Node<X> left = l1.mergeSort();
		Node<X> right = l2.mergeSort();

		Node<X> sortdList = merge(left,right);
		return sortdList;
	}

	public Node<X> merge(Node<X> left,Node<X> right){
		if(left == null){
			return right;
		}
		if(right == null){
			return left;
		}
		Node<X> temp = null;
		if(left.rel > right.rel){
			temp = left;
			temp.next = merge(left.next,right);
		}
		else{
			temp = right;
			temp.next = merge(left,right.next);
		}
		return temp;
	}

	public Node<X> middleElement(Node<X> head){
		Node<X> slow = head;
		Node<X> fast = head;
		while(fast!=null && fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}

	class Node<X>{
		X obj;
		Node<X> next;
		Node<X> back;
		float rel;
		Node(X a){
			obj = a;
			next = null;
			rel = 0;
		}		
	}
