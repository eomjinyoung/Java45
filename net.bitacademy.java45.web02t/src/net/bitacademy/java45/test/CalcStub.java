package net.bitacademy.java45.test;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcStub implements Calculator{
	String host;
	int port;
	
	public CalcStub(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	public int plus(int a, int b) {
		Socket s = null;
		Scanner in = null;
		PrintStream out = null;
		
		try {
			s = new Socket(this.host, this.port);
			in = new Scanner(s.getInputStream());
			out = new PrintStream(s.getOutputStream());
			
			out.println("plus");
			out.println(a);
			out.println(b);
			
			int result = Integer.parseInt(in.nextLine());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {out.close();} catch (Exception e){}
			try {in.close();} catch (Exception e){}
			try {s.close();} catch (Exception e){}
		}
	}
	
	public int minus(int a, int b) {
		Socket s = null;
		Scanner in = null;
		PrintStream out = null;
		
		try {
			s = new Socket(this.host, this.port);
			in = new Scanner(s.getInputStream());
			out = new PrintStream(s.getOutputStream());
			
			out.println("minus");
			out.println(a);
			out.println(b);
			
			int result = Integer.parseInt(in.nextLine());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {out.close();} catch (Exception e){}
			try {in.close();} catch (Exception e){}
			try {s.close();} catch (Exception e){}
		}
	}
}













