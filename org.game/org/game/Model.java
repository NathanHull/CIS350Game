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
	 * Double representing money in player's wallet.
	 */
	private double wallet;

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
		houseGenerator();
	}

	/**
	 * 
	 * @param initialPrice
	 *            : The initial price
	 * @param tier
	 *            : the tier of the house
	 */
	public final void houseGenerator() {
		houseList.add(new House(100, 0));
		houseList.add(new House(250, 0));
		houseList.add(new House(500, 1));
		houseList.add(new House(750, 1));
		houseList.add(new House(1000, 2));
		houseList.add(new House(1500, 2));
		for(int x = 0; x < houseList.size(); x++) {
			System.out.println(houseList.get(x).getPrice());
		}
	}

	/**
	 * 
	 * @param h :
	 * 			 the house
	 * 
	 */
	public final void buyHouse(final int houseNum) {
		if (wallet < houseList.get(houseNum).getPrice() || houseList.get(houseNum).getOwnershipState()) {
			return;
		}

		wallet = wallet - houseList.get(houseNum).getPrice();
		houseList.get(houseNum).setOwned(true);
		this.fluctuate();
	}

	/**
	 * 
	 * @param h
	 *            : the house
	 */
	public final void sellHouse(final int houseNum) {
		if (houseList.get(houseNum).getOwnershipState()) {
			wallet = wallet + houseList.get(houseNum).getPrice();
			houseList.get(houseNum).setOwned(false);
			this.fluctuate();
		}
	}
	
	/**
	 * Method that analyzes current market and fluctuates prices based on it
	 * 
	 */
	public final void fluctuate() {
		int ctrAvailable = 0, ctrUnavailable = 0;
		
		for (int x = 0; x < houseList.size(); x++) {
			if (houseList.get(x).getOwnershipState()) {
				ctrUnavailable++;
			} else {
				ctrAvailable++;
			}
		}
		
		if (ctrUnavailable > ctrAvailable) {
			for (int x = 0; x < houseList.size(); x++) {
				if (!houseList.get(x).getOwnershipState()) {
					houseList.get(x).setPrice(houseList.get(x).getPrice() * 0.90);
				} else {
					houseList.get(x).setPrice(houseList.get(x).getPrice() * 1.10);
				}
			}
		}
	}

	/**
	 * 
	 * @return wallet value
	 */
	public final double getWallet() {
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
