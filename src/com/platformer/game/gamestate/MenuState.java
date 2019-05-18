package com.platformer.game.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.platformer.game.main.GamePanel;

public class MenuState extends GameState{

	private String[] options = {"Start","Options","Exit"};
	private int currentSelection = 0;
	
	public MenuState(GameStateManager gsm) {
		super(gsm);

	}


	public void init() {}


	public void tick() {}

	public void draw(Graphics g) {
		
		g.setColor(new Color(199,0,56));
		g.fillRect(0, 0, GamePanel.w, GamePanel.h);

		for(int i = 0; i < options.length; i++) {
			if(i == currentSelection) {
				g.setColor(new Color(255, 195, 0));
			} else {
				g.setColor(new Color(255, 87, 51));
			}
			
			g.setFont(new Font("Arial", Font.PLAIN, 70));
			g.drawString(options[i], GamePanel.w / 2 - 100, 150 + i * 150);
		}
		
		
		
	}


	public void keyPressed(int k) {
		if(k == KeyEvent.VK_S) {
			currentSelection ++;
			
			if(currentSelection >= options.length) {
				currentSelection = 0;
			}
		}
		
		if(k == KeyEvent.VK_W) {
			currentSelection --;
				
			if(currentSelection < 0) {
				currentSelection = options.length - 1;
			}
		}
		
		if(k == KeyEvent.VK_ENTER) {
			if(currentSelection == 0) {
				
				gsm.states.push(new Level1State(gsm));
				
			}
			if(currentSelection == 1) {
			
			}
			if(currentSelection == 2) {
				
				System.exit(0);
				
			}
		}
	}


	public void keyReleased(int k) {

		
	}

}
