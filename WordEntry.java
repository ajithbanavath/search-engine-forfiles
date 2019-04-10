public class WordEntry{
	String word;
	linkedlist<position> llp = new linkedlist<position>();

	WordEntry(String word){
		this.word = word;
	}

	public void addPosition(position p){
		this.llp.add(p);
	}


	public float getTermCount(){
		Node n = llp.head;
		int i=0;
		if(n == null){
			return 0;
		}
		else{
			while(n != null){
				i++;
				n = n.next;
			}
			return i;
		}
	}

	
	

	public static void main(String[] args) {
	
	}

}