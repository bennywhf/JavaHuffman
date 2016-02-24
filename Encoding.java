import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Encoding {
public Encoding(String in, String out, String huff){
	super();
	try {
		File f = new File(huff+".txt");
		FileInputStream input = new FileInputStream(f);
		Scanner i = new Scanner(input);
		HashMap<String, String> o = new HashMap<String, String>();
		String string;
		i.nextLine();
		int z=0;
		while(i.hasNext())
		{
			z++;
			string = i.nextLine();
			StringTokenizer st = new StringTokenizer(string," ", false);
			while(st.hasMoreTokens()){
			o.put(st.nextToken(), st.nextToken());
			}
		}
		input.close();
		
//		ByteArrayOutputStream s
		BufferedReader h = new BufferedReader(new FileReader(in+".txt"));
		BufferedReader fi = new BufferedReader(new FileReader(in+".txt"));
		FileOutputStream fis = new FileOutputStream("example.txt");
		BufferedOutputStream outs = new BufferedOutputStream(fis);
		FileOutputStream fiss = new FileOutputStream(out+".txt");
		BufferedOutputStream outss = new BufferedOutputStream(fiss);
		
		File t = new File("example.txt");
		FileOutputStream fos = new FileOutputStream(t);
		PrintWriter oos = new PrintWriter(fos);
		
//		FileWriter fis = new FileWriter(in+".txt",true);
		
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(out+".txt")));
		int count = 0;
		int p = 0;
		String line;
		String setter;
		StringBuilder Word = new StringBuilder();
		StringBuilder lines = new StringBuilder();
		StringBuffer strings = new StringBuffer();
		String bitstring;
		//Scanner scanner1= new Scanner(h); 
		while((line = h.readLine())!=null)
		{
			count++;
		}

		while((line = fi.readLine())!=null)
		{
			if(line.trim().isEmpty())
			{
//				dos.writeBytes(o.get("/n"));
				strings.append(o.get("/n"));
				p++;
			}
			else
			{
			for(int g=0; g<line.length();g++)
			{
			if(Character.isWhitespace(line.charAt(g)))
			{
				if(o.containsKey(Word.toString()))
				{
//				dos.writeBytes(o.get(Word.toString()));
				strings.append(o.get(Word.toString()));
				}
				else
				{
					oos.write(Word.toString());
//					dos.writeUTF(Word.toString());
				}
//				dos.writeBytes(o.get("spaces"));
				strings.append(o.get("spaces"));
				Word = new StringBuilder();
			}
			else
			{
				Word.append(line.charAt(g));
			}
//			fis.write(" ");e
			if(g==line.length()-1)
			{
				if(o.containsKey(Word.toString()))
				{
//				dos.writeBytes(o.get(Word.toString()));
				strings.append(o.get(Word.toString()));
				}
				else
				{
					oos.write(Word.toString());
				}
				Word = new StringBuilder();
			}
			}
			
			if(p<count-1)
			{
//			dos.writeBytes(o.get("/n"));
			strings.append(o.get("/n"));
			p++;
			}
			}
		}
		setter = o.get("THE");
//		int I = Integer.parseInt(strings.toString(),2);
//		dos.writeUTF(Integer.toBinaryString(I));
		
////////////////////////////////////////////////////////////////////
		StringBuilder op= new StringBuilder();
		oos.write(strings.toString());
		System.out.println(strings.toString());
		int n = 0;
		List<Byte> byteList = new ArrayList<Byte>();
		
		for(int q = 0; q<(strings.length()/8);q++)
		{
		String part = strings.substring(q*8,(q+1)*8);
		byte c = (byte)Integer.parseInt(part,2);
		byteList.add(c);
		}
		Byte[] bval = byteList.toArray(new Byte[]{});
		for(byte c: bval)
		{
		fiss.write(c);
		}
		String last = strings.substring(strings.length()-(strings.length()-(int)(strings.length()/16)*16),strings.length());
		while(last.length()!=16)
		{
			last = last+setter.charAt(n);
			n++;
		}
//		byteList.add((char)Integer.parseInt(last,2));
//		Object[] bval = byteList.toArray();
//		for(Object c: bval )
//		{
//		System.out.println(c);
		outss.write((char)Integer.parseInt(last,2));
		
///////////////////////////////////////////////////////////////////////////////		
		
//		int sLen = strings.length();
//		System.out.println(sLen);
//		byte[] bval = new byte[(sLen = Byte.SIZE -1)/Byte.SIZE];
//		char c;
//		for(int q = 0; q<sLen; q++)
//		{
//			System.out.println(q);
//		if((c=strings.charAt(q))=='1')
//			bval[q/Byte.SIZE] = (byte)(bval[q/Byte.SIZE]|(0x80>>(q%Byte.SIZE)));
//		if (c!='0')
//			throw new IllegalArgumentException();
//		fiss.write(bval);		
		
		
//		// CONVERTING !!!!
//		String set;
//		for(int y= 0; y<strings.length();y++)
//		{
//			lines.append(strings.charAt(y));
//			if(lines.length()==16)
//			{
//			byte[] bval = new BigInteger(lines.toString(),2).toByteArray();
//			System.out.println(Integer.parseInt(lines.toString(),2));
//			fiss.write(bval);
			//bval = null;
//			lines = new StringBuilder();
//			}
//			if(y==strings.length()-1)
//				{
//				set = lines.toString();
//				System.out.println(set);
//				while(set.length()<16)
//				{
//					set= "0"+set;
//				}
//				byte[] bval = new BigInteger(set,2).toByteArray();
//				System.out.println(set);
//				fiss.write(bval);
				
//				}
	
//		}
//			char c = (char) Integer.parseInt(lines.toString(),2);
////			System.out.println("and "+ (char) Integer.parseInt("10011001",2));
//			set=0;
////			System.out.print(op.toString());
//			//Thread.sleep(3000);
//			if(Integer.parseInt(lines.toString(),2)>= 127||Integer.parseInt(lines.toString(),2) == 44||Integer.parseInt(lines.toString(),2) == 0||Integer.parseInt(lines.toString(),2)==1||Integer.parseInt(lines.toString(),2)==2||Integer.parseInt(lines.toString(),2)==3||Integer.parseInt(lines.toString(),2)==4||Integer.parseInt(lines.toString(),2)==5||Integer.parseInt(lines.toString(),2)==6||Integer.parseInt(lines.toString(),2)==7||Integer.parseInt(lines.toString(),2)==8||Integer.parseInt(lines.toString(),2)==9||Integer.parseInt(lines.toString(),2)==10||Integer.parseInt(lines.toString(),2)==11||Integer.parseInt(lines.toString(),2)==12||Integer.parseInt(lines.toString(),2)==13||Integer.parseInt(lines.toString(),2)==14||Integer.parseInt(lines.toString(),2)==15||Integer.parseInt(lines.toString(),2)==16||Integer.parseInt(lines.toString(),2)==17||Integer.parseInt(lines.toString(),2)==18||Integer.parseInt(lines.toString(),2)==19||Integer.parseInt(lines.toString(),2)==20||Integer.parseInt(lines.toString(),2)==21||Integer.parseInt(lines.toString(),2)==22||Integer.parseInt(lines.toString(),2)==23||Integer.parseInt(lines.toString(),2)==24||Integer.parseInt(lines.toString(),2)==25||Integer.parseInt(lines.toString(),2)==26||Integer.parseInt(lines.toString(),2)==27||Integer.parseInt(lines.toString(),2)==28||Integer.parseInt(lines.toString(),2)==29||Integer.parseInt(lines.toString(),2)==30||Integer.parseInt(lines.toString(),2)==31||Integer.parseInt(lines.toString(),2)==48||Integer.parseInt(lines.toString(),2)==49||Integer.parseInt(lines.toString(),2)==50||Integer.parseInt(lines.toString(),2)==51||Integer.parseInt(lines.toString(),2)==52||Integer.parseInt(lines.toString(),2)==53||Integer.parseInt(lines.toString(),2)==54||Integer.parseInt(lines.toString(),2)==55||Integer.parseInt(lines.toString(),2)==56||Integer.parseInt(lines.toString(),2)==57)
////			if(Character.isDefined(c))
//			{
//					Sytem.out.println(lines);
//				op.append(Integer.parseInt(lines.toString(),2)+",");
//				lines = new StringBuilder();
//			}
//			else
//			{
//				System.out.println(lines);
//				op.append(String.valueOf(c)+",");
//				lines = new StringBuilder();
//			}
//			}
//			if(y==strings.length()-1)
//			{
//				System.out.println(lines);
//				//char c = (char)Integer.parseInt(lines.toString(),2);
//				op.append(lines.toString());
//			}
//			set++;
//		}
//		oos.write(op.toString());

		
		
		
		
		
		
		
		
		
		
		//		byte[] bytes = strings.toString().getBytes();
//		fis.write(bytes);
//		fis.close();
//		outs.write(bytes);
//		for(Map.Entry<String, String>y:o.entrySet())
//		{
//			System.out.println(y.getKey()+" "+y.getValue());
//		}
		outss.close();
		fis.close();
		dos.close();
		oos.close();
//		fi.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
