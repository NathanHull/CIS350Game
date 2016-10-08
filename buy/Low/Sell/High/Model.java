package buy.Low.Sell.High;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * This is the Model class.
 *
 */
public class Model {
	
	/**
	 * An array list of houses.
	 */
	private ArrayList<House> houseList = new ArrayList<House>();
	
	/**
	 * Constructor for the model.
	 */
	public Model() {
		
	}
	
	/**
	 * Updates the prices of the houses based on their tier.
	 * 
	 * @param houseArrayList : list of houses
	 */
	private void updatePrices(final ArrayList<House> houseArrayList) {
		final int minTier0 = 100;
		final int maxTier0 = 200;
		final int minTier1 = 500;
		final int maxTier1 = 2000;
		final int minTier2 = 10000;
		final int maxTier2 = 25000;
		int index;
		int newPriceToSet;
		/**
		tier 0- pricey sheds; price min/max: 800-1,500
		add tier 2 houses at $10,000
		tier 1- the vanishing American middle class; price min/max: 2,000-10,000
		add tier 3 houses at $100,000
		tier 2- Robber Barons; price min/max: 50,000-100,000
		Goal: 1 million
		
		implement by iterating through houses 
		adding either a static or dynamically
		generated index which is determined
		by the house tier
		**/
		Random random = new Random();
		
		for (House h : houseArrayList) {
		     if (h.getTier() == 0) {
		    	index = random.nextInt((maxTier0 - minTier0) + 1) + minTier0;
			 	if (random.nextBoolean()) {
				 	 newPriceToSet = h.getPrice() + index;
				     h.setPrice(newPriceToSet);
				 } else {
					 newPriceToSet = h.getPrice() - index;
				     h.setPrice(newPriceToSet);
				 }
		     }
			
		     if (h.getTier() == 1) {
		    	 index = random.nextInt((maxTier1 - minTier1) + 1) + minTier1;
		    	 if (random.nextBoolean()) {
		    		 newPriceToSet = h.getPrice() + index;
				     h.setPrice(newPriceToSet);
		    	 } else {
		    		 newPriceToSet = h.getPrice() - index;
				     h.setPrice(newPriceToSet);
		    	 }
		     }
			
		     if (h.getTier() == 2) {
		    	 index = random.nextInt((maxTier2 - minTier2) + 1) + minTier2;
		    	 if (random.nextBoolean()) {
		    		 newPriceToSet = h.getPrice() + index;
				     h.setPrice(newPriceToSet);
		    	 } else {
		    		 newPriceToSet = h.getPrice() - index;
				     h.setPrice(newPriceToSet);
		    	 }
		     }
		}
	}
	
	/** public void buyHouse(){
		change ownership and subtract price from player money
		if not enough money then don't do it
	}
	
	public void sellHouse(){
		above, vice versa
	}
	**/
}
