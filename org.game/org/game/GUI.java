package org.game;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 * 
 * GUI class.
 *
 */
public class GUI extends Init implements ActionListener {
	/**
	 * THREE.
	 */
	public static final int THREE = 3;
	/**
	 * FOUR.
	 */
	public static final int FOUR = 4;
	/**
	 * FIVE.
	 */
	public static final int FIVE = 5;
	/**
	 * TEN.
	 */
	public static final int TEN = 10;
	/**
	 * TWENTY.
	 */
	public static final int TWENTY = 20;
	/**
	 * ONE_HUNDRED.
	 */
	public static final int ONE_HUNDRED = 100;
	/**
	 * FOUR_HUNDRED.
	 */
	public static final int FOUR_HUNDRED = 400;
	/**
	 * FOUR_FIFTY.
	 */
	public static final int FOUR_FIFTY = 450;
	/**
	 * FIVE_HUNDRED.
	 */
	public static final int FIVE_HUNDRED = 500;
	/**
	 * TWO_K.
	 */
	public static final int TWO_K = 2000;
	/**
	 * TWO_K_00.
	 */
	public static final double TWO_K_00 = 2000.00;
	
	
	
	
	/**
	 * JFrame.
	 */
	private JFrame frame;
	/**
	 * JButton.
	 */
	private JButton buyHouse0, sellHouse0, 
		buyHouse1, sellHouse1, 
		buyHouse2, sellHouse2, 
		buyHouse3, sellHouse3, 
		buyHouse4, sellHouse4, buyHouse5, 
		sellHouse5;
	/**
	 * JMenuBar.
	 */
	private JMenuBar menuBar;
	/**
	 * JMenu.
	 */
	private JMenu options, sys;
	/**
	 * JMenuItem.
	 */
	private JMenuItem optionsItem, sysItem;
	/**
	 * Model.
	 */
	private Model model;
	/**
	 * Label for wallet.
	 */
	private JLabel lblWallet;
	/**
	 * Labels for house prices.
	 */
	private JLabel lblHP0, lblHP1, lblHP2, lblHP3, lblHP4, lblHP5;
	/**
	 * Decimal format for labels.
	 */
	private DecimalFormat df = new DecimalFormat("##.00");

	/**
	 * Create the application.
	 * 
	 * @throws IOException :exception
	 * @throws InterruptedException :exception
	 */
	public GUI() throws IOException, InterruptedException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException : exception
	 * @throws InterruptedException : exception
	 */
	private void initialize() throws IOException, InterruptedException {
		
		model = new Model();
		setFrame(new JFrame());
		getFrame().setBounds(
				ONE_HUNDRED, ONE_HUNDRED, FOUR_FIFTY, FIVE_HUNDRED);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setVisible(true);

		sys = new JMenu("System");

		sysItem = new JMenuItem("Reset");
		sysItem.addActionListener(this);
		sysItem.setActionCommand("reset");
		sys.add(sysItem);
		sysItem = new JMenuItem("Quit");
		sysItem.addActionListener(this);
		sysItem.setActionCommand("quit");
		sys.add(sysItem);

		options = new JMenu("Options");
		optionsItem = new JMenuItem("Settings");
		optionsItem.addActionListener(this);
		optionsItem.setActionCommand("settings");
		options.add(optionsItem);

		menuBar.add(options);
		menuBar.add(sys);
		getFrame().setJMenuBar(menuBar);

		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 307, 434, 36);
		JPanel panel = new JPanel();
		panel.setBounds(TEN, 21, 414, 145);

		ImageIcon image = new ImageIcon("Game background resized.jpg");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		panel.add(label, BorderLayout.CENTER);
		lblWallet = new JLabel("Wallet: $" + df.format(model.getWallet()));

		JLabel copyright = new JLabel(
				"Version 1.0: Created By TBD. Copyright 2016 \u00a9");
		panel1.add(lblWallet);

