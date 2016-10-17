package org.game;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
	public House[] houseList;

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
		houseList = new House[6];
		Arrays.fill(houseList, null);
		//House[] housesToRemove = new House[6];
		houseGenerator(500, 0);
		houseGenerator(1000, 1);
		houseGenerator(700, 0);
			Thread.sleep(100);
		}

	/**
	 * 
	 * @param initialPrice : The initial price
	 * @param tier : the tier of the house
	 */
	public final void houseGenerator(final int initialPrice, final int tier) {
		House h = new House(initialPrice, tier);
		for(int i=0;i<houseList.length-1;i++)
		{
			if(houseList[i] == null)
			{
				houseList[i] = h;
			}
		}
	}

	/**
	 * 
	 * @param h : the house
	 */
	public final void buyHouse(final House h) {
		h.setOwnershipState(true);
	}
	
	public final void sellHouse(final House h) {
		h.setOwnershipState(false);
	}
}
