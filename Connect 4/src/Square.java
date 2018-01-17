
public class Square {
	private int size; // The side of a side of the square
	private int xPosition; // The x,y coordinates of its top left corner
	private int yPosition;
	public String color; // The color of the square

	// Create a new square
	public Square(int xPosition, int yPosition, int size, String color) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.size = size;
		this.color = color;
		draw();
	}

	// Move the square to a new position.
	public void moveTo(int newX, int newY) {
		erase();
		xPosition = newX;
		yPosition = newY;
		draw();
	}

	// Move the square by an amount.
	public void move(int deltaX, int deltaY) {
		erase();
		xPosition = xPosition + deltaX;
		yPosition = yPosition + deltaY;
		draw();
	}

	// Change the side to the new side.
	public void changeSize(int newSize) {
		erase();
		size = newSize;
		draw();
	}

	// Change the color.
	// Valid colors are "red","yellow","blue","green","magenta" and "black".
	public void changeColor(String newColor) {
		erase();
		color = newColor;
		draw();
	}

	// Draw the square with current specifications on screen.
	private void draw() {
		Canvas canvas = Canvas.getCanvas();
		canvas.setForegroundColour(color);
		canvas.fill(new java.awt.Rectangle(xPosition, yPosition, size, size));
		canvas.wait(5);
	}

	// Erase the square on screen.
	private void erase() {
		Canvas canvas = Canvas.getCanvas();
		canvas.erase(new java.awt.Rectangle(xPosition, yPosition, size, size));
	}
}
