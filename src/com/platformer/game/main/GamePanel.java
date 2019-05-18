package com.platformer.game.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import com.platformer.game.gamestate.GameStateManager;

public class GamePanel extends JPanel implements Runnable, KeyListener{

	private static final long serialVersionUID = 1L;
	

	
	public static final int w = 900;
	public static final int h = 600;
	public static final int yFloor = 600-50;
	public static final int xLwall = 0;
	public static final int xRwall = w;

	
	public static int x = 10;
	public static int y = yFloor - 50;
	
	public static boolean hascontrol = true;
	

	public static int double_jump = 1;
	
	public static boolean grounded = true;

	
	private Thread thread;
	private boolean isRunning = false;
	
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	private GameStateManager gsm;
	
	public GamePanel() {
		setPreferredSize(new Dimension(w, h));
		
		start();
	}
	
	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
		
	}

	public void run() {
		long start, elapsed, wait;
		
		gsm = new GameStateManager();
		
		while(isRunning) {
			start = System.nanoTime();
			
			tick();
			repaint();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			
			if(wait <= 5) {
				wait = 5;
			}
			
			try {
				Thread.sleep(wait);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void tick() {
		gsm.tick();
	
	}
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.clearRect(0, 0, w, h);
		
		gsm.draw(g);
		
	}
	

	
	public void keyPressed(KeyEvent e) {
	
		
		gsm.KeyPressed(e.getKeyCode());
		

	}

	public void keyReleased(KeyEvent e) {
		
		gsm.KeyReleased(e.getKeyCode());
		
				
		}
	public void keyTyped(KeyEvent e) {

	}

}
