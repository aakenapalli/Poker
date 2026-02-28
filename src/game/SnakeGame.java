package game;

/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/

/** 
 * This is the Poker class that includes the GUI implementation of our game and creates the
 * objects that the game uses. Imports java.awt, java.awt.event, and Random. The objective of the
 * game is to direct the movement of the poker to hit the apple to get points while avoiding the 
 * moving obstacles that are thrown at the poker throughout the game. The colors of the obstacles
 * corresponds with a different speed. Each time the obstacle is hit, it moves to a different
 * location.
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class SnakeGame extends Game {
	static int counter = 0;
	public Body snake;
	public Obstacles obstacle;
	public Obstacles[] blocks;
	public Apple food;
	private int points;
	private Point[] snakeShape;
	private Point[] appleShape;
	private Point applePos;
	private Random r;
	private boolean isGameOver;
/**
 * This is the constructor for Poker. It creates the game window and defines the shapes of the poker
 * and the apple. The constructor also defines the starting location of the apple and makes an array
 * of the obstacles which is iterates through to add obstacles into the game.
 */
  public SnakeGame() {
    super("SnakeGame!",800,600);
    this.setFocusable(true);
	this.requestFocus();
	isGameOver = false;
	r = new Random();
	blocks = new Obstacles[200];

	snakeShape = new Point[4];
	snakeShape[0] = new Point(0,0);
	snakeShape[1] = new Point(0, 20);
	snakeShape[2] = new Point(20,20);
	snakeShape[3] = new Point(20,0);
	
	appleShape = new Point[4];
	appleShape[0] = new Point(0,0);
	appleShape[1] = new Point(0, 20);
	appleShape[2] = new Point(20,20);
	appleShape[3] = new Point(20,0);
	
	Point[] elementPoints3 = {new Point (0,0), new Point (20,0), new Point(20, 20), new Point(0, 20)};
	
	applePos = new Point(width/2, 100);
	
	snake = new Body(snakeShape, new Point(width/2, height/2), 0);
	food = new Apple(appleShape, applePos, 0);
	
	for (int i = 0; i < blocks.length; i++) {
		blocks[i] = new Obstacles(elementPoints3, new Point (r.nextInt(800), r.nextInt(600)), 0);
	}
	
	points = 0;
	
	this.addKeyListener(snake);

  }
  
	  public void paint(Graphics brush) {
			brush.setColor(Color.black);
	    	brush.fillRect(0,0,width,height);
	    	
	    	// sample code for printing message for debugging
	    	// counter is incremented and this message printed
	    	// each time the canvas is repainted
	   
	    	brush.setColor(Color.white);
	    	brush.drawString("LEVEL: " + (points+1),10,20);
	    	
	    	if(!snake.inBounds()) {
	    		isGameOver = true;
	    	}
	    	
	    	if(!isGameOver) {
	        	//counter++;
		    	brush.setColor(Color.green);
		    	snake.paint(brush);
		    	brush.setColor(Color.pink);
		    	for (int i = 0; i < counter + 1; i++) {
					blocks[i].paint(brush);
					if(snake.checkCollision(blocks[i])) {
			    		isGameOver = true;
			    	}
				}
		    	
		    	brush.setColor(Color.red);
		    	food.paint(brush);
		    	snake.movePoker();
		    	
		    	if(snake.checkCollision(food)) {
		    		points += 1;
		    		int x = r.nextInt(750);
		    		int y = r.nextInt(550);
		    		applePos = new Point(x, y);
		    		counter+=3;
		    		food = new Apple(appleShape, applePos, 0);
		    		
		    	}
	    	} else {
	    		
	    		brush.drawString("GAME OVER" ,400,300);
	    		brush.drawString("Score: " + (points*200), 400, 400);
	    	}
	  }
	  
  
	public static void main (String[] args) {
		SnakeGame a = new SnakeGame();
		a.repaint();
  }
}







