
public class Game_Service {

	// board[col][row]

	/**
	 * @param: matrix
	 * @return the color of the winner
	 */
	static String Win(Circle[][] a) {
		String win = "white";
		for (int i = 0; i < a.length - 3; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j].color == a[i + 1][j].color && a[i + 1][j].color == a[i + 2][j].color
						&& a[i + 2][j].color == a[i + 3][j].color && a[i][j].color != "white")
					win = a[i][j].color;
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length - 3; j++) {
				if (a[i][j].color == a[i][j + 1].color && a[i][j + 1].color == a[i][j + 2].color
						&& a[i][j + 2].color == a[i][j + 3].color && a[i][j].color != "white")
					win = a[i][j].color;
			}
		}
		for (int i = 0; i < a.length - 3; i++) {
			for (int j = 0; j < a[i].length - 3; j++) {
				if (a[i][j].color == a[i + 1][j + 1].color && a[i + 1][j + 1].color == a[i + 2][j + 2].color
						&& a[i + 2][j + 2].color == a[i + 3][j + 3].color && a[i][j].color != "white")
					win = a[i][j].color;
			}
		}
		for (int i = 3; i < a.length; i++) {
			for (int j = 0; j < a[i].length - 3; j++) {
				if (a[i][j].color == a[i - 1][j + 1].color && a[i - 1][j + 1].color == a[i - 2][j + 2].color
						&& a[i - 2][j + 2].color == a[i - 3][j + 3].color && a[i][j].color != "white")
					win = a[i][j].color;
			}
		}
		return win;
	}

	// return max row available in col
	static int IsOpen(Circle[][] a, int col) {
		int rowNum = -1;
		int row = a.length - 1;
		while (row >= 0 && rowNum == -1) {
			if (a[col][row].color == "white")
				rowNum = row;
			else
				row--;
		}
		return rowNum;
	}

	// return white circels in the canvas
	static void EmptyBoard(Circle[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = new Circle(85 * i + 60, 85 * j + 100, 20, "white");
			}
		}
	}

	// return true if all the circles in the highest row are white
	static boolean EmptyCheck(Circle[][] a) {
		int counter = 0;
		for (int i = 1; i < a.length; i++) {
			if (!(a[i][0].color == "white"))
				counter++;
		}
		if (counter == a.length - 1 && !(a[0][0].color == "white"))
			return false;
		else
			return true;
	}

	// return second player color
	static String ChangeTurn(String turn) {
		if (turn == "red")
			turn = "black";
		else if (turn == "black")
			turn = "red";
		return turn;
	}

}
