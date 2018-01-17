import java.util.*;
/***
 * 
 * @author Maya and Itai
 *
 */
public class FourInARow {
	static Scanner reader= new Scanner (System.in);
	static int win (int[][]a)
	{
		int win=0;
		for (int i=0; i<a.length-3; i++)
		{
			for (int j=0; j<a[i].length; j++)
			{
				if(a[i][j]==a[i+1][j]&& a[i+1][j]==a[i+2][j] && a[i+2][j]==a[i+3][j] && a[i][j]!=0) win=a[i][j];
			}
		}
		for (int i=0; i<a.length; i++)
		{
			for (int j=0; j<a[i].length-3; j++)
			{
				if(a[i][j]==a[i][j+1]&& a[i][j+1]==a[i][j+2] && a[i][j+2]==a[i][j+3] && a[i][j]!=0) win=a[i][j];
			}
		}
		for (int i=0; i<a.length-3; i++)
		{
			for (int j=0; j<a[i].length-3; j++)
			{
				if(a[i][j]==a[i+1][j+1]&& a[i+1][j+1]==a[i+2][j+2] && a[i+2][j+2]==a[i+3][j+3] && a[i][j]!=0) win=a[i][j];
			}
		}
		for (int i=3; i<a.length ; i++)
		{
			for (int j=0; j<a[i].length-3 ; j++)
			{
				if(a[i][j]==a[i-1][j+1]&& a[i-1][j+1]==a[i-2][j+2] && a[i-2][j+2]==a[i-3][j+3] && a[i][j]!=0) win=a[i][j];
			}
		}
	return win;
	}
	static int isopen (int[][]a, int col)
	{
		int rowNum=-1;
		int row=a.length-1;
		while (row>=0 && rowNum==-1)
		{
			if (a[row][col]==0) rowNum=row;
			else row--;
		}
		return rowNum;
	}
	static void meapes (int[][] a)
	{
		for (int i=0; i<a.length; i++)
		{
			for (int j=0; j<a[i].length; j++)
			{
				a[i][j]=0;
			}
		}
	}
	static int changeturn (int turn)
	{
		if (turn==1) turn=2;
		else if(turn==2) turn=1;
		return turn;
	}
	static void printboard (int[][]a)
	{
		for (int i=0; i<a.length; i++)
		{
			for (int j=0; j<a[i].length; j++)
			{
				System.out.print(a[i][j]+" ");
			}
		System.out.println (" ");
		}
	}
	public static void main(String[] args) {
		
	System.out.println ("Welcome to Itai & Maya's connect four game!! Have fun :)");
	int win=0;
	int[][] board= new int[6][7];
	meapes (board);
	int turn=1;
	while (win==0)
	{
		printboard(board);
		System.out.println ("Player #"+turn+" -it's your turn");
		System.out.println ("Choose your column");
		int col=reader.nextInt()-1;
	while (isopen (board, col)==-1 || col<0 || col>7)
	{
		System.out.print ("Column is full or invalid, enter new one");
		col= reader.nextInt()-1;
	}
		int row=isopen(board, col);
		board[row][col]=turn;
		win=win(board);	
		turn=changeturn(turn);
	}
	printboard(board);
	System.out.println ("Congratulations!!! player "+win+" won the game!! :D");
		}

}