		JPanel panel2 = new JPanel();
		panel2.add(copyright);

		JPanel pricePanel = new JPanel();
		pricePanel.setBounds(TEN, 185, FOUR_HUNDRED, TWENTY);

		lblHP0 = new JLabel(Double.toString(getHouse(0).getPrice()) + "     ");
		pricePanel.add(lblHP0);
		lblHP1 = new JLabel(Double.toString(getHouse(1).getPrice()) + "     ");
		pricePanel.add(lblHP1);
		lblHP2 = new JLabel(Double.toString(getHouse(2).getPrice()) + "     ");
		pricePanel.add(lblHP2);
		lblHP3 = new JLabel(
				Double.toString(getHouse(THREE).getPrice()) + "     ");
		pricePanel.add(lblHP3);
		lblHP4 = new JLabel(
				Double.toString(getHouse(FOUR).getPrice()) + "     ");
		pricePanel.add(lblHP4);
		lblHP5 = new JLabel(
				Double.toString(getHouse(FIVE).getPrice()) + "     ");
		pricePanel.add(lblHP5);
		
		Timer timer = new Timer();
		timer.schedule(new Economy(), ONE_HUNDRED, TWO_K);

		buyHouse0 = new JButton("Buy");
		buyHouse0.setBounds(TEN, 225, 61, 23);
		buyHouse0.addActionListener(this);
		buyHouse0.setActionCommand("b0");
		getFrame().getContentPane().add(buyHouse0);

		sellHouse0 = new JButton("Sell");
		sellHouse0.setBounds(TEN, 259, 61, 23);
		sellHouse0.addActionListener(this);
		sellHouse0.setActionCommand("s0");
		getFrame().getContentPane().add(sellHouse0);

		sellHouse1 = new JButton("Sell");
		sellHouse1.setBounds(81, 259, 61, 23);
		sellHouse1.addActionListener(this);
		sellHouse1.setActionCommand("s1");
		getFrame().getContentPane().add(sellHouse1);

		buyHouse1 = new JButton("Buy");
		buyHouse1.setBounds(81, 225, 61, 23);
		buyHouse1.addActionListener(this);
		buyHouse1.setActionCommand("b1");
		getFrame().getContentPane().add(buyHouse1);

		buyHouse2 = new JButton("Buy");
		buyHouse2.setBounds(148, 225, 61, 23);
		buyHouse2.addActionListener(this);
		buyHouse2.setActionCommand("b2");
		getFrame().getContentPane().add(buyHouse2);

		sellHouse2 = new JButton("Sell");
		sellHouse2.setBounds(148, 259, 61, 23);
		sellHouse2.addActionListener(this);
		sellHouse2.setActionCommand("s2");
		getFrame().getContentPane().add(sellHouse2);

		buyHouse3 = new JButton("Buy");
		buyHouse3.setBounds(219, 225, 63, 23);
		buyHouse3.addActionListener(this);
		buyHouse3.setActionCommand("b3");
		getFrame().getContentPane().add(buyHouse3);

		sellHouse3 = new JButton("Sell");
		sellHouse3.setBounds(219, 259, 63, 23);
		sellHouse3.addActionListener(this);
		sellHouse3.setActionCommand("s3");
		getFrame().getContentPane().add(sellHouse3);

		buyHouse4 = new JButton("Buy");
		buyHouse4.setBounds(292, 225, 61, 23);
		buyHouse4.addActionListener(this);
		buyHouse4.setActionCommand("b4");
		getFrame().getContentPane().add(buyHouse4);

		sellHouse4 = new JButton("Sell");
		sellHouse4.setBounds(292, 259, 61, 23);
		sellHouse4.addActionListener(this);
		sellHouse4.setActionCommand("s4");
		getFrame().getContentPane().add(sellHouse4);

		buyHouse5 = new JButton("Buy");
		buyHouse5.setBounds(363, 225, 61, 23);
		buyHouse5.addActionListener(this);
		buyHouse5.setActionCommand("b5");
		getFrame().getContentPane().add(buyHouse5);

