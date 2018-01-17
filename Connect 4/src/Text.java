
public class Text {
	private int xPosition; // The x,y coordinates of its start
	private int yPosition;
	private String text; // The text to display
	private String color; // The color of the line

	// Create a new text string
	public Text(int xPosition, int yPosition, String text, String color) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.text = text;
		this.color = color;
		draw();
	}

	// Change a text string
	public void changeText(String newText, String newColor) {
		erase();
		this.text = newText;
		this.color = newColor;
		draw();
	}

	// Move the text to a new position.
	public void moveTo(int newX, int newY) {
		erase();
		xPosition = newX;
		yPosition = newY;
		draw();
	}

	// Move the line by an amount.
	public void move(int deltaX, int deltaY) {
		erase();
		xPosition = xPosition + deltaX;
		yPosition = yPosition + deltaY;
		draw();
	}

	// Change the color.
	// Valid colors are "red","yellow","blue","green","magenta" and "black".
	public void changeColor(String newColor) {
		erase();
		color = newColor;
		draw();
	}

	// Draw the line with current specifications on screen.
	private void draw() {
		Canvas canvas = Canvas.getCanvas();
		canvas.setForegroundColour(color);
		canvas.drawString(text, xPosition, yPosition);
		canvas.wait(50);
	}

	// Erase the line on screen.
	void erase() {
		Canvas canvas = Canvas.getCanvas();
		canvas.eraseString(text, xPosition, yPosition);
	}
}
