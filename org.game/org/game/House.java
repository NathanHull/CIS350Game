package org.game;

import java.util.Random;

/**
 * 
 * The House class that implements the House Interface.
 *
 */
public class House implements IHouse {

	/**
	 * The price of the house.
	 */
	private double price;
	/**
	 * The house tier.
	 */
	private int tier;
	/**
	 * Indicated if the house is owned.
	 */
	private boolean owned;

	/**
	 * Minimum value for tier zero.
	 */
	private final double minTier0 = 100;
	/**
	 * Maximum value for tier zero.
	 */
	private final double maxTier0 = 200;
	/**
	 * Minimum value for tier one.
	 */
	private final double minTier1 = 500;
	/**
	 * Maximum value for tier one.
	 */
	private final double maxTier1 = 2000;
	/**
	 * Minimum value for tier two.
	 */
	private final double minTier2 = 10000;
	/**
	 * Maximum value for tier two.
	 */
	private final double maxTier2 = 25000;

	/**
	 * 
	 * @param hPrice
	 *            : price of the house
	 * @param hTier
	 *            : tier of the house
	 */
	public House(final double hPrice, final int hTier) {
		Random random = new Random();
		this.tier = hTier;
		this.price = hPrice;
		this.owned = false; // houses not owned by default
	}


	/**
	 * @return price : The price of the house.
	 */
	public final double getPrice() {
		return price;
	}

	/**
	 * @return tier : The tier of the house.
	 */
	public final int getTier() {
		return tier;
	}

	/**
	 * @return owned : The ownership status of the house.
	 */
	public final boolean getOwnershipState() {
		return owned;
	}

	/**
	 * 
	 * @param hPrice
	 *            : The price for which to set the house.
	 */
	public final void setPrice(final double hPrice) {
		this.price = hPrice;
	}

	/**
	 * 
	 * @param hTier
	 *            : The tier for which to set the house.
	 */
	public final void setTier(final int hTier) {
		this.tier = hTier;
	}

	/**
	 * 
	 * @param state
	 *            : The state for which to set the house.
	 */
	public final void setOwned(final boolean state) {
		this.owned = state;
	}

}