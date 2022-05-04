package se.kth.iv1350.posbyprs.view;

import se.kth.iv1350.posbyprs.controller.Controller;
import se.kth.iv1350.posbyprs.model.dto.SaleInformationDTO;

/**
 * This class represents the entire view of the program. All system calls
 * will be hardcoded here.
 * @author Patrik
 */
public class View {
    private Controller contr;
    
    /**
     * Creates a new instance of the view which makes calls to the
     * specified controller.
     * 
     * @param contr The controller which receives the calls.
     */
    public View(Controller contr) {
        this.contr = contr;
    }
    
    /**
     * Simulates an execution of the program without user input.
     */
    public void runDummyExecution() {
        SaleInformationDTO saleInfo;
        contr.initiateNewSale();
        System.out.println("New sale initiated.");
        saleInfo = contr.scanProduct(121);
        displaySaleInfo(saleInfo);
        saleInfo = contr.scanProduct(857);
        displaySaleInfo(saleInfo);
        saleInfo = contr.scanProduct(544);
        displaySaleInfo(saleInfo);
        saleInfo = contr.scanProduct(449);
        displaySaleInfo(saleInfo);
        saleInfo = contr.scanProduct(255);
        displaySaleInfo(saleInfo);
        saleInfo = contr.scanProduct(449);
        displaySaleInfo(saleInfo);
        saleInfo = contr.scanProduct(857);
        displaySaleInfo(saleInfo);
        
        double totalInclVat = contr.endSale();
        System.out.println("-- Sale ended --");
        System.out.println("Total cost: " + totalInclVat);
        System.out.println();
        
        double changeAmount = contr.enterPayment(200, totalInclVat);
        System.out.println("Change: " + changeAmount);
        
    }
    
    /**
     * Method for printing the information stored in saleInfo.
     * 
     * @param saleInfo DTO with sale information to be printed.
     */
    private void displaySaleInfo(SaleInformationDTO saleInfo) {
        System.out.println("Item scanned successfully.\n");
        System.out.println("Description: " + saleInfo.getDescription());
        System.out.println("Price: " + saleInfo.getPriceInclVat());
        System.out.println("Total: " + saleInfo.getRunningTotal() + "\n");
    }
}
