package org.game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * ModelTest.
 *
 */
public class ModelTest {
	
	/**
	 * FIVE_HUNDRED.
	 */
	public static final int FIVE_HUNDRED = 500;
	/**
	 * ONE_K.
	 */
	public static final int ONE_K = 1000;
	/**
	 * FIVE_NINES.
	 */
	public static final int FIVE_NINES = 99999;
	
	
	
	/**
	 * 
	 * @throws InterruptedException : exception
	 */
	@Test
	final void modelConstructor() throws InterruptedException {
		Model model = new Model();
		assertEquals(model.getHouseList().get(0).getPrice(), FIVE_HUNDRED);
	}
	
	/**
	 * 
	 * @throws InterruptedException : exception
	 */
	@Test
	final void buyHouseNoMoney() throws InterruptedException {
		Model model = new Model();
		model.getHouseList().get(0).setPrice(FIVE_NINES);
		model.buyHouse(0);
		assertEquals(model.getHouseList().get(0).getOwnershipState(), false);
	}
	
	/**
	 * 
	 * @throws InterruptedException : exception
	 */
	@Test
	final void buyHouseOwned() throws InterruptedException {
		Model model = new Model();
		model.getHouseList().get(0).setPrice(FIVE_HUNDRED);
		model.buyHouse(0);
		assertEquals(model.getHouseList().get(0).getOwnershipState(), true);
		model.buyHouse(0);
		assertEquals(model.getHouseList().get(0).getOwnershipState(), true);
	}
	
	/**
	 * 
	 * @throws InterruptedException : exception
	 */
	@Test
	final void buyHouseWithMoney() throws InterruptedException {
		Model model = new Model();
		model.getHouseList().get(0).setPrice(FIVE_HUNDRED);
		model.buyHouse(0);
		assertEquals(model.getHouseList().get(0).getOwnershipState(), true);
	}
	
	/**
	 * 
	 * @throws InterruptedException : exception
	 */
	@Test
	final void sellHouseOwned() throws InterruptedException {
		Model model = new Model();
		model.buyHouse(0);
		model.sellHouse(0);
		assertEquals(model.getHouseList().get(0).getOwnershipState(), false);
	}
	
	/**
	 * 
	 * @throws InterruptedException : exception
	 */
	@Test
	final void sellHouseNotOwned() throws InterruptedException {
		Model model = new Model();
		model.sellHouse(0);
		assertEquals(model.getHouseList().get(0).getOwnershipState(), false);
	}
	
	/**
	 * 
	 * @throws InterruptedException : exception
	 */
	@Test
	final void walletValueCheck() throws InterruptedException {
		Model model = new Model();
		assertEquals(model.getWallet(), ONE_K);
		model.buyHouse(0);
		assertEquals(model.getWallet(), FIVE_HUNDRED);
		model.sellHouse(0);
		model.sellHouse(0);
		assertEquals(model.getWallet(), ONE_K);
	}
}
