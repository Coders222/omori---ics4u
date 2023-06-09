/*
 * This class is for dealing with player animation as they walk around the map.
 */
import javax.swing.*;

import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.util.*;

public class Player extends JPanel implements Runnable{

	
	private int HP;
	private ArrayList<String> attacks = new ArrayList<>();
	private ArrayList<String> items = new ArrayList<>();

	public Main game;
	

	public Player(Main Main) {
		game = Main;
	}

	int key = 0;
	boolean legUp, legDown, legLeft, legRight;


	@Override
	// movement frames change at specified intervals. 
	// movement frames will change faster if running.
	public void run() {
		
		// TODO Auto-generated method stub
		
		// change leg up
		if(key == 1 && game.yCounter % (50 / game.charSpeed) == 0) {
			if(game.left == false && game.right == false) {
				if(legUp) game.playerIndex = 9;
				else game.playerIndex = 11;
				legUp = !legUp;
			}
		}
		
		// change leg left
		else if(key == 2 && game.xCounter % (50 / game.charSpeed) == 0) {
			if(legLeft) game.playerIndex = 3;
			else game.playerIndex = 5;
			legLeft = !legLeft;
		}
		
		// change leg down
		else if(key == 3 && game.yCounter % (50 / game.charSpeed) == 0) {
			if(game.left == false && game.right == false) {
				if(legDown) game.playerIndex = 0;
				else game.playerIndex = 2;
				legDown = !legDown;
			}
		}
		// change leg right
		else if (key == 4 && game.xCounter % (50 / game.charSpeed) == 0){
			if(legRight) game.playerIndex = 6;
			else game.playerIndex = 8;
			legRight = !legRight;
		}
		game.repaint();
	}

}