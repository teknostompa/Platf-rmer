package com.platformer.game.gamestate;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.platformer.game.enteties.Player;
import com.platformer.game.main.GamePanel;
import com.platformer.game.objects.Block;

public class Level1State extends GameState{
	
	
	public static final int playerW = 50;
	public static final int playerH = 50;
	
	public static boolean collisionG = false;
	public static boolean collisionU = false;
	public static boolean collisionL = false;
	public static boolean collisionR = false;

	public static int xBlock, yBlock, nBlock;
	
	public static int HowManyBlocks = GamePanel.w / 50;
	public static int yBlockGround = GamePanel.h - 50;
	public static int yBlockAbove = GamePanel.h - 100;

	private Player player;
	
	public static Block[] b;

	
	public Level1State(GameStateManager gsm) {
		super(gsm);
	}

	
	public void init() {
		player = new Player(Player.x, Player.y,playerW, playerH);
		Player.x = 100;
		Player.y = /*GamePanel.h - 100*/0;
		
		
		
		
		b = new Block[20];

		for(int i = 0; i < b.length; i++) {
			b[nBlock] = new Block(xBlock, yBlockGround);
			nBlock++;
			xBlock += 50;
		}
		b[18] = new Block(400, 500);
		b[19] = new Block(200, 450);
		
		
	}


	public void tick() {
		player.tick(b);
/*
		if(Player.y >= GamePanel.h - 100) {
			collisionG = true;
			Player.grounded = true;
		}
		else {
			collisionG = false;
			Player.grounded = false;
		}
		if(collisionG) {

			Player.y = GamePanel.h - 100;
			Player.ySpeed = 0;
		}
		*/
	}

	
	public void draw(Graphics g) {

		
		/*g.setColor(Color.BLACK);
		g.fillRect(0,GamePanel.h - 100, GamePanel.w, 100);*/
		
		player.draw(g);
		
		for(int i = 0; i < b.length; i++) {
			b[i].draw(g);
		}
		
	}


	public void keyPressed(int k) {
		player.KeyPressed(k);
	}


	public void keyReleased(int k) {
		player.KeyReleased(k);
	}
	
}
