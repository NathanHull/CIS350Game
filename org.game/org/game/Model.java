package org.game;

<<<<<<< HEAD
import java.util.*;

public class Model {

	public ArrayList<House> houseList;

	public static void main(String[] args) throws InterruptedException {
		Model model = new Model();
	}

=======
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
>>>>>>> master
	public Model() throws InterruptedException {
		houseList = new ArrayList<House>();
		ArrayList<House> housesToRemove = new ArrayList<House>();
		houseGenerator(500, 0);
		houseGenerator(1000, 1);
		houseGenerator(700, 0);
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
		houseList.add(h);
	}

<<<<<<< HEAD
	public void buyHouse(House h) {
=======
	/**
	 * 
	 * @param h : the house
	 */
	public final void buyHouse(final House h) {
>>>>>>> master
		h.setOwnershipState(true);
	}

}
