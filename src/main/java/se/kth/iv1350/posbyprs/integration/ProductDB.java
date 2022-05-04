package se.kth.iv1350.posbyprs.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.posbyprs.model.dto.ProductDTO;

/**
 * This class would normally communicate with the product database.
 * In this version of the program, this class represents the actual database.
 */
public class ProductDB {
    private List<ProductDTO> productList = new ArrayList<>();
    
    /**
     * Creates a new instance of ProductDB with sample items in it for this
     * version of the program.
     */
    public ProductDB() {
        productList.add(new ProductDTO("Whole milk", 10, 1, 0.25, 544));
        productList.add(new ProductDTO("Broccoli", 15, 1, 0.12, 255));
        productList.add(new ProductDTO("Painkillers", 60, 1, 0.06, 121));
        productList.add(new ProductDTO("Flour", 22, 1, 0.25, 857));
        productList.add(new ProductDTO("Chocolate", 19, 1, 0.25, 449));
    }
    
    /**
     * Checks for a matching product in a list.
     * 
     * @param productIdentifier Unique identifier for a product, used to
     * determine match.
     * 
     * @return The product with matching identifier (null if no match).
     */
    public ProductDTO getProductData(int productIdentifier) {
        for (int i = 0; i < productList.size(); i++)
        {
            if (isIdentifierMatched(i, productIdentifier))
                return productList.get(i);
        }
        return null;
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
}
