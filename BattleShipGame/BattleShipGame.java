import java.util.Random;
import java.util.Scanner;

public class BattleShipGame {
	private static String [][] ocean = new String [10][10];
	private static String [][] tempOcean = new String [10][10];
    private static Random random = new Random();
    private int humanShips = 5;
	private int computerShips = 5;
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
    			tempOcean[x][y] = "@";
    		} else {
    			input.next();
    		}
    	}
    	oceanMap();
    }
    public void computerShip() {
    	System.out.println();
    	System.out.println("Computer is deploying ships");
		for(int i = 1; i <= 5; i++) {
			System.out.println(i + ". ship DEPLOYED.");
			int x = random.nextInt(10);
			int y = random.nextInt(10);
				if(tempOcean[x][y] != "@" && tempOcean[x][y] != "#") {
					tempOcean[x][y] = "#";
				} else {
					y = random.nextInt(10);
					tempOcean[x][y] = "#";
		}
		}
		System.out.println("-------------------------");
		System.out.println();
		
    }
    public void Battle() {
		input2 = new Scanner(System.in);
		while(true) {
		System.out.println("YOUR TURN");
		System.out.print("Enter x cordinate: ");
		int x = input2.nextInt();
		System.out.print("Enter y cordinate: ");
		int y = input2.nextInt();
		if(tempOcean[x][y] != "#" && ocean[x][y] != "@") {
			System.out.println("Sorry, you missed");
			ocean[x][y] = "-";
			oceanMap();
			result();
		} else if(tempOcean[x][y] == "#") {
			System.out.println("Boom! You sunk the ship!");
			computerShips--;
			ocean[x][y] = "!";
			oceanMap();
			result();
			if(humanShips <= 0 || computerShips <= 0) {
				break;
			}
		}
		if(ocean[x][y] == "@") {
			System.out.println("Oh no, you sunk your own ship :(");
			humanShips--;
			ocean[x][y] = "x";
			oceanMap();
			result();
			if(humanShips <= 0 || computerShips <= 0) {
				break;
			}
		}
		System.out.println("COMPUTER'S TURN");
		int x1 = random.nextInt(10);
		int y1 = random.nextInt(10);
		if(tempOcean[x][y] == "-" || ocean[x][y] == "x") {
			y1 = random.nextInt();
		}else
		if(ocean[x1][y1] == "@") {
			System.out.println("The Computer sunk one of your ships!");
			humanShips--;
			ocean[x1][y1] = "x";
			oceanMap();
			result();
			if(humanShips <= 0 || computerShips <= 0) {
				break;
			}
		} else if(tempOcean[x1][y1] == "#") {
			System.out.println("The Computer sunk one of its own ships");
			computerShips--;
			ocean[x1][y1] = "!";
			oceanMap();
			result();
			if(humanShips <= 0 || computerShips <= 0) {
				break;
			}
			
		} else {
			System.out.println("Computer missed");
			tempOcean[x][y] = "-";
			oceanMap();
			result();
			}
			
		}
		oceanMap();
	}
    public void result() {
    	System.out.println("Your ships: " + humanShips + " | " + "Computer ships: " + computerShips);
		if(computerShips <= 0) {
			System.out.println("Hooray! You win the battle :)");
		} else if(humanShips <= 0) {
			System.out.println("Sorry! You are loose :(");
		} else {
			System.out.println("---------------------------------------------------------");
		}
    }
    public void oceanMap() {
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
