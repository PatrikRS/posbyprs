package se.kth.iv1350.posbyprs.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.posbyprs.model.dto.ProductDTO;
import se.kth.iv1350.posbyprs.model.dto.SaleInformationDTO;
import se.kth.iv1350.posbyprs.model.dto.SaleLogDTO;

/**
 * This class handles the general sale information for one individual sale.
 * @author Patrik
 */
public class Sale {
    private LocalTime timeOfSale;
    private Receipt receipt;
    private List<Product> productList = new ArrayList<>();
    private int productQuantity = 1;
    private double totalSaleCost = 0;
    SaleLogDTO saleLogDTO;
    
    /**
     * Creates a new instance of sale, fetches current time then calls
     * the constructor of Receipt.
     */
    public Sale() {
        timeOfSale = LocalTime.now();
        receipt = new Receipt();
    }
    
    /**
     * This method updates the total cost as well as the product list.
     * If a product is already present in the list, that product has its
     * quantity increased. If not, the product is added to the list.
     * 
     * @param productDTO The DTO representing the product to be added.
     * 
     * @return The running total of the sale (including VAT).
     */
    public SaleInformationDTO updateSale(ProductDTO productDTO) {
        double priceInclVat = productDTO.getPrice() +
                productDTO.getPrice() * productDTO.getVatRate();
        
        totalSaleCost += priceInclVat;
        
        for (int i = 0; i < productList.size(); i++)
        {
            if (isIdentifierMatched(i, productDTO.getIdentifier()))
            {
                productList.get(i).addQuantity(productQuantity);
                return new SaleInformationDTO(productDTO.getDescription(),
                                                priceInclVat, totalSaleCost);
            }
        }
        
        productList.add(new Product(productDTO));
        return new SaleInformationDTO(productDTO.getDescription(),
                                        priceInclVat, totalSaleCost);
    }
    
    /**
     * Checks if an identifier matches another identifier from a list.
     * 
     * @param index Index of the product in the list
     * which identifier is to be compared.
     * 
     * @param productIdentifier The identifier to be compared to the one
     * in the list.
     * 
     * @return Telling whether the identifiers matched or not.
     */
    private Boolean isIdentifierMatched(int index, int productIdentifier) {
        return productList.get(index).getIdentifier() == productIdentifier;
    }

    /**
     * Getter for the total sale cost.
     * 
     * @return The total sale cost (including VAT).
     */
    public double getTotalSaleCost() {
        return totalSaleCost;
    }
    
    /**
     * Creates a DTO with all information about the sale.
     * @param paidAmount Amount paid.
     * @param changeAmount Change to be provided to the customer.
     * @return DTO containing all available information about the sale.
     */
    public SaleLogDTO createSaleLog(double paidAmount, double changeAmount) {
        saleLogDTO = new SaleLogDTO(productList, timeOfSale,
                                    paidAmount, changeAmount);
        return saleLogDTO;
    }
    
    
}
