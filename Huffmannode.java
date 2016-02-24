import java.util.HashMap;
import java.util.PriorityQueue;


public class Huffmannode implements Comparable<Huffmannode> {
	public  String Word;
	public  int freq;
	public  Huffmannode left;
	public  Huffmannode right;
	
	public Huffmannode()
	{
		super();
		Huffmannode left=null;
		Huffmannode right=null;
		Word = null;
		int freq = 0;
	}
	public Huffmannode(String Word, int freq, Huffmannode left, Huffmannode right)
	{
		super();
		this.left = null;
		this.right = null;
		this.Word = Word;
		this.freq = freq;
	}
	
	public  boolean isleaf(Huffmannode at)
	{
		if(at.left==null&&at.right ==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public int compareTo(Huffmannode arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void search(String string,Huffmannode root, HashMap<String, String> j) {
		// TODO Auto-generated method stub

		if(root.left == null && root.right==null)
		{
			j.put(root.Word, string);
			//System.out.println(Word);
		}
		if(root.left !=null)
		{
			//string+="0";
			this.search(string+"0",root.left,j);
		}
		if(root.right!=null)
		{
			//string+="1";
			this.search(string+"1",root.right, j);
		}
		
		
	}
	

}