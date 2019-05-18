package com.platformer.game.main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game {
	
	public static void main(String[] args) {
	JFrame frame = new JFrame("Platformer Game");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setLayout(new BorderLayout());
	frame.add(new GamePanel(), BorderLayout.CENTER);
	frame.pack();
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	
	}
}
