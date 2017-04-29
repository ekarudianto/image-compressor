package com.compressor.listeners;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SelectBtnListener implements ActionListener {
	
	private JLabel uploadLabel;
	private JButton selectBtn;
	private JButton compressBtn;
	private TextArea textLogger;
	private JFileChooser chooser;
	private boolean isCompressBtnEnabled = false;
	
	/**
	 * Constructor of select button action listener
	 * 
	 * @param selectBtn the select button componenet
	 * @param compressBtn the compress button component
	 * @param uploadLabel the upload label beside select button component
	 * @param textLogger the text logger componenet
	 * @param chooser JFileChooser class being passed from parent panel
	 */
	public SelectBtnListener(
	  JButton selectBtn, 
	  JButton compressBtn, 
	  JLabel uploadLabel, 
	  TextArea textLogger, 
	  JFileChooser chooser
	) {
		this.uploadLabel = uploadLabel;
		this.selectBtn = selectBtn;
		this.textLogger = textLogger;
		this.compressBtn = compressBtn;
		this.chooser = chooser;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == selectBtn) {

			// Filter files that could be uploaded
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "Image files", ImageIO.getReaderFileSuffixes());
			
			chooser.setFileFilter(filter);
			chooser.setAcceptAllFileFilterUsed(false);
			
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
			  
			  if (!isCompressBtnEnabled) {
				  isCompressBtnEnabled = !isCompressBtnEnabled;
				  compressBtn.setEnabled(isCompressBtnEnabled);
			  }
			  
			  String fileName = chooser.getSelectedFile().getName();
			  uploadLabel.setText(fileName);
			  uploadLabel.setToolTipText(fileName);
			  textLogger.append("File selected from : " + chooser.getSelectedFile() + "\n");
			}
		}
	}

}
