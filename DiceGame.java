import java.util.*;

public class DiceGame {
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		DicePair dice = new DicePair(); 
		Coin tossCoin = new Coin();	
		Player player1 = new Player("Natasha");
		Player player2 = new Player("Elena");
		boolean inPlay = true;
		Player first, second;

		while(inPlay)
		{
			tossCoin.flip();
			if(tossCoin.isHeads()) {
				System.out.println(player1.getName()+" goes first");
				first = player1;
				second = player2;
			} else {
				System.out.println(player2.getName()+" goes first");
				first = player2;
				second = player1;
			}

			first.setPoints(dice.roll());
			second.setPoints(dice.roll());
			System.out.println("\tFirst roll:\t"+first.getPoints()+"\n\tSecond Roll:\t"+ second.getPoints());

			updateScores(first, second);
			inPlay = keepPlaying(scan);
		}

		System.out.println("HERE ARE THE RESULTS:");
		System.out.println(player1);
		System.out.println(player2);
	}

	public static boolean keepPlaying(Scanner scan)
	{
		System.out.println("WOULD YOU LIKE TO PLAY AGAIN? (y or n)");
		String input = scan.next();
		if(input.equals("y"))
			return true;
		return false;
	}

	public static void updateScores (Player first, Player second)
	{
		int result1 = first.getPoints();
		int result2 = second.getPoints();
		if(result1>result2) {
			System.out.println(">> "+first.getName()+" wins!");
			first.won();
			second.lost();
		} else if(result2>result1) {
			System.out.println(">> "+second.getName()+" wins!");
			first.lost();
			second.won();
		} else {
			System.out.println(">> It's a tie!"); 
			first.won(); 
			second.won();
		}	
	}
}
