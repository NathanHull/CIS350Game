package org.game;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * 
 * GUI class.
 *
 */
public class GUI implements ActionListener {

	/**
	 * JFrame
	 */
	private JFrame frame;
	/**
	 * JButton.
	 */
	private JButton buyHouse1, sellHouse1, buyHouse2, sellHouse2, buyHouse3, sellHouse3, buyHouse4, sellHouse4, buyHouse5, sellHouse5, buyHouse6, sellHouse6;
	/**
	 * JMenuBar.
	 */
	private JMenuBar menuBar;
	/**
	 * JMenu.
	 */
	private JMenu options, quit;
	/**
	 * JMenuItem.
	 */
	private JMenuItem OptionsItem, QuitItem;
	/**
	 * Model.
	 */
	private Model model;
	/**
	 * Label for wallet.
	 */
	private JLabel lblWallet;
	
	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public GUI() throws IOException, InterruptedException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	private void initialize() throws IOException, InterruptedException {
		model = new Model();
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 500);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setVisible(true);
		options = new JMenu("Settings");
		OptionsItem = new JMenuItem("Options");
		quit = new JMenu("Quit");
		QuitItem = new JMenuItem("End Game");
		options.add(OptionsItem);
		quit.add(QuitItem);
		menuBar.add(options);
		menuBar.add(quit);
		getFrame().setJMenuBar(menuBar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 307, 434, 36);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 21, 414, 145);
		
		ImageIcon image = new ImageIcon("Game background resized.jpg");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		panel.add(label, BorderLayout.CENTER);
		lblWallet = new JLabel("Wallet: " + model.getWallet());
		JLabel copyright = new JLabel("Version 1.0: Created By TBD. Copyright 2016 \u00a9");
		
		panel_1.add(lblWallet);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(10, 406, 414, 23);
		panel2.add(copyright);
		
		JButton buyHouse1 = new JButton("Buy");
		buyHouse1.setBounds(10, 225, 61, 23);
		buyHouse1.addActionListener(this);
		buyHouse1.setActionCommand("b1");
		getFrame().getContentPane().add(buyHouse1);
		
		JButton sellHouse1 = new JButton("Sell");
		sellHouse1.setBounds(10, 259, 61, 23);
		sellHouse1.addActionListener(this);
		sellHouse1.setActionCommand("s1");
		getFrame().getContentPane().add(sellHouse1);
		/*
		JButton sellHouse2 = new JButton("Sell");
		sellHouse2.setBounds(81, 259, 61, 23);
		sellHouse2.addActionListener(buttonListener);
		getFrame().getContentPane().add(sellHouse2);
		
		JButton buyHouse2 = new JButton("Buy");
		buyHouse2.setBounds(81, 225, 61, 23);
		buyHouse2.addActionListener(buttonListener);
		getFrame().getContentPane().add(buyHouse2);
		
		JButton buyHouse3 = new JButton("Buy");
		buyHouse3.setBounds(148, 225, 61, 23);
		buyHouse3.addActionListener(buttonListener);
		getFrame().getContentPane().add(buyHouse3);
		
		JButton sellHouse3 = new JButton("Sell");
		sellHouse3.setBounds(148, 259, 61, 23);
		sellHouse3.addActionListener(buttonListener);
		getFrame().getContentPane().add(sellHouse3);
		
		JButton buyHouse4 = new JButton("Buy");
		buyHouse4.setBounds(219, 225, 63, 23);
		buyHouse4.addActionListener(buttonListener);
		getFrame().getContentPane().add(buyHouse4);
		
		JButton sellHouse4 = new JButton("Sell");
		sellHouse4.setBounds(219, 259, 63, 23);
		sellHouse4.addActionListener(buttonListener);
		getFrame().getContentPane().add(sellHouse4);
		
		JButton buyHouse5 = new JButton("Buy");
		buyHouse5.setBounds(292, 225, 61, 23);
		buyHouse5.addActionListener(buttonListener);
		getFrame().getContentPane().add(buyHouse5);
		
		JButton buyHouse6 = new JButton("Buy");
		buyHouse6.setBounds(363, 225, 61, 23);
		buyHouse6.addActionListener(buttonListener);
		getFrame().getContentPane().add(buyHouse6);
		
		JButton sellHouse5 = new JButton("Sell");
		sellHouse5.setBounds(292, 259, 61, 23);
		sellHouse5.addActionListener(buttonListener);
		getFrame().getContentPane().add(sellHouse5);
		
		JButton sellHouse6 = new JButton("Sell");
		sellHouse6.setBounds(363, 259, 61, 23);
		sellHouse6.addActionListener(buttonListener);
		getFrame().getContentPane().add(sellHouse6);
		*/
		getFrame().getContentPane().add(panel_1);
		getFrame().getContentPane().add(panel);
		getFrame().getContentPane().add(panel2);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if(action.equals("b1")){
			if(!getHouse(0).getOwnershipState()){
				model.buyHouse(getHouse(0));
			}
		}
		if(action.equals("s1")){
			if(getHouse(0).getOwnershipState()){
				model.sellHouse(getHouse(0));
			}
		}
		
		
		lblWallet.setText("Wallet: "+ model.getWallet());
	}
	
	/**
	 * @param i, index of the house
	 * @return the house at index i
	 */
	public House getHouse(int i){
		return model.getHouseList().get(i);
		
	}
	
	
	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
}
