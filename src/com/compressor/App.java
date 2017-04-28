package com.compressor;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.compressor.frames.MainFrame;

public class App {
	
	private final static int frameWidth = 650;
	private final static int frameHeight = 480;
	private final static String headerTitle = "Image compressor desktop app"; 
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame frame = new MainFrame(headerTitle);
				frame.setSize(frameWidth, frameHeight);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
