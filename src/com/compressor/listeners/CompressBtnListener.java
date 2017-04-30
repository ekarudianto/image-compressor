package com.compressor.listeners;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.util.Iterator;

public class CompressBtnListener implements ActionListener {

	private JFileChooser chooser;
	private JButton compressBtn;
	private JSpinner compressionSpinner;
	private TextArea textLogger;
	
	private static final String DATE_TIME_FORMATTER = "yyyy-MM-dd HH-mm-ss";

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

			// Convert spinner Number value into int and later converted into float
			int n = ((SpinnerNumberModel) compressionSpinner.getModel()).getNumber().intValue();
			float compressionSize = (float) (n / 100.0);

			textLogger.append("Compressing file : " + fileName + "\n");
			textLogger.append("Original file size : " + chooser.getSelectedFile().length() + "\n");
			textLogger.append("Compression size : " + compressionSpinner.getValue() + "% \n");
			textLogger.append("\n");
			textLogger.append("=======================================\n");
			textLogger.append("\n");

			try {
				this.compressImage(chooser, compressionSize);
			} catch (IOException ex) {
				textLogger.append("Error compressing file : " + ex.toString() + "\n");
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Compress an image based on passed percentage rate by user
	 * 
	 * @param img the image object
	 * @param qualitySize the quality compression size 
	 * @throws IOException
	 */
	private void compressImage(JFileChooser img, float qualitySize) throws IOException {
		ImageWriter writer = null;

		// Read original image into a BufferedImage object
		BufferedImage inputImage = ImageIO.read(new File(img.getSelectedFile().toString()));
		
		// Get image type
		String imgName = img.getSelectedFile().getName();
		String imgType = imgName.substring(imgName.lastIndexOf(".") + 1, imgName.length());

		// Obtain an ImageWriter for image type, for example :
		// "jpg", "png", "bmp"
		Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName(imgType);  

		if (!iter.hasNext())
			throw new IOException("Image type is not recognizeable");

		writer = (ImageWriter) iter.next();

		ImageWriteParam iwp = writer.getDefaultWriteParam();
		iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT) ;
		iwp.setCompressionQuality(qualitySize);

		/**
		 * These steps are required to generate file path and file name :
		 * 
		 *  - extract output path
		 *  - extract image name wihtout the file extension
		 *  - get today date time
		 *  
		 *  Above steps will resulted in generated output file that formatted like this
		 *  
		 *  {path}/{imgName}{dateTime}.{imgType}
		 */
		
		// extract output path
		String p = img.getSelectedFile().getPath();
		String imgPath = p.substring(0, p.lastIndexOf("/") + 1);
		
		// extract image name without the file extension
		String outputName = imgName.substring(0, imgName.lastIndexOf(".")); 

		// get today date time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMATTER);
		String now = LocalDateTime.now().format(formatter);
		
		File fileOut = new File(imgPath + outputName + " " + now + "." + imgType);
		FileImageOutputStream outputImage = new FileImageOutputStream(fileOut);

		// Create an IIOImage object containing an 
		// image, thumbnails, and metadata to be written from inputImage.
		IIOImage iioiImage = new IIOImage(inputImage, null, null);  

		writer.setOutput(outputImage);
		writer.write(null, iioiImage, iwp);
		writer.dispose();

		textLogger.append("Compression successful!");
	}
}
