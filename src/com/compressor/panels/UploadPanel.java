package com.compressor.panels;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import com.compressor.listeners.CompressBtnListener;
import com.compressor.listeners.SelectBtnListener;
import javax.swing.JSpinner;
import java.awt.TextArea;

public class UploadPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private final JFileChooser chooser = new JFileChooser();
	private final JButton compressBtn = new JButton("Compress");
	private final JLabel compressionSizeLabel = new JLabel("Compression size (%)");
	private final JSpinner compressionSpinner = new JSpinner();
	private final JButton selectBtn = new JButton("Open");
	private final TextArea textLogger = new TextArea();
	private final JLabel uploadLabel = new JLabel("Filename");

	/**
	 * Constructor of upload panel.
	 * It will create the panel and it's sub components
	 */
	public UploadPanel() {
		
		selectBtn.addActionListener(new SelectBtnListener(
			selectBtn, compressBtn, uploadLabel, textLogger, chooser
		));
		
		selectBtn.setToolTipText("Open file");
		selectBtn.setBounds(10, 10, 100, 30);
		add(selectBtn);
		
		uploadLabel.setToolTipText("Filename");
		uploadLabel.setBounds(120, 10, 300, 30);
		add(uploadLabel);
		
		compressionSizeLabel.setBounds(10, 60, 180, 30);
		add(compressionSizeLabel);
		
		// Disable keyboard edits in the compression spinner
	    JFormattedTextField tf = ((JSpinner.DefaultEditor) compressionSpinner.getEditor()).getTextField();
	    tf.setEditable(false);
	    tf.setBackground(Color.WHITE);

	    compressionSpinner.setBounds(190, 60, 50, 30);
	    compressionSpinner.setValue(new Integer(50)); // Set default value
		add(compressionSpinner);
		
		textLogger.setEditable(false);
		textLogger.setBounds(10, 110, 600, 300);
		textLogger.setBackground(Color.WHITE);
		add(textLogger);
		
		compressBtn.addActionListener(new CompressBtnListener(compressBtn, textLogger, chooser, compressionSpinner));
		compressBtn.setToolTipText("Compress");
		compressBtn.setBounds(10, 420, 140, 30);
		compressBtn.setEnabled(false);
		add(compressBtn);
	}
}
