package bookstoreproject.sales;

import bookstoreproject.inventory.*;
import bookstoreproject.pricing.*;

public class Sales {

    private Inventory inventory;
    private Pricing pricing;

    public Sales(Inventory inventory, Pricing pricing) {
        this.inventory = inventory;
        this.pricing = pricing;
    }

    public boolean makeSale(String productType, int quantity) {
        double price = pricing.getPrice(productType);
        boolean isAvailable = inventory.isAvailable(productType, quantity);

        if (isAvailable) {
            inventory.decrementStock(productType, quantity);
            
            // Update Sales Counter (assuming it's a static class)
            SalesCounter.updateTotalSales(price * quantity);
            SalesCounter.updateTotalUnits(quantity);
            return true;
        }

        return false;
    }
}
