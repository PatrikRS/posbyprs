package se.kth.iv1350.posbyprs.model.dto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.posbyprs.model.Product;

/**
 * DTO containing all available information about the sale.
 */
public class SaleLogDTO {
    private final List<ProductDTO> productList = new ArrayList<>();
    private final double totalExVat;
    private final double totalInclVat;
    private final double vatAmount;
    private final double paidAmount;
    private final double changeAmount;
    private final LocalTime timeOfSale;
    
    /**
     * Creates a new instance of SaleLogDTO.
     * 
     * @param productList List of products in sale.
     * @param timeOfSale Time of sale.
     * @param paidAmount Amount paid.
     * @param changeAmount Change to be provided to the customer.
     */
    public SaleLogDTO(List<Product> productList, LocalTime timeOfSale,
                      double paidAmount, double changeAmount) {
        this.timeOfSale = timeOfSale;
        this.paidAmount = paidAmount;
        this.changeAmount = changeAmount;
        double totalExVatHolder = 0;
        double totalInclVatHolder = 0;
        double vatAmountHolder = 0;
        
        for (int i = 0; i < productList.size(); i++)
        {
            this.productList.add(new ProductDTO(productList.get(i)));
            totalExVatHolder += productList.get(i).getPrice() *
                                productList.get(i).getQuantity();
            totalInclVatHolder += productList.get(i).getPriceInclVat()*
                                productList.get(i).getQuantity();
            vatAmountHolder += productList.get(i).getPrice() *
                                productList.get(i).getVatRate() *
                                productList.get(i).getQuantity();
        }
        this.totalExVat = totalExVatHolder;
        this.totalInclVat = totalInclVatHolder;
        this.vatAmount = vatAmountHolder;
    }

    /**
     * Getter for the product list.
     * @return A list of products.
     */
    public List<ProductDTO> getProductList() {
        return productList;
    }

    /**
     * Getter for the total sale amount (excluding VAT).
     * @return The total amount of the sale (excluding VAT).
     */
    public double getTotalExVat() {
        return totalExVat;
    }

    /**
     * Getter for the total sale amount (including VAT).
     * @return The total amount of the sale (including VAT).
     */
    public double getTotalInclVat() {
        return totalInclVat;
    }

    /**
     * Getter for the total VAT amount of the sale.
     * @return The total VAT amount of the sale.
     */
    public double getVatAmount() {
        return vatAmount;
    }

    /**
     * Getter for the amount paid by the customer.
     * @return Amount paid by the customer.
     */
    public double getPaidAmount() {
        return paidAmount;
    }

    /**
     * Getter for the change to be provided to the customer.
     * @return Change to be provided to the customer.
     */
    public double getChangeAmount() {
        return changeAmount;
    }

    /**
     * Getter for the time of the sale.
     * @return Time of the sale.
     */
    public LocalTime getTimeOfSale() {
        return timeOfSale;
    }
    
    
    
}