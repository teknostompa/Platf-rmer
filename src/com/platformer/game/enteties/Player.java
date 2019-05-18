package com.platformer.game.enteties;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.platformer.game.gamestate.Level1State;
import com.platformer.game.main.GamePanel;
import com.platformer.game.objects.Block;
import com.platformer.game.physics.Collision;

public class Player{

	public boolean left = false;
	public boolean right = false;
	public boolean jumping = false;
	public static boolean gravityB = true;
	
	public static boolean grounded;
	
	public static int x = 50;
	public static int y = GamePanel.h - 100;
	public static int width;
	public static int height;
	
	public static int movx;
	public static int movy;
	public static float xSpeed = 0;
	public static float ySpeed = 0;
	

    public static boolean pressedA = false;
    public static boolean pressedD = false;	
	public static final float METER_TO_PIXELS = 32f;
	public static final float SECONDS_TO_FRAMES = 1f / 60f;
	
	public static final float gravity = (9.81f * METER_TO_PIXELS * SECONDS_TO_FRAMES) / 5;
	
	public static final float jump_force = 15f;
	
	public Player(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	

	public void tick(Block[] b) {
		System.out.println(movx);
		
		
		x += movx*4;
		y += ySpeed;
		
		ySpeed += gravity;
		
		for(int i = 0; i < b.length; i++) {
			
			// Collision Ground
			if(Collision.playerBlock(new Point(x + width / 2, y + height), b[i])) {
				y = b[i].y - 50;//GamePanel.h - Block.blockSize - 50;
				
				ySpeed = 0;
				
				grounded = true;
				
			}
			// Collision Left
			if(Collision.playerBlock(new Point(x, y + height / 2), b[i])) {
				x = b[i].x + 50;//GamePanel.h - Block.blockSize - 50;
				
				//movx = 0;
				
				grounded = true;
				
			}
			// Collision Right
			if(Collision.playerBlock(new Point(x + width, y + height /  2), b[i])) {
				x = b[i].x - 50;//GamePanel.h - Block.blockSize - 50;
				
				//movx = 0;
				
				grounded = true;
				
			}
			// Collision Top
			if(Collision.playerBlock(new Point(x + width / 2, y), b[i])) {
				y = b[i].y + 50;//GamePanel.h - Block.blockSize - 50;
				
				//movx = 0;
				
				grounded = true;
				
			}

		}
		
		
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect((int)x, (int)y, width, height);
	}
	
	public void KeyPressed(int k) {
		if(grounded) {
			
				ySpeed += gravity; 
				
			if((k == KeyEvent.VK_SPACE) && (grounded)) {
				ySpeed -= jump_force;
				grounded = false;
				gravityB = false;
			} else {
				gravityB = true;
			}
			if(k == KeyEvent.VK_S) {
			
			}
			if(k == KeyEvent.VK_A && !pressedA) {
				movx-=1;
				pressedA = true;
			}
			if(k == KeyEvent.VK_D && !pressedD) {
				movx+=1;
				pressedD = true;
			}
		}
	}
	
	public void KeyReleased(int k) {
		
		ySpeed = 0;
		
		if((k == KeyEvent.VK_SPACE) && (grounded = false) && (gravityB = true)) {
			ySpeed = gravity;
		} else {
			ySpeed = 0;
		}
		if(k == KeyEvent.VK_A && pressedA) {
			movx +=1;
			pressedA = false;
		}
			
		if(k == KeyEvent.VK_D && pressedD) {
			movx -=1;
			pressedD = false;
		}
	}
}