		sellHouse5 = new JButton("Sell");
		sellHouse5.setBounds(363, 259, 61, 23);
		sellHouse5.addActionListener(this);
		sellHouse5.setActionCommand("s5");
		getFrame().getContentPane().add(sellHouse5);

		getFrame().getContentPane().add(pricePanel);
		getFrame().getContentPane().add(panel1);
		getFrame().getContentPane().add(panel);
		getFrame().getContentPane().add(panel2);

	}

	@Override
	public final void actionPerformed(final ActionEvent e) {

		String action = e.getActionCommand();

		if (action.equals("b0")) {
			if (!getHouse(0).getOwnershipState()) {
				model.buyHouse(0);
			}
		}
		if (action.equals("s0")) {
			if (getHouse(0).getOwnershipState()) {
				model.sellHouse(0);
			}
		}

		if (action.equals("b1")) {
			if (!getHouse(1).getOwnershipState()) {
				model.buyHouse(1);
			}
		}
		if (action.equals("s1")) {
			if (getHouse(1).getOwnershipState()) {
				model.sellHouse(1);
			}
		}

		if (action.equals("b2")) {
			if (!getHouse(2).getOwnershipState()) {
				model.buyHouse(2);
			}
		}
		if (action.equals("s2")) {
			if (getHouse(2).getOwnershipState()) {
				model.sellHouse(2);
			}
		}

		if (action.equals("b3")) {
			if (!getHouse(THREE).getOwnershipState()) {
				model.buyHouse(THREE);
			}
		}
		if (action.equals("s3")) {
			if (getHouse(THREE).getOwnershipState()) {
				model.sellHouse(THREE);
			}
		}

		if (action.equals("b4")) {
			if (!getHouse(FOUR).getOwnershipState()) {
				model.buyHouse(FOUR);
			}
		}
		if (action.equals("s4")) {
			if (getHouse(FOUR).getOwnershipState()) {
				model.sellHouse(FOUR);
			}
		}

		if (action.equals("b5")) {
			if (!getHouse(FIVE).getOwnershipState()) {
				model.buyHouse(FIVE);
			}
		}
		if (action.equals("s5")) {
			if (getHouse(FIVE).getOwnershipState()) {
				model.sellHouse(FIVE);
			}
		}

		if (action.equals("quit")) {
			System.exit(0);
		}
		if (action.equals("reset")) {
			this.frame.dispose();
			super.reset();
		}
		if (action.equals("settings")) {
			System.out.println("Settings");
		}

		lblWallet.setText("Wallet: $" + df.format(model.getWallet()));

		if (model.getWallet() >= TWO_K_00) {
			lblWallet.setText("you win!");
		}
	
	}

	/**
	 * @param i :index of the house
	 * @return the house at index i
	 */
	final House getHouse(final int i) {
		return model.getHouseList().get(i);
	}

	/**
	 * @return the frame
	 */
	final JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frameToSet : frame to set
	 */
	final void setFrame(final JFrame frameToSet) {
		this.frame = frameToSet;
	}

	/**
	 * 
	 * Economy of the housing market.
	 *
	 */
	class Economy extends TimerTask {

		/**
		 * Run function.
		 */
		public void run() {
			model.fluctuate();
			
			lblHP0.setText(Double.toString(getHouse(0).getPrice()) + "     ");
			lblHP1.setText(Double.toString(getHouse(1).getPrice()) + "     ");
			lblHP2.setText(Double.toString(getHouse(2).getPrice()) + "     ");
			lblHP3.setText(
					Double.toString(getHouse(THREE).getPrice()) + "     ");
			lblHP4.setText(
					Double.toString(getHouse(FOUR).getPrice()) + "     ");
			lblHP5.setText(
					Double.toString(getHouse(FIVE).getPrice()) + "     ");
		}
	}
}