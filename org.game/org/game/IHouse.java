package org.game;

/**
 * 
 * The House interface.
 *
 */
public interface IHouse {
	
	/**
	 * Whether or not the house is currently for sale.
	 * @return The state of ownership of a house.
	 */
	boolean getOwnershipState();
	
	/**
	 * Current price of the house.
	 * @return The price of the house.
	 */
	double getPrice();
	
	/**
	 * Int determining what type of house this is.
	 * 0: low cost
	 * 1: med cost
	 * 2: high cost
	 * @return The tier of the house.
	 */
	int getTier();
}
