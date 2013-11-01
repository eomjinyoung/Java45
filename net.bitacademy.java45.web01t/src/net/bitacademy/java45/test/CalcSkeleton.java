package net.bitacademy.java45.test;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalcSkeleton {

	public static void main(String[] args) throws Exception {
		CalculatorImpl calc = new CalculatorImpl();
		
		ServerSocket ss = new ServerSocket(8989);
		Socket s = null;
		Scanner in = null;
		PrintStream out = null;
		String command = null;
		int a = 0, b = 0, result = 0;
		
		while(true) {
			try {
				s = ss.accept();
		
				in = new Scanner(s.getInputStream());
				out = new PrintStream(s.getOutputStream());
				
				command = in.nextLine();
				a = Integer.parseInt(in.nextLine());
				b = Integer.parseInt(in.nextLine());
				
				if (command.equals("plus")) {
					result = calc.plus(a, b);
				} else if (command.equals("minus")) {
					result = calc.minus(a, b);
				}
				
				out.println(result);
				out.close();
				in.close();
				s.close();
			} catch(Exception e) {}
		}
	}

}











