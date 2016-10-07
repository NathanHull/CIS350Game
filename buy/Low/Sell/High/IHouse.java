package buy.Low.Sell.High;

/**
 * 
 * This is the House Interface.
 *
 */
public interface IHouse {
	
	/**
	 * Whether or not the house is currently for sale.
	 * @return null
	 */
	boolean owned();
	
	/**
	 * Current price of the house.
	 * @return null
	 */
	int price();
	
	/**
	 * Int determining what type of house this is.
	 * 0: low cost
	 * 1: med cost
	 * 2: high cost
	 * @return null
	 */
	int tier();
}
