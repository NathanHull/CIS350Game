package buyLowSellHigh;

public interface IHouse {
	
	/*
	 * Whether or not the house is currently for sale or the player's
	 */
	boolean forSale();
	
	/*
	 * Current cost of the house
	 */
	int cost();
	
	/*
	 * Int determining what type of house this is.
	 * 0: low cost
	 * 1: med cost
	 * 2: high cost
	 */
	int type();
}
