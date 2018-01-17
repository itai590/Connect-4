
public class Circle {
	private double radius; // Radius of the circle
	private double xCenter, yCenter; // The x,y coordinates of the center
	String color; // The color of the circle

	// Create a new circle
	public Circle(int xCenter, int yCenter, int radius, String color) {
		this.radius = radius;
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		this.color = color;
		draw();
	}

	// Move the circle to a new position.
	public void moveTo(int newX, int newY) {
		erase();
		xCenter = newX;
		yCenter = newY;
		draw();
	}

	// Move the circle by an amount.
	public void move(int deltaX, int deltaY) {
		erase();
		xCenter = xCenter + deltaX;
		yCenter = yCenter + deltaY;
		draw();
	}

	// Change the size to the new size.
	public void changeSize(int newRadius) {
		erase();
		radius = newRadius;
		draw();
	}

	// Change the color.
	// Valid colors are "red","yellow","blue","green","magenta" and "black".
	public void changeColor(String newColor) {
		erase();
		color = newColor;
		draw();
	}

	// Draw the circle with current specifications on screen.
	private void draw() {
		Canvas canvas = Canvas.getCanvas();
		canvas.setForegroundColour(color);
		canvas.fill(new java.awt.geom.Ellipse2D.Double(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius));
		canvas.wait(5);
	}

	// Erase the circle on screen.
	private void erase() {
		Canvas canvas = Canvas.getCanvas();
		canvas.erase(new java.awt.geom.Ellipse2D.Double(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius));
	}
}
