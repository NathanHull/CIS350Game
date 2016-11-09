package org.game;

import java.util.*;
import java.util.ArrayList;

/**
 * 
 * House Model.
 *
 */
public class Model {

	/**
	 * ArrayList variables houseList.
	 */
	private ArrayList<House> houseList;

	/**
	 * Int representing money in player's wallet.
	 */
	private int wallet;

	/**
	 * 
	 * @throws InterruptedException
	 *             : Exception to throw when interrupted
	 */

	private List<House> housesToRemove;

	public Model() throws InterruptedException {
		houseList = new ArrayList<House>();
		housesToRemove = new ArrayList<House>();
		wallet = 1000;
		houseGenerator(500, 0);
		houseGenerator(1000, 1);
		houseGenerator(700, 0);
		houseGenerator(250, 0);
		houseGenerator(300, 1);
		houseGenerator(100, 0);
	}

	/**
	 * 
	 * @param initialPrice
	 *            : The initial price
	 * @param tier
	 *            : the tier of the house
	 */
	public final void houseGenerator(final int initialPrice, final int tier) {

		House h = new House(initialPrice, tier);
		houseList.add(h);
	}

	/**
	 * 
	 * @param h :
	 * 			 the house
	 * 
	 */
	public final void buyHouse(final House h) {
		if (wallet < h.getPrice() || h.getOwnershipState()) {
			return;
		}

		wallet = wallet - h.getPrice();
		h.setOwnershipState(true);
	}

	/**
	 * 
	 * @param h
	 *            : the house
	 */
	public final void sellHouse(final House h) {
		if (h.getOwnershipState()) {
			wallet = wallet + h.getPrice();
			houseList.remove(h);
		}
	}

	/**
	 * 
	 * @return wallet value
	 */
	public final int getWallet() {
		return wallet;
	}

	/**
	 * 
	 * @return houseList
	 */
	public final ArrayList<House> getHouseList() {
		return houseList;
	}
}
