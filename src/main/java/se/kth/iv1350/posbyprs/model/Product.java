package se.kth.iv1350.posbyprs.model;

import se.kth.iv1350.posbyprs.model.dto.ProductDTO;

/**
 * Contains all the available information about a specific product.
 */
public class Product {
    private String description;
    private double price;
    private int quantity;
    private double vatRate;
    private int identifier;
    private double priceInclVat;

    /**
     * 
     * @param productDTO A ProductDTO that contains the information which
     * is needed to construct Product. 
     */
    public Product(ProductDTO productDTO) {
        this.description = productDTO.getDescription();
        this.price = productDTO.getPrice();
        this.quantity = productDTO.getQuantity();
        this.vatRate = productDTO.getVatRate();
        this.identifier = productDTO.getIdentifier();
        this.priceInclVat = this.price + this.price * this.vatRate;
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

    /**
     * @return Product unit price (including VAT).
     */
    public double getPriceInclVat() {
        return priceInclVat;
    }

    /**
     * Changes the quantity of the current product.
     * 
     * @param quantity The quantity to be added.
     */
    public void addQuantity(int quantity) {
        this.quantity = this.quantity + quantity;
    }
    
    
    
    
    
    
}
