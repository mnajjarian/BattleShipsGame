
public class Main {

	public static void main(String[] args) {
		BattleShipGame game = new BattleShipGame();
		

		System.out.println("**** Welcome to Battle Ships game ****");
		System.out.println();
		System.out.println("Right now, the sea is empty.");
		System.out.println();
		drawMap();
		game.humanShip();
		game.computerShip();
		game.Battle();
	}
		public static void drawMap() {
		String [][] ocean = new String [10][10];
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
		System.out.println();
	}

}
