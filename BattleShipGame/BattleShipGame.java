import java.util.Random;
import java.util.Scanner;

public class BattleShipGame {
	private static String [][] ocean = new String [10][10];
	private static String [][] ocean2 = new String [10][10];
    private static Random random = new Random();
    Scanner input = new Scanner(System.in);
	private Scanner input2;
    
    public BattleShipGame() {
    	
    }
    public void humanShip() {
    	System.out.println("Deploy your ships:");
    	for(int i = 1; i <= ocean.length/2; i++) {
    		System.out.print("Enter X coordinate for your " + i + ". ship: ");
    		int x = input.nextInt();
    		System.out.print("Enter Y coordinate for your " + i + ". ship: ");
    		int y = input.nextInt();
    		if(ocean[x][y] != "@") {
    			ocean[x][y] = "@";
    		} else {
    			input.next();
    		}
    	}
    	OceanMap1();
    }
    public void computerShip() {
    	System.out.println("Computer is deploying ships");
		for(int i = 1; i <= 5; i++) {
			int x = random.nextInt(10);
			int y = random.nextInt(10);
				if(ocean2[x][y] != "@") {
					ocean2[x][y] = "@";
				} else {
					y = random.nextInt(10);
					ocean2[x][y] = "@";
			System.out.println(i + ". ship DEPLOYED.");
		}
		}
		System.out.println("-------------------------");
		System.out.println();
		System.out.println("  0123456789 ");
		for(int row = 0; row < ocean2.length; row++) {
			System.out.print(row + "|");
			for(int col = 0; col < ocean2[row].length; col++) {
				if(ocean2[row][col] == null) {
					System.out.print(" ");
				} else {
					System.out.print(ocean2[row][col]);
				}
			}
			System.out.println("|" + row);
		}
		System.out.println("  0123456789 ");
		Battle();
    }
    public void Battle() {
		input2 = new Scanner(System.in);
		while(true) {
		System.out.println("YOUR TURN");
		System.out.print("Enter x cordinate: ");
		int x = input2.nextInt();
		System.out.print("Enter y cordinate: ");
		int y = input2.nextInt();
		if(ocean2[x][y] != "@") {
			System.out.println("Sorry, you missed");
			ocean2[x][y] = "-";
			OceanMap2();
		} else {
			System.out.println("Boom! You sunk the ship!");
			ocean2[x][y] = "!";
			OceanMap2();
		}
		if(ocean[x][y] == "@") {
			System.out.println("Oh no, you sunk your own ship :(");
			ocean[x][y] = "X";
			OceanMap1();
		}
		System.out.println("COMPUTER'S TURN");
		int x1 = random.nextInt(10);
		int y1 = random.nextInt(10);
		if(ocean[x1][y1] == "@") {
			System.out.println("The Computer sunk one of your ships!");
			ocean[x1][y1] = "x";
			OceanMap1();
		}
		if(ocean2[x1][y1] == "@") {
			System.out.println("The Computer sunk one of its own ships");
			ocean2[x1][y1] = "!";
			OceanMap2();
		} else {
			System.out.println("Computer missed");
		}
	}
	}
    public void OceanMap2() {
    	System.out.println();
	System.out.println("  0123456789 ");
	for(int row = 0; row < ocean2.length; row++) {
		System.out.print(row + "|");
		for(int col = 0; col < ocean2[row].length; col++) {
			if(ocean2[row][col] == null) {
					System.out.print(" ");
				} else {
					System.out.print(ocean2[row][col]);
				}
			}
			System.out.println("|" + row);
		}
		System.out.println("  0123456789 ");
    }
    public void OceanMap1() {
    	System.out.println();
    	System.out.println("  0123456789 ");
    	for(int row = 0; row < ocean.length; row++) {
    		System.out.print(row + "|");
		for(int col = 0; col < ocean[row].length; col++) {
			if(ocean[row][col] == null) {
					System.out.print(" ");
				} else {
					System.out.print(ocean[row][col]);
				}
			}
			System.out.println("|" + row);
		}
		System.out.println("  0123456789 ");
    }
}
