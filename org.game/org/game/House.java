package org.game;

import java.util.Random;

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
			priceChange(true);
			this.lifetime++;
		} else {
			priceChange(false);
			this.lifetime++;
		}
		
		if(getLifetime() > getLifeCycles()){
			return true;
		}
		return false;
		
	}
	
	private void priceChange(boolean raisePrice){
		Random random = new Random();
		int index;

		if(this.getTier()==0){
			index = random.nextInt((maxTier0 - minTier0) + 1) + minTier0;
			
			if(raisePrice){
				this.price += index;
			} else {
				this.price -= index;
			}
		} else if(this.getTier()==1){
			index = random.nextInt((maxTier1 - minTier1) + 1) + minTier1;
			
			if(raisePrice){
				this.price += index;
			} else {
				this.price -= index;
			}
		} else {
			index = random.nextInt((maxTier2 - minTier2) + 1) + minTier2;
			
			if(raisePrice){
				this.price += index;
			} else {
				this.price -= index;
			}
		}
		return;
	}
	
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
		return lifecycles;
	}
	
}