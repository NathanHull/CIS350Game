package org.game;

/**
 * 
 * The interface of the House class.
 *
 */
public interface IHouse {
	
	/**
	 * @return Whether or not the house is currently for sale.
	 */
	boolean getOwnershipState();
	
	/**
	 * @return Current price of the house
	 */
	int getPrice();
	
	/**
	 * @return Int determining what type of house this is.
	 * 0: low cost
	 * 1: med cost
	 * 2: high cost
	 */
	int getTier();
}
