
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Canvas implements MouseListener, KeyListener {
	private static int width = 950;
	private static int height = 700;
	private static Canvas canvasSingleton;
	private JFrame frame;
	private CanvasPane canvas;
	private Graphics2D graphic;
	private Color backgroundColour;
	public static Image canvasImage;
	public static Image Start, Place;
	public static String Str1, Str2;
	public static int MX, MY, Flag = 0, Flag1 = 0, Key, FlagKey = 0;

	// Create canvas singleton object.
	static Canvas getCanvas() {
		if (canvasSingleton == null)
			canvasSingleton = new Canvas("Connect Four- MI Games BAAM", width, height, Color.green);
		canvasSingleton.setVisible(true);

		return canvasSingleton;
	}

	// Mouse Pressed event
	public void mousePressed(MouseEvent e) {
		MX = e.getX() - 10;
		MY = e.getY() - 30;
		Str1 = "" + MX;
		Str2 = "" + MY;

		Square s1 = new Square(0, 0, 13, "white");
		Square s2 = new Square(10, 0, 13, "white");
		Square s3 = new Square(20, 0, 13, "white");
		Square s4 = new Square(30, 0, 13, "white");
		Square s5 = new Square(40, 0, 13, "white");
		Square s6 = new Square(50, 0, 13, "white");
		Square s7 = new Square(60, 0, 13, "white");
		Square s8 = new Square(70, 0, 13, "white");
		Text t1 = new Text(5, 12, Str1 + ":" + Str2, "black");
		Flag = 1;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		MX = e.getX() - 10;
		MY = e.getY() - 30;
		Flag1 = 1;
	}

	public void mouseMoved(MouseEvent e) {
	}

	// Key Pressed event
	public void keyPressed(KeyEvent ek) {
		Key = ek.getKeyCode();
		FlagKey = 1;
	}

	public void keyTyped(KeyEvent ek) {
	};

	public void keyReleased(KeyEvent ek) {
	};

	public static void changeSize(int w, int h) {
		width = w;
		height = h;
		getCanvas().canvas.setPreferredSize(new Dimension(width, height));
	}

	public static void changeLocation(int x, int y) {
		getCanvas().frame.setLocation(x, y);
	}

	// Create a Canvas.
	private Canvas(String title, int width, int height, Color bgColour) {
		backgroundColour = bgColour;
		canvas = new CanvasPane();
		canvas.setPreferredSize(new Dimension(width, height));
		frame = new JFrame();
		frame.setContentPane(canvas);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle(title);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.toFront();
		frame.addMouseListener(this);
		frame.addKeyListener(this);
	}

	// Sets the canvas visibility and brings canvas to the front of screen
	private void setVisible(boolean visible) {
		if (graphic == null) {
			// first time: instantiate the offscreen image and fill it with
			// the background colour
			Dimension size = canvas.getSize();
			canvasImage = canvas.createImage(size.width, size.height);
			graphic = (Graphics2D) canvasImage.getGraphics();
			graphic.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
			graphic.setColor(backgroundColour);
			graphic.fillRect(0, 0, size.width, size.height);
			graphic.setColor(Color.black);
		}
		frame.setVisible(visible);
	}

	// Fills the internal dimensions of a given shape with the current
	void fill(Shape shape) {
		graphic.fill(shape);
		canvas.repaint();
	}

	// Erases a given shape's interior on the screen.
	void erase(Shape shape) {
		Color original = graphic.getColor();
		graphic.setColor(backgroundColour);
		graphic.fill(shape); // erase by filling background colour
		graphic.setColor(original);
		canvas.repaint();
	}

	// Draws a String on the Canvas.
	void drawString(String text, int x, int y) {
		graphic.drawString(text, x, y);
		canvas.repaint();
	}

	// Erases a String on the Canvas.
	void eraseString(String text, int x, int y) {
		Color original = graphic.getColor();
		graphic.setColor(backgroundColour);
		graphic.drawString(text, x, y);
		graphic.setColor(original);
		canvas.repaint();
	}

	// Draws a line on the Canvas.
	void drawLine(int x1, int y1, int x2, int y2) {
		graphic.drawLine(x1, y1, x2, y2);
		canvas.repaint();
	}

	// Draws a Image on the Canvas.

	void SImage(int xPosition, int yPosition, String FileName) {
		if (FileName == "Start") {
			graphic.drawImage(Start, xPosition, yPosition, null);
			// wait(1000);
		}
		if (FileName == "Place") {
			graphic.drawImage(Place, xPosition, yPosition, null);

		}
		canvas.repaint();

	}

	// Erases a line on the Canvas.
	void eraseLine(int x1, int y1, int x2, int y2) {
		Color original = graphic.getColor();
		graphic.setColor(backgroundColour);
		graphic.drawLine(x1, y1, x2, y2);
		canvas.repaint();
	}

	// Sets the foreground colour of the Canvas.
	void setForegroundColour(String colour) {
		Color c11 = new Color(220, 220, 200);
		String c = colour.toLowerCase();
		if (c.equals("red"))
			graphic.setColor(Color.red);
		else if (c.equals("black"))
			graphic.setColor(Color.black);
		else if (c.equals("blue"))
			graphic.setColor(Color.blue);
		else if (c.equals("gray"))
			graphic.setColor(c11);
		else if (c.equals("cyan"))
			graphic.setColor(Color.cyan);
		else if (c.equals("magenta"))
			graphic.setColor(Color.magenta);
		else if (c.equals("white"))
			graphic.setColor(Color.white);
		else
			graphic.setColor(Color.black);
	}

	void wait(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (Exception e) {
		}
	}

	private class CanvasPane extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(canvasImage, 0, 0, null);
			Start = getToolkit().getImage("Start.jpg");
			Place = getToolkit().getImage("Place.jpg");
			g.drawImage(Start, 0, 0, null);
			g.drawImage(Place, 0, 0, null);
			g.drawImage(canvasImage, 0, 0, null);
			Cursor hourglassCursor = new Cursor(Cursor.HAND_CURSOR);
			setCursor(hourglassCursor);

		}
	}

}
