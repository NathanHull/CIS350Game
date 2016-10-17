package org.game;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GUI {

	private JFrame frame;
	private JButton buyHouse1, sellHouse1, buyHouse2, sellHouse2, buyHouse3, sellHouse3;
	private JMenuBar menuBar;
	private JMenu options, quit;
	private JMenuItem OptionsItem, QuitItem;
	Model model;
	

	/**
	 * Launch the application.
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
		frame.setBounds(100, 100, 450, 300);
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
		panel_1.setBounds(0, 225, 434, 36);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 21, 414, 145);
		
		ImageIcon image = new ImageIcon("Game background resized.jpg");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		panel.add(label, BorderLayout.CENTER);
		JLabel lblWallet = new JLabel("Wallet: ");
		
		/*ImageIcon housePic = new ImageIcon("House icon.jpg");
		JLabel houseIcon = new JLabel(housePic);
		JLabel houseIcon2 = new JLabel(housePic);
		JLabel houseIcon3 = new JLabel(housePic);
		JLabel lblWallet = new JLabel("Wallet: ");
		
		
		houseIcon.setBounds(52, 11, 62, 62);
		frame.getContentPane().add(houseIcon);
		houseIcon.setVisible(true);;
		
	
		houseIcon2.setBounds(182, 11, 62, 62);
		frame.getContentPane().add(houseIcon2);
		houseIcon2.setVisible(true);
		
		
		houseIcon3.setBounds(316, 11, 62, 62);
		frame.getContentPane().add(houseIcon3);
		houseIcon3.setVisible(true);
		
		panel_1.add(lblWallet);
		panel_1.add(lblWallet);
		panel_1.add(houseIcon);
		panel_1.add(houseIcon2);
		panel_1.add(houseIcon3);*/
		
		panel_1.add(lblWallet);
		
		JButton buyHouse1 = new JButton("Buy");
		buyHouse1.setBounds(10, 167, 61, 23);
		frame.getContentPane().add(buyHouse1);
		
		JButton sellHouse1 = new JButton("Sell");
		sellHouse1.setBounds(10, 191, 61, 23);
		frame.getContentPane().add(sellHouse1);
		
		JButton sellHouse2 = new JButton("Sell");
		sellHouse2.setBounds(81, 191, 61, 23);
		frame.getContentPane().add(sellHouse2);
		
		JButton buyHouse2 = new JButton("Buy");
		buyHouse2.setBounds(81, 167, 61, 23);
		frame.getContentPane().add(buyHouse2);
		
		JButton buyHouse3 = new JButton("Buy");
		buyHouse3.setBounds(148, 167, 61, 23);
		frame.getContentPane().add(buyHouse3);
		
		JButton sellHouse3 = new JButton("Sell");
		sellHouse3.setBounds(148, 191, 61, 23);
		frame.getContentPane().add(sellHouse3);
		
		frame.getContentPane().add(panel_1);
		
		
		frame.getContentPane().add(panel);
		
		JButton buyHouse4 = new JButton("Buy");
		buyHouse4.setBounds(219, 167, 63, 23);
		frame.getContentPane().add(buyHouse4);
		
		JButton sellHouse4 = new JButton("Sell");
		sellHouse4.setBounds(219, 191, 63, 23);
		frame.getContentPane().add(sellHouse4);
		
		JButton button = new JButton("Buy");
		button.setBounds(292, 167, 61, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Buy");
		button_1.setBounds(363, 167, 61, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Sell");
		button_2.setBounds(292, 191, 61, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Sell");
		button_3.setBounds(363, 191, 61, 23);
		frame.getContentPane().add(button_3);
	}
	
	public class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object select = event.getSource();
			
			if(select == buyHouse1)
			{
				if(model.houseList[0].getOwnershipState() == false)
				{
					wallet = wallet - model.houseList[0].getPrice();
					
					
				}
			}
			
			else if(select == sellHouse1)
			{
				select.getPrice();
			}
			
			if(select == buyHouse2)
			{
				select.getPrice();
			}
			
			else if(select == sellHouse2)
			{
				select.getPrice();
			}
			
			if(select == buyHouse3)
			{
				select.getPrice();
			}
			
			else if(select == sellHouse3)
			{
				select.getPrice();
			}
			
		}
	}
	
	
}
