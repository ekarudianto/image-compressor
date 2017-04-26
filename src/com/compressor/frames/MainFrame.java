package com.compressor.frames;

import java.awt.Container;
import javax.swing.JFrame;

import com.compressor.panels.UploadPanel;

public class MainFrame extends JFrame {
	public MainFrame(String title) {
		super(title);
		
		// Swing component
		UploadPanel uploadPanel = new UploadPanel();
		
		// Add swing component to content
		Container c = getContentPane();
		
		c.add(uploadPanel);
	}
}
