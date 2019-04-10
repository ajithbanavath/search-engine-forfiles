public class PageIndex{
	linkedlist<WordEntry> llwe = new linkedlist<WordEntry>();

	public void addPositionForWord(String str, position p){
		Node<WordEntry> n = llwe.head;
		if(n == null){
			WordEntry w = new WordEntry(str);
			w.addPosition(p);
			llwe.add(w);
		}
		else{
			int i = 0;
			while(n != null){
				if(n.obj.word.equals(str) || n.obj.word.equals(str+"s") || n.obj.word.equals(str.substring(0,str.length()-1))){
					n.obj.addPosition(p);
					i++; break;
				}
				else n = n.next;
			}
			if(i == 0){
				WordEntry w = new WordEntry(str);
				w.addPosition(p);
				llwe.add(w);
			}
		}
	}

	public linkedlist getPosition(String a){
		Node<WordEntry> l = llwe.head;
		while(l != null){
			if(l.obj.word.equals(a) || l.obj.word.equals(a+"s") || l.obj.word.equals(a.substring(0,a.length()-1))){
				return l.obj.llp;
			}
			else l = l.next;
		}
		return null;
	}


	public float getTermCount(String a){
		Node<WordEntry> l = llwe.head;
		while(l != null){
			if(l.obj.word.equals(a) || l.obj.word.equals(a+"s") || l.obj.word.equals(a.substring(0,a.length()-1))){
				return l.obj.getTermCount();
			}
			else l = l.next;
		}
		return 0;
	}

	public float getTotalWords(){
		Node<WordEntry> l = llwe.head;
		int i=0;
		if(l == null){
			return 0;
		}
		else{
			while(l != null){
				i++;
				l =l.next;
			}
		}
		return i;
	}

	

	

}