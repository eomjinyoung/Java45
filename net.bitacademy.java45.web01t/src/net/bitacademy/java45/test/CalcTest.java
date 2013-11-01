package net.bitacademy.java45.test;

public class CalcTest {

	public static void main(String[] args) {
		CalcStub proxy = new CalcStub("localhost", 8989);
		System.out.println(proxy.plus(10, 20));
	}

}
