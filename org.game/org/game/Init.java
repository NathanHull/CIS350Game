package org.game;


/**
 * 
 * Init class.
 *
 */
abstract class Init {

	/**
	 * Launch the application.
	 * 
	 * @param args : the args
	 */
	public static void main(final String[] args) {

		try {
			GUI window = new GUI();
			window.getFrame().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reset the GUI.
	 */
	public static void reset() {
		try {
			GUI window = new GUI();
			window.getFrame().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
