package com.platformer.game.objects;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;

public class Block extends Rectangle{
	private static final long serialVersionUID = 1L;
	
	public static int blockSize = 50;
	public static int Blockx, Blocky;
	
	
	public Block(int x, int y) {
		setBounds(x, y, blockSize, blockSize);
		this.Blockx = x;
		this.Blocky = y;

	}
	
	public void draw(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
	}
}
