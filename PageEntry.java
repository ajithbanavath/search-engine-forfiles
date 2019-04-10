import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")

public class PageEntry{
	String pageName;
	int tw;
	PageIndex pi = new PageIndex();
	AVL avl = new AVL();
	PageEntry(String pageNe){
		pageName = pageNe;

		try{	File f1 = new File("S:\\JAVA\\Assign3\\webpages\\"+pageName);
				File f2 = new File("S:\\JAVA\\Assign3\\webpages\\"+"s"+pageName);
				BufferedReader in = (new BufferedReader(new FileReader(f1)));
				PrintWriter out = (new PrintWriter(new FileWriter(f2)));
				String line;
				String pLine = "";
				while((line = in.readLine()) != null){
					pLine = line.replaceAll("[^a-zA-Z0_9]"," ").toLowerCase().replaceAll("( )+"," ");
					out.write(pLine);
					out.write(System.getProperty("line.separator"));
				}
				in.close();
				out.close();	

 	    		Scanner input = new Scanner(f2);
 	    		int i = 0;
 	    		while(input.hasNext() ){
 	    			String s = input.next();
 	    			if(!s.equals("a")&&!s.equals("as")&&!s.equals("an")&&!s.equals("the")&&!s.equals("they")&&!s.equals("these")&&!s.equals("this")&&!s.equals("for")&&!s.equals("is")&&!s.equals("are")&&!s.equals("was")&&!s.equals("of")&&!s.equals("or")&&!s.equals("and")&&!s.equals("does")&&!s.equals("will")&&!s.equals("whose")){
						position v = new position(i);
 	    				v.wi = i;
						pi.addPositionForWord(s,v);
						avl.insert(s,i);
						i++;	
					}
					else{i++;}
								
 	    		}
 	    		tw = i;
 	    }
 	    catch(IOException ex){ 
 	    	ex.printStackTrace();
 	    }
	}

	public Boolean containsWord(String s){
		Node<WordEntry> n = pi.llwe.head;
		while(n != null){
			if(n.obj.word.equals(s) || n.obj.word.equals(s+"s") || n.obj.word.equals(s.substring(0,s.length()-1))) return true;
			else n = n.next;
		}
		return false;
	}

	public Boolean containsPhrase(String[] s){
		int j = s.length;
		int k=0;
		int y=0;
		for(int i=1;i<j;i++){
			if(!containsWord(s[i]))
				k++;
		}	
		if(k>0) return false;
		else{
			linkedlist<position> l = pi.getPosition(s[1]);
			Node<position> t = l.head;
			while(t != null){
				k=0;
				int g=1;int i=0;
				a:while(g<j){
					if(avl.returnNode(t.obj.wi+i) == null){
						i++;
					}
					else{
						if(avl.returnNode(t.obj.wi+i).we.equals(s[g])||avl.returnNode(t.obj.wi+i).we.equals(s[g]+"s")){
							k++;
							g++;i++;
						}
						else break a;
					}
				}
				if(k == j-1) return true;
				else t = t.next;
			}

			return false;
		}
	}



	public float no_timesContainsPhrase(String[] s){
		int j = s.length;
		int k=0;
		int y=0;
		for(int i=1;i<j;i++){
			if(!containsWord(s[i]))
				k++;
		}	
		if(k>0) return 0;
		else{
			linkedlist<position> l = pi.getPosition(s[1]);
			Node<position> t = l.head;
			while(t != null){
				k=0;
				int g=1;int i=0;
				a:while(g<j){
					if(avl.returnNode(t.obj.wi+i) == null){
						i++;
					}
					else{
						if(avl.returnNode(t.obj.wi+i).we.equals(s[g])||avl.returnNode(t.obj.wi+i).we.equals(s[g]+"s")){
							k++;
							g++;i++;
						}
						else break a;
					}
				}
				if(k == j-1) y++;
			    t = t.next;
			}

			return y;
		}
	}

	public float getTermFrequency(String a){
		return pi.getTermCount(a)/tw;
	}

	public float getPhraseFrequency(String[] s){
		return no_timesContainsPhrase(s)/(tw-(s.length-1)*no_timesContainsPhrase(s));
	}


//	public Boolean containsPhrase(String s[]){

//	}

	public static void main(String[] args) {
		PageEntry pe = new PageEntry("stackmagazine");
		System.out.println(pe.containsWord("fiera"));
		System.out.println(pe.containsWord("rec"));
		System.out.println(pe.containsWord("put"));
		System.out.println(pe.containsWord("egg"));

		System.out.println(pe.avl.returnNode(2).we);
		String[] f = {"ads","matter","discover","different"};
		System.out.println(pe.containsPhrase(f));
		System.out.println(pe.no_timesContainsPhrase(f));
		

	}

}