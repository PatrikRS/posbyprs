package se.kth.iv1350.posbyprs.model;

/**
 * Information regarding one payment received.
 */
public class Payment {
    private double paidAmount;
    private double changeAmount;
    
    /**
     * Creates a new instance of Payment.
     * 
     * @param paidAmount The amount paid.
     * @param totalInclVat The total cost of the sale.
     */
    public Payment(double paidAmount, double totalInclVat) {
        this.paidAmount = paidAmount;
        this.changeAmount = paidAmount - totalInclVat;
    }

    /**
     * @return The change to be provided to the customer.
     */
    public double getChangeAmount() {
        return changeAmount;
    }
    
    
    
}
