package se.kth.iv1350.posbyprs.model;

import se.kth.iv1350.posbyprs.model.dto.SaleLogDTO;

/**
 * This class generates a receipt for a finished sale which contains
 * all available information about the sale.
 */
public class Receipt {
    SaleLogDTO saleLogDTO;
    
    /**
     * Stores the sale log.
     * @param saleLogDTO DTO containing all available information about the sale.
     */
    public void addSaleLog(SaleLogDTO saleLogDTO) {
        this.saleLogDTO = saleLogDTO;
    }
}
