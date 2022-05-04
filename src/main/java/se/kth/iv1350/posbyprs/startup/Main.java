package se.kth.iv1350.posbyprs.startup;

import se.kth.iv1350.posbyprs.controller.Controller;
import se.kth.iv1350.posbyprs.integration.ExternalSystemCaller;
import se.kth.iv1350.posbyprs.integration.Printer;
import se.kth.iv1350.posbyprs.integration.ProductDB;
import se.kth.iv1350.posbyprs.integration.Register;
import se.kth.iv1350.posbyprs.view.View;

/**
 * This class contains the main method which initiates the program.
 */
public class Main {
    /**
     * The main method which initiates the program.
     * @param args No parameters are received in this method.
     */
    public static void main(String[] args) {
        ExternalSystemCaller extSysCall = new ExternalSystemCaller();
        ProductDB productDB = new ProductDB();
        Register register = new Register();
        Printer printer = new Printer();
        Controller contr = new Controller(extSysCall, productDB, register, printer);
        View view = new View(contr);
        view.runDummyExecution();
    }
}
