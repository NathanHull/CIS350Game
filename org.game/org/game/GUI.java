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
public class GUI {

	/**
	 * JFrame.
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

	private ButtonListener buttonListener = new ButtonListener();
	
	/**
	 * Launch the application.
	 * @param args : the args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		frame.setJMenuBar(menuBar);
		
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
		
		JButton buyHouse1 = new JButton("Buy");
		buyHouse1.setBounds(10, 225, 61, 23);
		buyHouse1.addActionListener(buttonListener);
		frame.getContentPane().add(buyHouse1);
		
		JButton sellHouse1 = new JButton("Sell");
		sellHouse1.setBounds(10, 259, 61, 23);
		sellHouse1.addActionListener(buttonListener);
		frame.getContentPane().add(sellHouse1);
		
		JButton sellHouse2 = new JButton("Sell");
		sellHouse2.setBounds(81, 259, 61, 23);
		sellHouse2.addActionListener(buttonListener);
		frame.getContentPane().add(sellHouse2);
		
		JButton buyHouse2 = new JButton("Buy");
		buyHouse2.setBounds(81, 225, 61, 23);
		buyHouse2.addActionListener(buttonListener);
		frame.getContentPane().add(buyHouse2);
		
		JButton buyHouse3 = new JButton("Buy");
		buyHouse3.setBounds(148, 225, 61, 23);
		buyHouse3.addActionListener(buttonListener);
		frame.getContentPane().add(buyHouse3);
		
		JButton sellHouse3 = new JButton("Sell");
		sellHouse3.setBounds(148, 259, 61, 23);
		sellHouse3.addActionListener(buttonListener);
		frame.getContentPane().add(sellHouse3);
		
		JButton buyHouse4 = new JButton("Buy");
		buyHouse4.setBounds(219, 225, 63, 23);
		buyHouse4.addActionListener(buttonListener);
		frame.getContentPane().add(buyHouse4);
		
		JButton sellHouse4 = new JButton("Sell");
		sellHouse4.setBounds(219, 259, 63, 23);
		sellHouse4.addActionListener(buttonListener);
		frame.getContentPane().add(sellHouse4);
		
		JButton buyHouse5 = new JButton("Buy");
		buyHouse5.setBounds(292, 225, 61, 23);
		buyHouse5.addActionListener(buttonListener);
		frame.getContentPane().add(buyHouse5);
		
		JButton buyHouse6 = new JButton("Buy");
		buyHouse6.setBounds(363, 225, 61, 23);
		buyHouse6.addActionListener(buttonListener);
		frame.getContentPane().add(buyHouse6);
		
		JButton sellHouse5 = new JButton("Sell");
		sellHouse5.setBounds(292, 259, 61, 23);
		sellHouse5.addActionListener(buttonListener);
		frame.getContentPane().add(sellHouse5);
		
		JButton sellHouse6 = new JButton("Sell");
		sellHouse6.setBounds(363, 259, 61, 23);
		sellHouse6.addActionListener(buttonListener);
		frame.getContentPane().add(sellHouse6);
		
		frame.getContentPane().add(panel_1);
		
		
		frame.getContentPane().add(panel);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(10, 406, 414, 23);
		panel2.add(copyright);
		frame.getContentPane().add(panel2);

	}
	
	/**
	 * 
	 * ButtonListener class.
	 *
	 */
	private class ButtonListener implements ActionListener {
		/**
		 * @param event : the event that is happening
		 */
		public void actionPerformed(ActionEvent event) {
			Object select = event.getSource();
			
			if (event.getSource() == buyHouse1) {
				if (!model.getHouseList()[0].getOwnershipState()) {
					model.buyHouse(model.getHouseList()[0]);
				}
			} else if (select == sellHouse1) {
				if (model.getHouseList()[0].getOwnershipState()) {
					model.sellHouse(model.getHouseList()[0]);
				}
			}
			
			if (select == buyHouse2) {
				if (!model.getHouseList()[1].getOwnershipState()) {
					model.buyHouse(model.getHouseList()[1]);
				}
			} else if (select == sellHouse2) {
				if (model.getHouseList()[1].getOwnershipState()) {
					model.sellHouse(model.getHouseList()[1]);
				}
			}
			
			if (select == buyHouse3) {
				if (!model.getHouseList()[2].getOwnershipState()) {
					model.buyHouse(model.getHouseList()[2]);
				}
			} else if (select == sellHouse3) {
				if (model.getHouseList()[2].getOwnershipState()) {
					model.sellHouse(model.getHouseList()[2]);
				}
			}
			
			if (select == buyHouse4) {
				if (!model.getHouseList()[2].getOwnershipState()) {
					model.buyHouse(model.getHouseList()[3]);
				}
			} else if (select == sellHouse4) {
				if (model.getHouseList()[2].getOwnershipState()) {
					model.sellHouse(model.getHouseList()[3]);
				}
			}
			
			if (select == buyHouse5) {
				if (!model.getHouseList()[4].getOwnershipState()) {
					model.buyHouse(model.getHouseList()[4]);
				}
			} else if (select == sellHouse5) {
				if (model.getHouseList()[4].getOwnershipState()) {
					model.sellHouse(model.getHouseList()[4]);
				}
			}
			
			if (select == buyHouse6) {
				if (!model.getHouseList()[5].getOwnershipState()) {
					model.buyHouse(model.getHouseList()[5]);
				}
			} else if (select == sellHouse6) {
				if (model.getHouseList()[5].getOwnershipState()) {
					model.sellHouse(model.getHouseList()[5]);
				}
			}
			
			lblWallet.setText("Wallet: " + model.getWallet());
			
			if(select == QuitItem)
			{
				System.exit(1);
			}
			
			if(select == options)
			{
				
			}
		}
	}
	
	
}
