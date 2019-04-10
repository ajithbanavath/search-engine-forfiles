public class iPageIndex{
	linkedlist<PageEntry> mspe = new linkedlist<PageEntry>();

	public void addPage(PageEntry p){
	    mspe.add(p);
	}

	public linkedlist<PageEntry> getPagesWhichContainWord(String sr){
		Node<PageEntry> n = mspe.head;
		linkedlist<PageEntry> m = new linkedlist<PageEntry>();
		while(n != null){
			if(n.obj.containsWord(sr) || n.obj.containsWord(sr+"s") || n.obj.containsWord(sr.toLowerCase()) || n.obj.containsWord(sr.toLowerCase()+"s")){
				m.add(n.obj);
				n = n.next;
			}
			else {
				n = n.next;
			}
		}
		return m;
	}

	public float no_pagesWhichContainWord(String sr){
		Node<PageEntry> n = mspe.head;
		int i=0;
		while(n != null){
			if(n.obj.containsWord(sr) || n.obj.containsWord(sr+"s") || n.obj.containsWord(sr.toLowerCase()) || n.obj.containsWord(sr.toLowerCase()+"s")){
				i++;
				n = n.next;
			}
			else{
				n = n.next;
			}
		}
		return i;
	}

	public float no_pagesWhichContainPhrase(String[] sr){
		Node<PageEntry> n = mspe.head;
		int i=0;
		while(n != null){
			if(n.obj.containsPhrase(sr)){
				i++;
				n = n.next;
			}
			else n = n.next;
		}
		return i;
	}

	public float totalPages(){
		Node<PageEntry> n = mspe.head;
		int i=0;

		if(n == null){
			return 0;
		}
		else{
			while(n != null){
				i++;
				n = n.next;
			}
		}
		return i;
	}

	public Boolean containspe(String s){
		Node<PageEntry> n = mspe.head;
		while(n != null){
			if(n.obj.pageName.equals(s)) return true;
			else n = n.next;
		}
		return false;
	}

	public PageEntry returnpe(String s){
		Node<PageEntry> n = mspe.head;
		while(n != null){
			if(n.obj.pageName.equals(s)) return n.obj;
			else n = n.next;
		}
		return null;
	}

	public float relevance(String a,PageEntry b){
		return b.getTermFrequency(a)*(float)Math.log(totalPages()/no_pagesWhichContainWord(a));
	}

	public float relevance1(String[] s,PageEntry x){
		return x.getPhraseFrequency(s)*(float)Math.log(totalPages()/no_pagesWhichContainPhrase(s));
	}

//	public linkedlist<PageEntry> getPagesWhichContainPhrase(String str[]){


//	}

	public static void main(String[] args) {
			iPageIndex ip = new iPageIndex();
			PageEntry pe = new PageEntry("stacklighting");
			ip.addPage(pe);
			Node<WordEntry> n = pe.pi.llwe.head;
			while(n != null){
				//System.out.print(n.obj.word+" ");
				Node<position> p = n.obj.llp.head;
				n = n.next;
			}
			System.out.println(pe.containsWord("stack"));
			linkedlist<PageEntry> l = ip.getPagesWhichContainWord("stack");
			Node<PageEntry> x = l.head;
			while(x != null){
				System.out.print(x.obj.pageName);
				x = x.next;
			}
			//System.out.println(x.obj.pageName);

		}	


	
}