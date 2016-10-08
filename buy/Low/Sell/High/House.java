package buy.Low.Sell.High;
/**
 * 
 * The House class implements IHouse.
 *
 */
public abstract class House implements IHouse {

	/**
	 * The id of the house.
	 */
	private int id;
	
	/**
	 * The price of the house.
	 */
	private int price;
	
	/**
	 * The tier of the house.
	 */
	private int tier;
	
	/**
	 * The state of the house (owned / not owned).
	 */
	private boolean owned;
	
	/**
	 * 
	 * @param housePrice : The house price
	 * @param houseTier : The house tier
	 * @param houseId : The house id
	 */
	public House(final int housePrice, final int houseTier, final int houseId) {
		this.id = houseId;
		this.tier = houseTier;
		this.price = housePrice;
		this.owned = false;	// houses not owned by default
	}
	
	/**
	 * 
	 * @return the id of the house
	 */
	public final int getId() {
		return id;
	}
	
	/**
	 * 
	 * @return the price of the house
	 */
	public final int getPrice() {
		return price;
	}
	
	/**
	 * 
	 * @return the tier of the house
	 */
	public final int getTier() {
		return tier;
	}
	
	/**
	 * 
	 * @return if the house is owed
	 */
	public final boolean getOwnershipState() {
		return owned;
	}
	
	/**
	 * 
	 * @param housePrice : the price of the house
	 */
	public final void setPrice(final int housePrice) {
		this.price = housePrice;
	}
	
	/**
	 * 
	 * @param houseTier : the tier of the house
	 */
	public final void setTier(final int houseTier) {
		this.tier = houseTier;
	}
	
	/**
	 * 
	 * @param state : a flag for the current state of the house
	 */
	public final void setOwnershipState(final boolean state) {
		this.owned = state;
	}
}