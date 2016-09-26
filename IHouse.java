package buyLowSellHigh;

public interface IHouse {
	
	/*
	 * Whether or not the house is currently for sale
	 */
	boolean owned();
	
	/*
	 * Current price of the house
	 */
	int price();
	
	/*
	 * Int determining what type of house this is.
	 * 0: low cost
	 * 1: med cost
	 * 2: high cost
	 */
	int tier();
}
