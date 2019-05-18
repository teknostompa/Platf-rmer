package com.platformer.game.physics;

import java.awt.Point;

import com.platformer.game.objects.Block;

public class Collision {
	public static boolean playerBlock(Point p, Block b) {
		return b.contains(p);
	}
}
