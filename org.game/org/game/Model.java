package org.game;

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
	 * 
	 * @param args : arguments
	 * @throws InterruptedException : Exception to throw when interrupted
	 */
	public static void main(final String[] args) throws InterruptedException {
		Model model = new Model();
	}

	/**
	 * 
	 * @throws InterruptedException : Exception to throw when interrupted
	 */
	public Model() throws InterruptedException {
		houseList = new ArrayList<House>();
		ArrayList<House> housesToRemove = new ArrayList<House>();
		houseGenerator(500, 0);
		houseGenerator(1000, 1);
		houseGenerator(700, 0);
		while (!houseList.isEmpty()) {
			for (House h : houseList) {
				if (h.internalEconomy()) {
					housesToRemove.add(h);
				}
				System.out.println("House price: " + h.getPrice());
				
			}
			Thread.sleep(100);
			houseList.removeAll(housesToRemove);
		}
		
		
	}

	/**
	 * 
	 * @param initialPrice : The initial price
	 * @param tier : the tier of the house
	 */
	public final void houseGenerator(final int initialPrice, final int tier) {
		House h = new House(initialPrice, tier);
		houseList.add(h);
	}

	/**
	 * 
	 * @param h : the house
	 */
	public final void buyHouse(final House h) {
		h.setOwnershipState(true);
	}

}
