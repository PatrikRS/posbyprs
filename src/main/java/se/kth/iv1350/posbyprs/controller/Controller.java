package se.kth.iv1350.posbyprs.controller;

import se.kth.iv1350.posbyprs.integration.ExternalSystemCaller;
import se.kth.iv1350.posbyprs.integration.Printer;
import se.kth.iv1350.posbyprs.integration.ProductDB;
import se.kth.iv1350.posbyprs.integration.Register;
import se.kth.iv1350.posbyprs.model.Payment;
import se.kth.iv1350.posbyprs.model.Sale;
import se.kth.iv1350.posbyprs.model.dto.SaleInformationDTO;
import se.kth.iv1350.posbyprs.model.dto.SaleLogDTO;

/**
 * This is the application's controller which handles all calls to
 * both the model and the integration. It receives all calls from
 * the view.
 */
public class Controller {
    private Sale sale;
    private ExternalSystemCaller extSysCall;
    private ProductDB productDB;
    private Register register;
    private SaleLogDTO saleLogDTO;
    private Printer printer;
    
    /**
     * Creates a new instance of Controller.
     * 
     * @param extSysCall Reference to ExternalSystemCaller.
     * @param productDB Reference to ProductDB.
     * @param register Reference to Register.
     * @param printer Reference to Printer.
     */
    public Controller(ExternalSystemCaller extSysCall, ProductDB productDB,
            Register register, Printer printer) {
        this.extSysCall = extSysCall;
        this.productDB = productDB;
        this.register = register;
        this.printer = printer;
    }
    
    /**
     * Initiates a new sale.
     */
    public void initiateNewSale() {
        sale = new Sale();
    }
    
    /**
     * Scans a product and retrieves information about it.
     * 
     * @param productIdentifier Unique identifier for the scanned product.
     * 
     * @return Collection of data to be displayed in the view.
     */
    public SaleInformationDTO scanProduct(int productIdentifier) {
        return sale.updateSale(productDB.getProductData(productIdentifier));
    }
    
    /**
     * Ends the sale and retrieves the total sale cost.
     * 
     * @return Total cost of the sale (including VAT).
     */
    public double endSale() {
        return sale.getTotalSaleCost();
    }
    
    /**
     * Registers payment and retrieves the change amount.
     * 
     * @param paidAmount The paid amount.
     * 
     * @param totalInclVat The total cost of the sale (including VAT).
     * 
     * @return The change amount to be provided to the client.
     */
    public double enterPayment(double paidAmount, double totalInclVat) {
        Payment payment = new Payment(paidAmount, totalInclVat);
        saleLogDTO = sale.createSaleLog(paidAmount, payment.getChangeAmount());
        
        extSysCall.sendInformationToExternalInventorySystem(saleLogDTO);
        extSysCall.sendInformationToExternalAccountingSystem(saleLogDTO);
        
        register.updateBalance(paidAmount, totalInclVat);
        
        printer.printReceipt(saleLogDTO);
        
        return payment.getChangeAmount();
    }
}
