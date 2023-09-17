package bookstoreproject.sales;

public class SalesCounter {
    public static int totalSales = 0;
    
    public static void updateTotalSales(int value) {
        totalSales += value;
    }
}

