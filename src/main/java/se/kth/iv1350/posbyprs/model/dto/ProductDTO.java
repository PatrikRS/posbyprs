package se.kth.iv1350.posbyprs.model.dto;

import se.kth.iv1350.posbyprs.model.Product;

/**
 * Contains unchangeable information about a product. 
 */
public class ProductDTO {
    private final String description;
    private final double price;
    private final int quantity;
    private final double vatRate;
    private final int identifier;

    /**
     * Creates a new instance of a product DTO with specified information.
     * 
     * @param description Product description.
     * @param price Product unit price (excluding VAT).
     * @param quantity The quantity of the specific product.
     * @param vatRate The (percentage) rate of VAT for the specific product.
     * @param identifier A unique number which identifies a product.
     */
    public ProductDTO(String description, double price, int quantity, double vatRate, int identifier) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.vatRate = vatRate;
        this.identifier = identifier;
    }
    
    /**
     * Creates a new instance of a product DTO with specified information.
     * @param product Contains the needed information.
     */
    public ProductDTO(Product product) {
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.vatRate = product.getVatRate();
        this.identifier = product.getIdentifier();
    }
    
    /**
     * @return Product description.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * @return Product unit price (excluding VAT).
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * @return The quantity of the specific product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @return The (percentage) rate of VAT for the specific product.
     */
    public double getVatRate() {
        return vatRate;
    }

    /**
     * @return A unique number which identifies a product.
     */
    public int getIdentifier() {
        return identifier;
    }
    
    
}
