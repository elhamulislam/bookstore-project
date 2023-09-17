package bookstoreproject.pricing;

public class Pricing {

    private double bookPrice = 10.0;
    private double stationaryPrice = 2.0;
    private double pencilPrice = 1.0;
    private double penPrice = 1.5;

    public double getPrice(String productType) {
        switch (productType) {
            case "Book":
                return bookPrice;
            case "Stationary":
                return stationaryPrice;
            case "Pencil":
                return pencilPrice;
            case "Pen":
                return penPrice;
            default:
                return 0.0;
        }
    }
}

