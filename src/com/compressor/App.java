package com.compressor;

import com.compressor.frames.MainFrame;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
	
	/**
	 * Header title of the desktop app 
	 */
	private final static String APP_TITLE = "Image compressor desktop app";
	
	/**
	 * Frame height default size (px)
	 */
	private final static int FRAME_HEIGHT = 480;
	
	/**
	 * Frame width default size (px)
	 */
	private final static int FRAME_WIDTH = 650; 
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame frame = new MainFrame(APP_TITLE);
				frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
