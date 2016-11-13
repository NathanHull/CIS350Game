package org.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModelTest {

	@Test
	public void modelConstructor() throws InterruptedException {
		Model model = new Model();
		assertEquals(model.getHouseList().get(0).getPrice(), 500);
	}
	
	@Test
	public void buyHouseNoMoney() throws InterruptedException {
		Model model = new Model();
		model.getHouseList().get(0).setPrice(99999);
		model.buyHouse(model.getHouseList().get(0));
		assertEquals(model.getHouseList().get(0).getOwnershipState(), false);
	}
	
	@Test
	public void buyHouseOwned() throws InterruptedException {
		Model model = new Model();
		model.getHouseList().get(0).setPrice(500);
		model.buyHouse(model.getHouseList().get(0));
		assertEquals(model.getHouseList().get(0).getOwnershipState(), true);
		model.buyHouse(model.getHouseList().get(0));
		assertEquals(model.getHouseList().get(0).getOwnershipState(), true);
	}
	
	@Test
	public void buyHouseWithMoney() throws InterruptedException {
		Model model = new Model();
		model.getHouseList().get(0).setPrice(500);
		model.buyHouse(model.getHouseList().get(0));
		assertEquals(model.getHouseList().get(0).getOwnershipState(), true);
	}
	
	@Test
	public void sellHouseOwned() throws InterruptedException {
		Model model = new Model();
		model.buyHouse(model.getHouseList().get(0));
		model.sellHouse(model.getHouseList().get(0));
		assertEquals(model.getHouseList().get(0).getOwnershipState(), false);
	}
	
	@Test
	public void sellHouseNotOwned() throws InterruptedException {
		Model model = new Model();
		model.sellHouse(model.getHouseList().get(0));
		assertEquals(model.getHouseList().get(0).getOwnershipState(), false);
	}
	
	@Test
	public void walletValueCheck() throws InterruptedException {
		Model model = new Model();
		assertEquals(model.getWallet(), 1000);
		model.buyHouse(model.getHouseList().get(0));
		assertEquals(model.getWallet(), 500);
		model.sellHouse(model.getHouseList().get(0));
		model.sellHouse(model.getHouseList().get(0));
		assertEquals(model.getWallet(), 1000);
	}
}
