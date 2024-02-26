package bookstoreproject.sales;

import bookstoreproject.inventory.*;
import bookstoreproject.pricing.*;

public class Sales {

    private Inventory inventory;
    private Pricing bookPricing;
    private Pricing stationaryPricing;
    private Pricing penPricing;
    private Pricing pencilPricing;

    public Sales(Inventory inventory, Pricing bookPricing, Pricing stationaryPricing, Pricing penPricing, Pricing pencilPricing) {
        this.inventory = inventory;
        this.bookPricing = bookPricing;
        this.stationaryPricing = stationaryPricing;
        this.penPricing = penPricing;
        this.pencilPricing = pencilPricing;
    }

    public boolean makeSale(String productType, int quantity) {
        double price;

        switch(productType){
            case "Book":
                price = bookPricing.getPrice();
                break;
            case "Stationary":
                price = stationaryPricing.getPrice();
                break;
            case "Pen":
                price = penPricing.getPrice();
                break;
            case "Pencil":
                price = pencilPricing.getPrice();
                break;
            default:
                return false;
        }

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
