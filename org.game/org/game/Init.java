package org.game;

import java.awt.EventQueue;

public class Init {

	/**
	 * Launch the application.
	 * 
	 * @param args
	 *            : the args
	 */
	public static void main(String[] args) {

		try {
			GUI window = new GUI();
			window.getFrame().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void reset() {
		try {
			GUI window = new GUI();
			window.getFrame().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
