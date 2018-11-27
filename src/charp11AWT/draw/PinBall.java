package charp11AWT.draw;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.Timer;

public class PinBall {
	private final int TABLE_WIDTH = 300;
	private final int TABLE_HEIGHT = 400;
	private final int RACKET_Y = 340; // 球拍的 垂直位置
	private final int RACKET_WIDTH = 100;
	private final int RACKET_HEIGHT = 20;
	private final int BALL_SIZE = 16;
	Frame f = new Frame("弹球游戏");
	Random random = new Random();
	private  int ySpeed = 10;
	private  float xyRate = (float) (random.nextFloat()-0.5);
	private int xSpeed = (int) (ySpeed*xyRate*2);
	
	private int ballX = random.nextInt(200)+20; // 球坐标
	private int ballY = random.nextInt(10)+20;
	
	private int racketX = random.nextInt(200);
	
	private boolean isEnd = false;
	private Mycanvas table = new Mycanvas();
	private Timer timer =null;
	
	public void init(){
		table.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
		f.add(table);
		
		KeyAdapter keyAdapter = new KeyAdapter() { // 键盘监听器
			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
					if (racketX>0) {
						racketX -= 10;
					}
				}
				if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (racketX <TABLE_WIDTH-RACKET_WIDTH) {
						racketX += 10;
					}
				}
			}
		};
		f.addKeyListener(keyAdapter);
		table.addKeyListener(keyAdapter);
		
		// 0.1 秒监听事件
		ActionListener actionListener = evt -> {
			if (ballX<0 || ballX>TABLE_WIDTH-BALL_SIZE) {
				xSpeed = -xSpeed;
			}
			if (ballY>=RACKET_Y-BALL_SIZE && (ballX<racketX || ballX> racketX+RACKET_WIDTH)) {
				timer.stop();
				isEnd =true;
				table.repaint();
			}else if (ballY<=0 || (ballY>=RACKET_Y-BALL_SIZE && ballX>racketX && ballX<racketX+RACKET_WIDTH )) {
				ySpeed =-ySpeed;
			}
			
			ballX+=xSpeed;
			ballY+=ySpeed;
			table.repaint();
		};
		timer = new Timer(100, actionListener);
		timer.start();
		f.setVisible(true);
		f.pack();
		
	}
	
	class Mycanvas extends Canvas{
		
		@Override
		public void paint(Graphics g) {
			
			if (isEnd) {
				g.setColor(new Color(255,0,0));
				g.setFont(new Font("Times", Font.BOLD, 30));
				g.drawString("游戏已结束", 100, 100);
			}else {
				g.setColor(new  Color(240, 80, 80));
				g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
				g.fillOval(10, 10, 30, 30);
				g.fillRect(racketX, RACKET_Y, RACKET_WIDTH, RACKET_HEIGHT);
			}
		}
	}
	
	public static void main(String[] args) {
		new PinBall().init();
	}
}
