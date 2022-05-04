package se.kth.iv1350.posbyprs.model.dto;

/**
 * Contains unchangeable information about a sale. The information provided
 * is intended to be shown in the view.
 */
public class SaleInformationDTO {
    private final String description;
    private final double priceInclVat;
    private final double runningTotal;

    /**
     * @param description Description of the product which was most
     * recently scanned.
     * @param priceInclVat Price including VAT of the most recently
     * scanned product.
     * @param runningTotal The total cost (including VAT) of the sale (so far).
     */
    public SaleInformationDTO(String description, double priceInclVat, double runningTotal) {
        this.description = description;
        this.priceInclVat = priceInclVat;
        this.runningTotal = runningTotal;
    }
    
    /**
     * @return Description of the product which was most recently scanned.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return Price including VAT of the most recently scanned product.
     */
    public double getPriceInclVat() {
        return priceInclVat;
    }

    /**
     * @return The total cost (including VAT) of the sale (so far).
     */
    public double getRunningTotal() {
        return runningTotal;
    }
    
    
}
