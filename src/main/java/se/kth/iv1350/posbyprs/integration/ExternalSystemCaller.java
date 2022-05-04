package se.kth.iv1350.posbyprs.integration;

import se.kth.iv1350.posbyprs.model.dto.SaleLogDTO;

/**
 * Receives information from the controller to forward to external systems.
 */
public class ExternalSystemCaller {
    
    /**
     * Receives information from the controller and forwards it to the
     * external inventory system (omitted in this version).
     * 
     * @param saleLogDTO All available information about the sale.
     */
    public void sendInformationToExternalInventorySystem(SaleLogDTO saleLogDTO) {
        // External systems omitted in this version.
    }

    /**
     * Receives information from the controller and forwards it to the
     * external accounting system (omitted in this version).
     * 
     * @param saleLogDTO All available information about the sale.
     */
    public void sendInformationToExternalAccountingSystem(SaleLogDTO saleLogDTO) {
        // External systems omitted in this version.
    }
}
