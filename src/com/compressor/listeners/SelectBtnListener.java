package com.compressor.listeners;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SelectBtnListener implements ActionListener {
	
	private JLabel uploadLabel;
	private JButton selectBtn;
	private JButton compressBtn;
	private TextArea textLogger;
	private boolean isCompressBtnEnabled = false;
	
	public SelectBtnListener(JButton selectBtn, JButton compressBtn, JLabel uploadLabel, TextArea textLogger) {
		this.uploadLabel = uploadLabel;
		this.selectBtn = selectBtn;
		this.textLogger = textLogger;
		this.compressBtn = compressBtn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == selectBtn) {
			final JFileChooser chooser = new JFileChooser();

			// Filter files that could be uploaded
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "JPG & GIF Images", "jpg", "gif");
			chooser.setFileFilter(filter);
			
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
			  
			  if (!isCompressBtnEnabled) {
				  isCompressBtnEnabled = true;
				  compressBtn.setEnabled(isCompressBtnEnabled);
			  }
				
			  uploadLabel.setText("File " + chooser.getSelectedFile().getName());
			  uploadLabel.setToolTipText(chooser.getSelectedFile().getName());
			  textLogger.append("File selected from " + chooser.getSelectedFile() + "\n");
			}
		}
	}

}
