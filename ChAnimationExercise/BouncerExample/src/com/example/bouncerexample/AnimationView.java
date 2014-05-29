package com.example.bouncerexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

public class AnimationView extends View{
	
	private final int FRAME_RATE =15;
	private Paint paint;
	private Handler h;
	Ball myBall;
	Ball greenBall;
	Ball redBall;
	Ball yellowBall;
	Ball blackBall;

	public AnimationView(Context context, AttributeSet attrs){
		super(context, attrs);
		
		h=new Handler();
		paint = new Paint();
		paint.setColor(Color.BLUE);
		myBall = new Ball (100, 100, Color.BLUE, 50);
		greenBall = new Ball (200, 200, Color.GREEN, 25);
		redBall = new Ball (50, 400, Color.RED, 75);
		yellowBall = new Ball (25,50, Color.YELLOW, 10);
		blackBall = new Ball (150, 150, Color.BLACK, 35);
		
		
		myBall.setDx(10);
		myBall.setDY(10);
		greenBall.setDx(-20);
		greenBall.setDY(-15);
		redBall.setDx(5);
		redBall.setDY(-5);
		yellowBall.setDx(7);
		yellowBall.setDY(-7);
		blackBall.setDx(-7);
		blackBall.setDY(7);
	}
	
	protected void onDraw(Canvas c){
		myBall.bounce(c);
		greenBall.bounce(c);
		redBall.bounce(c);
		yellowBall.bounce(c);
		blackBall.bounce(c);
		c.drawCircle(myBall.getX(),  myBall.getY(),  myBall.getRadius(), myBall.getPaint());
		c.drawCircle(greenBall.getX(),  greenBall.getY(),  greenBall.getRadius(), greenBall.getPaint());
		c.drawCircle(redBall.getX(),  redBall.getY(),  redBall.getRadius(), redBall.getPaint());
		c.drawCircle(yellowBall.getX(),  yellowBall.getY(),  yellowBall.getRadius(), yellowBall.getPaint());
		c.drawCircle(blackBall.getX(),  blackBall.getY(),  blackBall.getRadius(), blackBall.getPaint());
		
		
		h.postDelayed(r,  FRAME_RATE);
	}
	
	private Runnable r = new Runnable() {
		public void run(){
			invalidate();
		}
	};
}
