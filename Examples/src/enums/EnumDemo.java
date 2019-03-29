package enums;

import java.util.Iterator;

enum Apple {
	Jonahtan(10), GoldenDel, RedDel(15), Winesap(8), Cortand();
	
	private int price;
	
	Apple(int price) {
		this.price = price;
	}
	
	Apple() {
		price = -1;
	}
	
	public int getPrice() {
		return price;
	}
}

public class EnumDemo {
	public static void main(String args[]) {
		Apple ap, ap2, ap3;
		
		Apple allapples[] = Apple.values();
		
		for (Apple apple : allapples) {
			System.out.println(apple);
		}
		
		System.out.println("price of jonahtan is: " + Apple.Jonahtan.getPrice());
		
		System.out.println("Here are all apples constants" + 
							"and their ordinal values: ");
		for (Apple apple : Apple.values()) {
			System.out.println(apple + " " + apple.ordinal());
		}
		
		ap = Apple.RedDel;
		ap2 = Apple.GoldenDel;
		ap3 = Apple.RedDel;
		
		if(ap.compareTo(ap2) < 0) {
			System.out.println(ap + " comes before " + ap2);
		}
		if(ap.compareTo(ap2) > 0) {
			System.out.println(ap2 + " comes before " + ap);
		}
		if(ap.compareTo(ap3) == 0) {
			System.out.println(ap + " equals " + ap3);
		}
		if(ap.equals(ap2)) {
			System.out.println("Error");
		}
		if(ap.equals(ap3)) {
			System.out.println(ap + " equals " + ap3);
		}
		if(ap == ap3) {
			System.out.println(ap + " == " + ap3);
		}
	}
}
