@SuppressWarnings("unchecked")

public class SearchEngine{
	iPageIndex ipi;

	SearchEngine(){
		ipi = new iPageIndex();
	}

	public void performAction(String actionMessage){
		String[] s = actionMessage.split(" ");

		if(s[0].equals("addPage")){
			PageEntry pt = new PageEntry(s[1]);
			if(pt == null){
				System.out.println("No webpage "+s[1]+" found");
			}
			else{
				ipi.addPage(pt);
				System.out.println("webpage "+s[1]+" added");
			}	
			//System.out.println("add");
		}

		else if(s[0].equals("queryFindPagesWhichContainWord")){
			Node<PageEntry> n = ipi.getPagesWhichContainWord(s[1]).head;
			//if(n == null) System.out.println("vi");
			if(n == null){System.out.println("No webpage contains word "+s[1]);}
			else{
				while(n.next != null){
					System.out.print(n.obj.pageName+", ");
					n = n.next;
				}
				System.out.println(n.obj.pageName);
			}	
		}

		else if(s[0].equals("queryFindPositionsOfWordInAPage")){
			if(ipi.containspe(s[2])){
				PageEntry x = ipi.returnpe(s[2]);
				if(x.containsWord(s[1])){
					linkedlist<position> y = x.pi.getPosition(s[1]);
					Node<position> z = y.head;
					while(z.next != null){
						System.out.print(z.obj.wi+", ");
						z = z.next;
					}
					System.out.println(z.obj.wi);
				}
				else{
					System.out.println("Webpage "+s[2]+" does not contain word "+s[1]);
				}	
			}
			else{
				System.out.println("No webpage "+s[2]+" found");
			}
		}

		else if(s[0].equals("queryFindPagesWhichContainAllWords")){
			int j = s.length;
			linkedlist<PageEntry> t = new linkedlist<PageEntry>();
			Node<PageEntry> q = ipi.mspe.head;
			if(q == null)System.out.println("No webpage in the database");
			else{	
				while(q != null){
					int k=0;
					for(int i=1;i<j;i++){
						if(!q.obj.containsWord(s[i])){
						k++;
						}
					}
					if(k==0){
						t.add(q.obj);
						q = q.next;
					}
					else {
						q = q.next;
					}	
				}
				Node<PageEntry> l = t.head;
				while(l != null){
					for(int a=1;a<j;a++){
						l.rel = l.rel + ipi.relevance(s[a],l.obj);
					}
					l = l.next;	
				}
				Node<PageEntry> h = t.mergeSort();
				if(h==null)System.out.println("No webpage contains all the words");
				while(h.next != null){
					System.out.print(h.obj.pageName+", ");
					h = h.next;
				}
				System.out.println(h.obj.pageName);
			}
		}

		else if(s[0].equals("queryFindPagesWhichContainAnyWord")){
			int j = s.length;
			linkedlist<PageEntry> t = new linkedlist<PageEntry>();
			Node<PageEntry> q = ipi.mspe.head;
			if(q == null)System.out.println("No webpage in the database");
			else{
				while(q != null){
					b:for(int i=1;i<j;i++){
						if(q.obj.containsWord(s[i])){
							t.add(q.obj);
							break b;
						}
					}
					q = q.next;
				}
				Node<PageEntry> l = t.head;
				while(l != null){
					for(int a=1;a<j;a++){
						l.rel = l.rel + ipi.relevance(s[a],l.obj);
					}
					l = l.next;
				}
				Node<PageEntry> h = t.mergeSort();
				if(h==null)System.out.println("No webpage contains any word given");
				else{
					while(h.next != null){
						System.out.print(h.obj.pageName+", ");
						h = h.next;
					}
					System.out.println(h.obj.pageName);
				}
			}
		}

		else if(s[0].equals("queryFindPagesWhichContainPhrase")){
			int j = s.length;
			linkedlist<PageEntry> t = new linkedlist();
			Node<PageEntry> q = ipi.mspe.head;
			if(q == null) System.out.println("No webpage in the database");
			else{
				while(q != null){
					if(q.obj.containsPhrase(s)){
						t.add(q.obj);
						q = q.next;
					}
					else q = q.next;
				}
				Node<PageEntry> l = t.head;
				while(l != null){
					for(int a=1;a<j;a++){
						l.rel = l.rel + ipi.relevance1(s,l.obj);
					}
					l = l.next;
				}
				Node<PageEntry> h = t.mergeSort();
				if(h==null)System.out.println("No webpage contains the given phrase");
				else{
					while(h.next != null){
						System.out.print(h.obj.pageName+", ");
						h = h.next;
					}
					System.out.println(h.obj.pageName);;
				}
			}	
		}
	}

	public static void main(String[] args) {
		SearchEngine se = new SearchEngine();
		//se.performAction("addPage stack_datastructure_wiki");
		//se.performAction("addPage stack_magazine");
		se.performAction("addPage stack_datastructure_wiki");		
		se.performAction("queryFindPositionsOfWordInAPage stack stack_datastructure");
		se.performAction("addPage stack_cprogramming");
		se.performAction("queryFindPagesWhichContainWord data");
		se.performAction("queryFindPagesWhichContainWord single");
		se.performAction("addPage stack_oracle");
		se.performAction("queryFindPagesWhichContainWord pops");
		se.performAction("queryFindPagesWhichContainWord stack");
		se.performAction("queryFindPagesWhichContainWord wikipedia");
		se.performAction("addPage stacklighting");
		se.performAction("addPage stackmagazine");
		se.performAction("queryFindPositionsOfWordInAPage light stack_magazine");
		se.performAction("queryFindPositionsOfWordInAPage light stackmagazine");
		se.performAction("queryFindPagesWhichContainWord Stack");
		System.out.println(se.ipi.no_pagesWhichContainWord("ajith"));
		se.performAction("queryFindPositionsOfWordInAPage stack stackmagazine");
		System.out.println(se.ipi.mspe.head.obj.getTermFrequency("stack"));
		System.out.println(se.ipi.mspe.head.obj.pi.getTotalWords());
		System.out.println(se.ipi.mspe.head.obj.tw);
		System.out.println(se.ipi.totalPages());
		System.out.println(se.ipi.totalPages());
		Node<PageEntry> n = se.ipi.mspe.head;
		while(n != null){
			System.out.print(se.ipi.relevance("structure",n.obj)+" ");
			n = n.next;
		}
		System.out.println(" ");
		se.performAction("queryFindPagesWhichContainAllWords data structure");
		se.performAction("queryFindPagesWhichContainAnyWord data structure class");
		se.performAction("addPage stackmagazine");
		se.performAction("addPage stacklighting");
		se.performAction("queryFindPagesWhichContainPhrase egg on it");
		String[] f = {"aksdbf","stack","today"};
		System.out.println(se.ipi.mspe.head.obj.containsPhrase(f));
		System.out.println(se.ipi.no_pagesWhichContainPhrase(f));
		System.out.println(se.ipi.mspe.head.obj.no_timesContainsPhrase(f));
		

	}
}