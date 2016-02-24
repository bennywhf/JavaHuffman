import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Vector;

import javax.imageio.IIOException;
import javax.xml.soap.Node;

public class Frequence {

public Frequence(String in, String out) {
	super();
		int wspaces = Spaces(in);
		int endline = endlinecount(in);
		try {
			BufferedReader f = new BufferedReader(new FileReader(in+".txt"));
			Vector<String> lines = new Vector<String>();
			String line;
			Scanner scanner1= new Scanner(f);
			int wordcount = 0;
			while(scanner1.hasNext())
			{
			line = scanner1.next();
			wordcount++;
			lines.add(line);	
			}
			Collections.sort(lines);
			scanner1.close();
			
			int i=0;
			System.out.println("1");
			Map<String,Integer> j = new HashMap<String,Integer>();
			j.put("spaces", wspaces);
			j.put("/n", endline);
			while(i<wordcount)
			{
				String word;
				int counter = 1;
				int y = i;
				word = lines.elementAt(y);
				if(i<wordcount-1)
				while(lines.elementAt(y).equals(lines.elementAt(y+1)))
				{
					counter++;
					if(y+1 == wordcount-1)
					{
						break;
					}
					y++;
				}
				j.put(word, counter);
				i=i+counter;
				
			}
			
			List<Entry<String,Integer>> list = new LinkedList<Entry<String,Integer>>(j.entrySet());
			
			Collections.sort(list, new Comparator<Entry<String, Integer>>()
					{
				@Override
				public int compare(Entry<String, Integer> arg0,
						Entry<String, Integer> arg1) {
					return arg1.getValue().compareTo(arg0.getValue());
				}
				});
			
			
			
			
			
			Map<String,Integer> sorted = new LinkedHashMap<String, Integer>();
			for (Entry<String,Integer>entry:list)
			{
				sorted.put(entry.getKey(), entry.getValue());
			}
			
			
			//Linklist
			
			// use sorted.entrySet to put values in to the nodes
			ArrayList<Huffmannode> s = new ArrayList<Huffmannode>();
			for(Map.Entry<String, Integer> m :sorted.entrySet())
			{
				s.add(new Huffmannode(m.getKey(),m.getValue(), null, null));
			}
		
			while (s.size()>1)
			{
				Huffmannode newnode = new Huffmannode();
				newnode.left = s.remove(s.size()-1);
				newnode.right= s.remove(s.size()-1);
				newnode.freq = newnode.left.freq + newnode.right.freq;

				s.add(newnode);
				for(int o = s.size()-1;  o>0; o--)
				{
				if(s.get(o).freq >s.get(o-1).freq)
				{
					Huffmannode temp = s.get(o);
					s.set(o,s.get(o-1));
					s.set(o-1,temp);
				}
				}
				
			}

			Huffmannode root = s.remove(0);
			HashMap<String,String> y = new HashMap<String,String>();
			root.search("",root,y);
			
			File outs = new File(out+".txt");
			FileOutputStream fos = new FileOutputStream(outs);
			PrintWriter oos = new PrintWriter(fos);
			oos.println("Word   Frequency");
			oos.println();
			
			
			
			for(Map.Entry<String, String> k:y.entrySet())
			{
			oos.println(k.getKey()+" "+ k.getValue());
			}
			
			oos.flush();
			oos.close();
			fos.close();
			
			}

		catch(Exception e)
			{
				e.printStackTrace();
			}
		}






private int endlinecount(String in) {
	// TODO Auto-generated method stub
	int empty=0;
	try{
	BufferedReader f = new BufferedReader(new FileReader(in+".txt"));	
	Scanner emptys = new Scanner(f);
	String line;
	while((line = f.readLine())!=null)
	{
			empty++;
	}
	}
	catch(Exception e)
	{
		
	}
	return empty;
}



private int Spaces(String in) {
	// TODO Auto-generated method stub
	int countBlank = 0;
	try {
	BufferedReader f = new BufferedReader(new FileReader(in+".txt"));
	String lin;
	Scanner scanner1= new Scanner(f);

	while(scanner1.hasNext())
	{
	lin = scanner1.nextLine();
	for(int i=0; i<lin.length(); i++) {
	    if(Character.isWhitespace(lin.charAt(i))) {
	        countBlank++;
	    }
	}
	}
	scanner1.close();
}
	catch(IOException e)
	{
		
	}
	return countBlank;
}
}