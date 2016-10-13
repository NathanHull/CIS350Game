package org.game;

import java.util.*;

public class Model {

	public ArrayList<House> houseList;

	public static void main(String[] args) throws InterruptedException {
		Model model = new Model();
	}

	public Model() throws InterruptedException {
		houseList = new ArrayList<House>();
		ArrayList<House> housesToRemove = new ArrayList<House>();
		houseGenerator(500, 0);
		houseGenerator(1000, 1);
		houseGenerator(700, 0);
		while (!houseList.isEmpty()) {
			for (House h : houseList) {
				if(h.internalEconomy()){
					housesToRemove.add(h);
				}
				System.out.println("House price: " + h.getPrice());
				
			}
			Thread.sleep(100);
			houseList.removeAll(housesToRemove);
		}
		
		
	}

	public void houseGenerator(int initialPrice, int tier) {
		House h = new House(initialPrice, tier);
		houseList.add(h);
	}

	public void buyHouse(House h) {
		h.setOwnershipState(true);
	}

}
