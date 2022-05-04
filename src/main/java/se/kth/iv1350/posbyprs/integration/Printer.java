package se.kth.iv1350.posbyprs.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.posbyprs.model.dto.ProductDTO;
import se.kth.iv1350.posbyprs.model.dto.SaleLogDTO;

/**
 * Receives information from the controller to forward to the printer.
 * In this program, it will be printed to system out.
 */
public class Printer {
    
    /**
     * Prints a receipt to system out.
     * 
     * @param saleLogDTO Contains the information needed for the receipt.
     */
    public void printReceipt(SaleLogDTO saleLogDTO) {
        
        System.out.println("-- Receipt --");
        System.out.println("Time of sale: " + saleLogDTO.getTimeOfSale());
        System.out.println("Total cost (incl. VAT): " + 
                                saleLogDTO.getTotalInclVat() + " SEK");
        System.out.println("Total cost (excl. VAT): " +
                                saleLogDTO.getTotalExVat() + " SEK");
        System.out.println("Total VAT amount: " +
                                saleLogDTO.getVatAmount() + " SEK");
        System.out.println("Paid amount: " + saleLogDTO.getPaidAmount());
        System.out.println("Change amount: " + saleLogDTO.getChangeAmount());
        System.out.println("-- Product list --");
        
        for (int i = 0; i < saleLogDTO.getProductList().size(); i++)
        {
            System.out.println(saleLogDTO.getProductList().get(i).getDescription()
            + " - " +  saleLogDTO.getProductList().get(i).getPrice() + " SEK - x"
            + saleLogDTO.getProductList().get(i).getQuantity());
        }
        
    }
}
