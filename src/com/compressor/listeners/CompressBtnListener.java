package com.compressor.listeners;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.lang.model.element.Element;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;

public class CompressBtnListener implements ActionListener {
	
	private JFileChooser chooser;
	private JButton compressBtn;
	private JSpinner compressionSpinner;
	private TextArea textLogger;
	
	/**
	 * Constructor of compress button listener
	 * 
	 * @param compressBtn the compress button component
	 * @param textLogger the text logger component
	 * @param chooser JFileChooser class being passed from parent panel
	 * @param compressionSpinner the compression spinner to determine the size percentage compression
	 */
	public CompressBtnListener(JButton compressBtn, TextArea textLogger, JFileChooser chooser, JSpinner compressionSpinner) {
		this.textLogger = textLogger;
		this.chooser = chooser;
		this.compressBtn = compressBtn;
		this.compressionSpinner = compressionSpinner;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == compressBtn) {
			String fileName = chooser.getSelectedFile().getName();
//			String fileExtension = fileName.substring(fileName.lastIndexOf("."),fileName.length());

			textLogger.append("Compressing file : " + fileName + "\n");
			textLogger.append("Original file size : " + chooser.getSelectedFile().length() + "\n");
			textLogger.append("Compression size : " + compressionSpinner.getValue() + "% \n");
			textLogger.append("\n");
			textLogger.append("=======================================\n");
			
			try {
				this.compressImage();
			} catch (IOException e1) {
				textLogger.append("Error compressing file : " + e1.getMessage());
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * Compress an image based on passed percentage rate by user
	 * 
	 * @throws IOException
	 */
	private void compressImage() throws IOException {
		File image = new File(chooser.getSelectedFile().toString());
		BufferedImage inputImage = ImageIO.read(image);
		System.out.println(inputImage);
	}

}
