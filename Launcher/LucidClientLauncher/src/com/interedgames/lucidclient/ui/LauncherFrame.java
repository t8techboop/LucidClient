package com.interedgames.lucidclient.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.interedgames.lucidclient.Main;

public class LauncherFrame {
	
	public LauncherFrame() {
		initialize();
	}
	
	public JFrame frame;
	public JPanel panel;

	private void initialize() {
		
		URL fontUrl = null;
		try {
			fontUrl = new URL("https://github.com/t8techboop/LucidClientLauncher/raw/main/r_fallouty.ttf");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Font font = null;
		
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream()).deriveFont(Font.BOLD, 35);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Font fontSmall = null;
		
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream()).deriveFont(Font.BOLD, 19);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame = new JFrame("LucidClient");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(760, 415, 600, 300);
	    frame.setVisible(true);
	    
	    
	    panel = new JPanel();
	    panel.setBounds(0, 0, 600, 300);
	    panel.setBackground(new Color(35, 39, 42));
	    panel.repaint();
	    panel.setVisible(true);
	    
	    JLabel label = new JLabel();
	    label.setText("Lucid Client  Launcher");
	    label.setForeground(Color.white);
	    label.setBounds(3, 3, 100, 100);
	    label.setVisible(true);
	    label.setFont(font);
	    panel.add(label);
	    

	    
	    frame.getContentPane().add(panel);
	    
	    JCheckBox checkBox = new JCheckBox();
	    checkBox.setFont(fontSmall);
	    checkBox.setText("close after launch");
	    checkBox.setBounds(250, 250, 350, 290);
	    checkBox.setForeground(Color.white);
	    checkBox.setBackground(new Color(35, 39, 42));
	    checkBox.setVisible(true);

	    panel.add(checkBox);
	    
	    JButton button = new JButton();
	    button.setFont(fontSmall);
	    button.setText("Launch Lucid Client");
	    button.setBounds(250,270,350,290);
	    button.setBackground(new Color(87, 242, 135));
	    button.setForeground(Color.white);

	    button.setVisible(true);
	    button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(() -> {Main.launch();}).start();

			    if(checkBox.isSelected()) {
			    	System.out.println("selected");
			    	frame.setVisible(false);
			        panel.setVisible(false);

			    } else {
			    	System.out.println("off");
			    }
				
			}
		});
	    panel.add(button);
	    
	    JTextField input = new JTextField();
	    input.setFont(fontSmall);
	    input.setBounds(250,100,350,100);
	    input.setSize(300, 100);
	    input.setBackground(new Color(35, 39, 42));
	    input.setForeground(Color.white);
	    input.setVisible(true);
	    panel.add(input);
	    
	    
	    
	    
		
		
	}

}
