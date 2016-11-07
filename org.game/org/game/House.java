package org.game;

import java.util.Random;

<<<<<<< HEAD
public class House implements IHouse{

	public int price;
	public int tier;
	public boolean owned;
	private int lifecycles;
	private int lifetime;

	private int minTier0=100;
	private int maxTier0=200;
	private int minTier1=500;
	private int maxTier1=2000;
	private int minTier2=10000;
	private int maxTier2=25000;
	
	
	public House(int price, int tier){
		Random random = new Random();
		this.tier=tier;
		this.price=price;
		this.owned=false;	// houses not owned by default
		this.lifecycles = random.nextInt(20) + 20;
		this.lifetime=0;
	}
	
	public boolean internalEconomy(){
		
		if(this.lifetime <= 15){
=======
/**
 * 
 * The House class that implements the House Interface.
 *
 */
public class House implements IHouse {

	/**
	 * The price of the house.
	 */
	private int price;
	/**
	 * The house tier.
	 */
	private int tier;
	/**
	 * Indicated if the house is owned.
	 */
	private boolean owned;
	/**
	 * The cycle of the house.
	 */
	private int lifecycles;
	/**
	 * The lifetime of a house.
	 */
	private int lifetime;

	/**
	 * Minimum value for tier zero.
	 */
	private final int minTier0 = 100;
	/**
	 * Maximum value for tier zero.
	 */
	private final int maxTier0 = 200;
	/**
	 * Minimum value for tier one.
	 */
	private final int minTier1 = 500;
	/**
	 * Maximum value for tier one.
	 */
	private final int maxTier1 = 2000;
	/**
	 * Minimum value for tier two.
	 */
	private final int minTier2 = 10000;
	/**
	 * Maximum value for tier two.
	 */
	private final int maxTier2 = 25000;
	
	/**
	 * 
	 * @param hPrice : price of the house
	 * @param hTier : tier of the house
	 */
	public House(final int hPrice, final int hTier) {
		Random random = new Random();
		this.tier = hTier;
		this.price = hPrice;
		this.owned = false;	// houses not owned by default
		this.lifecycles = random.nextInt(20) + 20;
		this.lifetime = 0;
	}
	
	/**
	 * 
	 * @return false
	 */
	public final boolean internalEconomy() {
		
		if (this.lifetime <= 15) {
>>>>>>> master
			priceChange(true);
			this.lifetime++;
		} else {
			priceChange(false);
			this.lifetime++;
		}
		
<<<<<<< HEAD
		if(getLifetime() > getLifeCycles()){
=======
		if (getLifetime() > getLifeCycles()) {
>>>>>>> master
			return true;
		}
		return false;
		
	}
	
<<<<<<< HEAD
	private void priceChange(boolean raisePrice){
		Random random = new Random();
		int index;

		if(this.getTier()==0){
			index = random.nextInt((maxTier0 - minTier0) + 1) + minTier0;
			
			if(raisePrice){
=======
	/**
	 * 
	 * @param raisePrice : Indicate if the the price is being raised.
	 */
	private void priceChange(final boolean raisePrice) {
		Random random = new Random();
		int index;

		if (this.getTier() == 0) {
			index = random.nextInt((maxTier0 - minTier0) + 1) + minTier0;
			
			if (raisePrice) {
>>>>>>> master
				this.price += index;
			} else {
				this.price -= index;
			}
<<<<<<< HEAD
		} else if(this.getTier()==1){
			index = random.nextInt((maxTier1 - minTier1) + 1) + minTier1;
			
			if(raisePrice){
=======
		} else if (this.getTier() == 1) {
			index = random.nextInt((maxTier1 - minTier1) + 1) + minTier1;
			
			if (raisePrice) {
>>>>>>> master
				this.price += index;
			} else {
				this.price -= index;
			}
		} else {
			index = random.nextInt((maxTier2 - minTier2) + 1) + minTier2;
			
<<<<<<< HEAD
			if(raisePrice){
=======
			if (raisePrice) {
>>>>>>> master
				this.price += index;
			} else {
				this.price -= index;
			}
		}
		return;
	}
	
<<<<<<< HEAD
	public int getPrice(){
		return price;
	}
	
	public int getTier(){
		return tier;
	}
	
	public boolean getOwnershipState(){
		return owned;
	}
	
	public void setPrice(int price){
		this.price=price;
	}
	
	public void setTier(int tier){
		this.tier=tier;
	}
	
	public void setOwnershipState(boolean state){
		this.owned=state;
	}

	public int getLifetime(){
		return lifetime;
	}
	
	public int getLifeCycles(){
=======
	/**
	 * @return price : The price of the house.
	 */
	public final int getPrice() {
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
	 * @param hPrice : The price for which to set the house.
	 */
	public final void setPrice(final int hPrice) {
		this.price = hPrice;
	}
	
	/**
	 * 
	 * @param hTier : The tier for which to set the house.
	 */
	public final void setTier(final int hTier) {
		this.tier = hTier;
	}
	
	/**
	 * 
	 * @param state : The state for which to set the house.
	 */
	public final void setOwnershipState(final boolean state) {
		this.owned = state;
	}

	/**
	 * 
	 * @return lifetime
	 */
	public final int getLifetime() {
		return lifetime;
	}
	
	/**
	 * 
	 * @return lifecycles
	 */
	public final int getLifeCycles() {
>>>>>>> master
		return lifecycles;
	}
	
}