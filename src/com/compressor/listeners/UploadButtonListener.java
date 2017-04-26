package com.compressor.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UploadButtonListener implements ActionListener {
	
	private JLabel uploadLabel;
	private JButton uploadBtn;
	
	public UploadButtonListener(JButton uploadBtn, JLabel uploadLabel) {
		this.uploadLabel = uploadLabel;
		this.uploadBtn = uploadBtn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == uploadBtn) {
			final JFileChooser chooser = new JFileChooser();

			// Filter files that could be uploaded
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "JPG & GIF Images", "jpg", "gif");
			chooser.setFileFilter(filter);
			
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " +
			            chooser.getSelectedFile().getName());
			       uploadLabel.setText("File " + chooser.getSelectedFile());
			}
		}
	}

}
