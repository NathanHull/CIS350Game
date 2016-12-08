package org.game;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * House Model.
 *
 */
public class Model {
	/**
	 * ONE_K.
	 */
	public static final int ONE_K = 1000;
	/**
	 * FIVE_HUNDRED.
	 */
	public static final int FIVE_HUNDRED = 500;
	/**
	 * ONE_HUNDRED.
	 */
	public static final int ONE_HUNDRED = 100;
	/**
	 * TWO_FIFTY.
	 */
	public static final int TWO_FIFTY = 250;
	/**
	 * SEVEN_FIFTY.
	 */
	public static final int SEVEN_FIFTY = 750;
	/**
	 * FIFTEEN_HUNDRED.
	 */
	public static final int FIFTEEN_HUNDRED = 1500;
	
	/**
	 * DECREASE_RATE.
	 */
	public static final double DECREASE_RATE = 0.90;
	/**
	 * INCREASE_RATE.
	 */
	public static final double INCREASE_RATE = 1.10;
	
	
	
	
	
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
	 */
	private List<House> housesToRemove;
	
	/**
	 * 
	 * @throws InterruptedException : Exception to throw when interrupted
	 */
	public Model() throws InterruptedException {
		houseList = new ArrayList<House>();
		housesToRemove = new ArrayList<House>();
		wallet = ONE_K;
		houseGenerator();
	}

	/**
	 * Generates the houses.
	 * 
	 */
	public final void houseGenerator() {
		houseList.add(new House(ONE_HUNDRED, 0));
		houseList.add(new House(TWO_FIFTY, 0));
		houseList.add(new House(FIVE_HUNDRED, 1));
		houseList.add(new House(SEVEN_FIFTY, 1));
		houseList.add(new House(ONE_K, 2));
		houseList.add(new House(FIFTEEN_HUNDRED, 2));
		for (int x = 0; x < houseList.size(); x++) {
			System.out.println(houseList.get(x).getPrice());
		}
	}

	/**
	 * 
	 * @param houseNum :the house
	 * 
	 */
	public final void buyHouse(final int houseNum) {
		if (wallet < houseList.get(houseNum).getPrice() 
				|| houseList.get(houseNum).getOwnershipState()) {
			return;
		}
		wallet = wallet - houseList.get(houseNum).getPrice();
		houseList.get(houseNum).setOwned(true);
		this.fluctuate();
	}

	/**
	 * 
	 * @param houseNum : the house
	 */
	public final void sellHouse(final int houseNum) {
		if (houseList.get(houseNum).getOwnershipState()) {
			wallet = wallet + houseList.get(houseNum).getPrice();
			houseList.get(houseNum).setOwned(false);
			this.fluctuate();
		}
	}
	
	/**
	 * Method that analyzes current market and fluctuates prices based on it.
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
					houseList.get(x).setPrice(
							houseList.get(x).getPrice() * DECREASE_RATE);
				} else {
					houseList.get(x).setPrice(
							houseList.get(x).getPrice() * INCREASE_RATE);
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
