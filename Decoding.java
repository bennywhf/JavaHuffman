import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Pattern;


public class Decoding {
	public Decoding(String in, String out, String huffs) {
	super();
	try{
		File f = new File(huffs+".txt");
		FileInputStream input = new FileInputStream(f);
		Scanner i = new Scanner(input);
		HashMap<String,String> o = new HashMap<String,String>();
		String string;
		i.nextLine();
		while(i.hasNext())
		{
			string = i.nextLine();
			StringTokenizer st = new StringTokenizer(string," ", false);
			while(st.hasMoreTokens()){
				o.put(st.nextToken(), st.nextToken());
			}
		}
		System.out.println("1");
		input.close();
		Huffmannode root = new Huffmannode();
		Huffmannode at = root;
		for(Map.Entry<String, String> m:o.entrySet())
		{
			at=root;
			for(int y =0;y<m.getValue().length();y++)
			{
				if(m.getValue().charAt(y)=='0')
				{	
				if(at.left == null){
				at.left = new Huffmannode();
				}
				at=at.left;
				}
				if(m.getValue().charAt(y)=='1')
				{
				if(at.right == null){
				at.right = new Huffmannode();
				}
				at=at.right;
				}
			}
			at.Word = m.getKey();

		};
		at =root;
		BufferedReader h = new BufferedReader(new FileReader(in+".txt"));
		File outs = new File(out+".txt");
		FileOutputStream fos = new FileOutputStream(outs);
		PrintWriter oos = new PrintWriter(fos);
		Scanner scanner = new Scanner(h);
		String line;
		StringBuilder k = new StringBuilder();
		StringBuilder Extra = new StringBuilder();
//		line = h.readLine();
		
		
		
		
		
		///////////////////////////////////////////////////////////////////////
		while(scanner.hasNext())
		{
		int n = 0;
		String s = scanner.next();
//		System.out.print(s);
		byte[] b = s.getBytes();
		//s.getBytes().
		System.out.println(b[1]);
		for(int v = 0; v<Byte.SIZE*b.length;v++)
		{
			k.append((b[v/Byte.SIZE]<<v%Byte.SIZE&0x80)== 0?'0':'1');
			Extra.append((b[v/Byte.SIZE]<<v%Byte.SIZE&0x80)== 0?'0':'1');
			n++;
//			System.out.println(n);	
			
		}
		
		/*(File sd = new File("Please.txt");
		FileOutputStream fossss = new FileOutputStream(sd);
		PrintWriter ooss = new PrintWriter(fossss);
		for(int v = 0; v<b.length ; v++)
		{
			ooss.write(b[v]);

			System.out.println(b[v]);
		}
		ooss.close();
//		System.out.println(k.toString());
		*/}
		
		File t = new File("examples.txt");
		FileOutputStream foss = new FileOutputStream(t);
		PrintWriter ooss = new PrintWriter(foss);
		ooss.write( Extra.toString());
		line = k.toString();
		//////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		
//		// CONVERTING!!!!
//		
//		while(scanner.hasNext())
//		{
//		String u = scanner.nextLine();
//		int l = 0;
//		StringTokenizer st = new StringTokenizer(u,",",false);
//		int v = st.countTokens();
//		while(st.hasMoreTokens())
//		{
//			String temp = st.nextToken();
//			if(l==v-1)
//			{
//				if(u.charAt(u.length()-1)==',')
//				{
//				String p = Integer.toBinaryString(Integer.parseInt(temp));
//				while(p.length()!=8)
//				{
//					p = "0"+p;
//				}
//				k.append(p);
//				}
//				else
//				{
//				k.append(temp);
//				System.out.println(temp);
//				}
//			}
//			else if(temp.length()==8)
//			{
//				String p = Integer.toBinaryString(Integer.parseInt(temp));
//				while(p.length()!=8)
//				{
//					p = "0"+p;
//				}
//				k.append(p);
//				System.out.println(p);
//				
//			}
//			else if(isInteger(temp)== true)
//			{
//				String p = Integer.toBinaryString(Integer.parseInt(temp));
//				while(p.length()!=8)
//				{
//					p = "0"+p;
//				}
//				k.append(p);
//				System.out.println(p);
//			}
//			else
//			{
//				String p = Integer.toBinaryString((int)temp.charAt(0));
//				while(p.length()!=8)
//				{
//					p = "0"+p;
//				}
//				System.out.println(p);
//				k.append(p);
//			}
//			
//			l++;
//			
//		}
//		
////		for(int b = 0;b<u.length();b++)
////		{
////		l = u.charAt(b);
////		int c = (int) u.charAt(b);
////		String p = Integer.toBinaryString(c);
////		
////		if(b!= u.length()-1)
////		{
////		while(p.length()!=8){
////			p = "0" + p;
////		//Thread.sleep(3000);
////		}
////		}System.out.println(p);
//		}
//		line = k.toString();
		
		
		
		for(int g=0;g<line.length();g++)
		{
				if(line.charAt(g)=='0'){
					at = at.left;
				}
				if(line.charAt(g)=='1'){
					at = at.right;
				}
				if(line.charAt(g)!='0'&&line.charAt(g)!='1')
				{
					oos.print(line.charAt(g));
				}
				if(at.isleaf(at)==true)
					{
					if(at.Word.equals("spaces"))
					{
						oos.print(" ");
						at=root;
					}
					else if(at.Word.equals("/n"))
					{
						oos.println();
						at=root;
					}
					else
					{
						oos.print(at.Word);
						at=root;
					}
					}
			}
		oos.flush();
		oos.close();
		fos.close();
		ooss.close();
		
	}
	catch(Exception e)
	{
	System.out.print(e);
	}
	}

	private boolean isInteger(String temp) {
		// TODO Auto-generated method stub
		try{
			Integer.parseInt(temp);
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		return true;
	}
}
