package net.bitacademy.java45.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class HttpClientTest {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost", 9999);
		PrintStream out = new PrintStream(s.getOutputStream());
		BufferedReader in = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		
		out.println("GET /web01/book/list HTTP/1.1");
		out.println("Host: www.naver.com");
		out.println("User-Agent: Mozilla/5.0 (Windows NT 6.1) "
				+ "AppleWebKit/537.36 (KHTML, like Gecko) "
				+ "Chrome/30.0.1599.101 Safari/537.36");
		out.println();
		
		String line;
		while((line = in.readLine()) != null) {
			System.out.println(line);
		}
		
		out.close();
		in.close();
		s.close();
	}

}














