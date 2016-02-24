import java.io.File;
import java.util.Scanner;

//Jack Hui Project 2
//CSC 22000
public class Huffmancoding {
public static void main(String arg[]){
	
		System.out.println("If you want to create Huffman Tree press T");
		System.out.println("If you want to create Encode press E");
		System.out.println("If you want to create Decode press D");
		System.out.println("If you want to quit press q");
		Scanner inputs = new Scanner(System.in);
		String input = inputs.nextLine();
		while(!input.equals("q"))
		{
		if(input.equals("Q"))
		{
			break;
		}
		if(input.equals("T")||input.equals("t"))
		{
		long t5 = System.currentTimeMillis();
		System.out.println("Enter the name of the input file");
		Scanner inf = new Scanner(System.in);
		String in = inf.nextLine();
		System.out.println("Enter the name of the output file");
		Scanner outf = new Scanner(System.in);
		String out = outf.nextLine();
		//long t5 = System.currentTimeMillis();
		Frequence freq = new Frequence(in,out);
		long t6 = System.currentTimeMillis();
		System.out.println("run time = " + ((t6-t5)/1000) + "seconds");
		}
	
	
		if(input.equals("E")||input.equals("e"))
		{
		long t1 = System.currentTimeMillis();	
		System.out.println("Enter the name of the input file for encoding");
		Scanner inf = new Scanner(System.in);
		String in = inf.nextLine();
		System.out.println("Enter the name of the output file for encoding");
		Scanner outf = new Scanner(System.in);
		String out = outf.nextLine();
		System.out.println("Enter the name of the huffman tree file for encoding");
		Scanner huffs = new Scanner(System.in);
		String huff = huffs.nextLine();
		Encoding encode = new Encoding(in,out,huff);
		long t2 = System.currentTimeMillis();
		System.out.println("run time = " + ((t2-t1)/1000)+ "seconds");
		}
	
	
		if(input.equals("D")||input.equals("d"))
		{
		long t3 = System.currentTimeMillis();	
		System.out.println("Enter the name of the input file for decoding");
		Scanner inf = new Scanner(System.in);
		String in = inf.nextLine();
		System.out.println("Enter the name of the output file for decoding");
		Scanner outf = new Scanner(System.in);
		String out = outf.nextLine();
		System.out.println("Enter the name of the huffman tree file for decoding");
		Scanner huffs = new Scanner(System.in);
		String huff = huffs.nextLine();
		Decoding decode = new Decoding(in,out,huff);
		long t4 = System.currentTimeMillis();
		System.out.println("run time = " + ((t4-t3)/1000) + "seconds");
		}
		
		if(!input.equals("T")||!input.equals("t")||!input.equals("E")||!input.equals("e")||!input.equals("D")||!input.equals("d"))	
		{
			System.out.println();
			System.out.println("If you want to create Huffman Tree press T");
			System.out.println("If you want to create Encode press E");
			System.out.println("If you want to create Decode press D");
			System.out.println("If you want to quit press q");
			inputs = new Scanner(System.in);
			input = inputs.nextLine();
		}
	}
}
}