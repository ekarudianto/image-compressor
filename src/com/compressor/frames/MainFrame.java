package com.compressor.frames;

import java.awt.Container;
import javax.swing.JFrame;
import com.compressor.panels.UploadPanel;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public MainFrame(String title) {
		super(title);
		
		// Swing component
		UploadPanel uploadPanel = new UploadPanel();
		uploadPanel.setLayout(null);
		
		// Add swing component to content
		Container c = getContentPane();
		
		c.add(uploadPanel);
		
	}
}
