package com.compressor.panels;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.compressor.listeners.UploadButtonListener;

public class UploadPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JButton uploadBtn = new JButton("Open");
	private JLabel uploadLabel = new JLabel("Filename");

	/**
	 * Create the panel.
	 */
	public UploadPanel() {
		
		uploadBtn.addActionListener(new UploadButtonListener(uploadBtn, uploadLabel));
		uploadBtn.setToolTipText("Open file");
		uploadBtn.setVerticalAlignment(SwingConstants.BOTTOM);
		uploadBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		add(uploadBtn);
		
		uploadLabel.setToolTipText("Filename");
		add(uploadLabel);
	}
}
