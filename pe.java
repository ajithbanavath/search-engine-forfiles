import java.util.*;
import java.io.*;

public class pe{
	String pageName;
	PageIndex pi = new PageIndex();
	pe(String pageName){
		pageName = pageName;

		try{File f1 = new File("S:\\JAVA\\a3\\webpages\\"+pageName);
		File f2 = new File("S:\\JAVA\\a3\\webpages\\"+"s"+pageName);
		BufferedReader in = (new BufferedReader(new FileReader(f1)));
		PrintWriter out = (new PrintWriter(new FileWriter(f2)));
		String line;
		String pLine = "";
		while((line = in.readLine()) != null){
			pLine = line.replaceAll("[^a-zA-Z0_9]", " ").toLowerCase().replaceAll("( )+"," ");
			out.write(pLine);
			out.write(System.getProperty("line.separator"));
		}}
		catch(IOException ex){ex.printStackTrace();}
		
	}

	public Boolean containsWord(String s){
		Node<WordEntry> n = pi.llwe.head;
		while(n != null){
			if(n.obj.word.length() == s.length()){
				int j = s.length();
				for(int i=0;i<j;i++){
					if(n.obj.word.charAt(i) != s.charAt(i)) break;
				}
				return true;
			}
			else n = n.next;
		}
		return false;
	}

	public static void main(String[] args) {
		pe e = new pe("stackoverflow.txt");
		System.out.println(e.containsWord(""));
		Node<WordEntry> n = e.pi.llwe.head;
		/*while(n != null){
			System.out.println(n.obj.word);
			if(n.obj.word == "cnet ") System.out.println("tre");
			n = n.next;
		}*/
	}
}	
