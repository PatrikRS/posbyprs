package se.kth.iv1350.posbyprs.integration;

/**
 * Represents the register.
 */
public class Register {
    private double balance;
    
    /**
     * Updates the balance in the register.
     * 
     * @param paidAmount Amount paid.
     * @param totalCostInclVat Total sale cost.
     */
    public void updateBalance(double paidAmount, double totalCostInclVat) {
        balance += paidAmount - totalCostInclVat;
    }
}
