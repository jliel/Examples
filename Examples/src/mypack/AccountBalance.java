package mypack;

import balances.Balance;

class AccountBalance {
	
	public static void main(String args[]) {
		Balance[] current = new Balance[3];
		current[0] = new Balance("Juan", 123.23);
		current[1] = new Balance("Pedro", 334.78);
		current[2] = new Balance("Mario", 7783.2);
		
		for(int i=0; i<3; i++) {
			current[i].show();
		}
	}
	
}
