public class House{

	private int id;
	private int price;
	private int tier;
	private boolean owned;
	
	public House(int price, int tier, int id){
		this.id = id;
		this.tier=tier;
		this.price=price;
		this.owned=false;	// houses not owned by default
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
}