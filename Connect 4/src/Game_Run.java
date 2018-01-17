
import java.util.Scanner;

public class Game_Run {
	static Scanner reader = new Scanner(System.in);

	static void Start() {
		Square s1 = new Square(0, 0, 620, "blue");
		Square s2 = new Square(-3, 600, 623, "blue");
		Text t1 = new Text(55, 675, "1             2            3             4            5            6            7",
				"magenta");
		Text t2 = new Text(50, 40, "Welcome to Itai & Maya's connect four game!! Have fun :)", "magenta");
		int n = 7;
		Circle[][] board = new Circle[n][n];
		Game_Service.EmptyBoard(board);
		String win = "white", turn = "red";
		while (win == "white" && Game_Service.EmptyCheck(board)) {
			Text t3 = new Text(740, 80, "player, it's your turn", "blue");
			Text t4 = new Text(690, 80, "", "red");
			if (turn == "red") {
				t4.changeText("red", "red");
				System.out.println("red player please enter column:");
			}
			if (turn == "black") {
				t4.changeText("black", "black");
				System.out.println("black player please enter column:");
			}
			int col = reader.nextInt() - 1;

			while (col < 0 || col > n - 1 || Game_Service.IsOpen(board, col) == -1) {
				Text t5 = new Text(635, 120, "Column is full or invalid, enter new one", "blue");
				// Text t6= new Text (650, 140, "��� ��� ����� ����� ���� ��!", "blue");
				col = reader.nextInt() - 1;
				t5.erase(); // t6.erase();
			}

			int row = Game_Service.IsOpen(board, col);
			board[col][row].changeColor(turn);
			win = Game_Service.Win(board);
			turn = Game_Service.ChangeTurn(turn);
			t4.erase();
			t3.erase();

		}
		Text t7 = new Text(630, 300, "", "magenta");
		Text t8 = new Text(650, 300, "", "red");
		if (win == "white") {
			t7.changeText("it's a tie!", "magenta");
		} else {
			t7.changeText("             player won", "magenta");
			if (win == "red")
				t8.changeText("red", "red");
			if (win == "black")
				t8.changeText("black", "black");
		}
		int again = 0;
		System.out.println();
		Text t9 = new Text(665, 350, "hit [1] to play again", "blue");
		Text t10 = new Text(715, 375, "hit [2] to exit", "blue");
		again = reader.nextInt();

		while (!(again == 1 || again == 2)) {
			Text t11 = new Text(695, 410, "invaild number", "blue");
			Text t12 = new Text(725, 435, "please enter valid number!", "blue");
			again = reader.nextInt();
			t11.erase();
			t12.erase();
		}

		t7.erase();
		t8.erase();
		t9.erase();
		t10.erase();
		if (again == 1) {
			Start();
		}
		if (again == 2) {
			Text t13 = new Text(680, 450, "Bye Bye :)", "blue");
		}
	}

	public static void main(String[] args) {

		Start();

	}
}
