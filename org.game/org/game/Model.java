package org.game;

import java.util.Arrays;

/**
 * 
 * House Model.
 *
 */
public class Model {

	/**
	 * ArrayList variables houseList.
	 */
	private House[] houseList;

	/**
	 * Int representing money in player's wallet.
	 */
	private int wallet;

	/**
	 * 
	 * @throws InterruptedException : Exception to throw when interrupted
	 */
	public Model() throws InterruptedException {
		houseList = new House[5];
		wallet = 1000;
		Arrays.fill(houseList, null);
		houseGenerator(500, 0);
		houseGenerator(1000, 1);
		houseGenerator(700, 0);
		houseGenerator(250, 0);
		houseGenerator(300, 1);
		houseGenerator(100, 0);
		Thread.sleep(100);
	}

	/**
	 * 
	 * @param initialPrice : The initial price
	 * @param tier : the tier of the house
	 */
	public final void houseGenerator(final int initialPrice, final int tier) {
		House h = new House(initialPrice, tier);
		for (int i = 0; i < houseList.length - 1; i++) {
			if (houseList[i] == null) {
				houseList[i] = h;
			}
		}
	}

	/**
	 * 
	 * @param h : the house
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
	 * @param h : the house
	 */
	public final void sellHouse(final House h) {
		if (h.getOwnershipState()) {
			wallet = wallet + h.getPrice();
			h.setOwnershipState(false);
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
	public final House[] getHouseList() {
		return houseList;
	}
}
