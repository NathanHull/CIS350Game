package org.game;

<<<<<<< HEAD
import java.util.Arrays;
=======
<<<<<<< HEAD
import java.util.*;

public class Model {

	public ArrayList<House> houseList;

	public static void main(String[] args) throws InterruptedException {
		Model model = new Model();
	}

=======
import java.util.ArrayList;
>>>>>>> a2aae5945db1e76515c74468c82ea56a3527c64d

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
>>>>>>> master
	public Model() throws InterruptedException {
		houseList = new House[5];
		wallet = 1000;
		Arrays.fill(houseList, null);
		houseGenerator(500, 0);
		houseGenerator(1000, 1);
		houseGenerator(700, 0);
<<<<<<< HEAD
		houseGenerator(250, 0);
		houseGenerator(300, 1);
		houseGenerator(100, 0);
		Thread.sleep(100);
=======
		while (!houseList.isEmpty()) {
			for (House h : houseList) {
<<<<<<< HEAD
				h.internalEconomy();
				System.out.println("House price: " + h.getPrice());
				
			}
			Thread.sleep(1000);
=======
				if (h.internalEconomy()) {
					housesToRemove.add(h);
				}
				System.out.println("House price: " + h.getPrice());
				
			}
			Thread.sleep(100);
			houseList.removeAll(housesToRemove);
>>>>>>> master
		}
		
		
>>>>>>> a2aae5945db1e76515c74468c82ea56a3527c64d
	}

<<<<<<< HEAD
	public void houseGenerator(int initialPrice, int tier) {
=======
	/**
	 * 
	 * @param initialPrice : The initial price
	 * @param tier : the tier of the house
	 */
	public final void houseGenerator(final int initialPrice, final int tier) {
>>>>>>> master
		House h = new House(initialPrice, tier);
		for (int i = 0; i < houseList.length - 1; i++) {
			if (houseList[i] == null) {
				houseList[i] = h;
			}
		}
	}

<<<<<<< HEAD
	public void buyHouse(House h) {
=======
	/**
	 * 
	 * @param h : the house
	 */
	public final void buyHouse(final House h) {
<<<<<<< HEAD
		if (wallet < h.getPrice() || h.getOwnershipState()) {
			return;
		}
		
		wallet = wallet - h.getPrice();
=======
>>>>>>> master
>>>>>>> a2aae5945db1e76515c74468c82ea56a3527c64d
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
