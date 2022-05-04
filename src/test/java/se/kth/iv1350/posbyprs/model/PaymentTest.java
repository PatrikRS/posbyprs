package se.kth.iv1350.posbyprs.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author patri
 */
public class PaymentTest {

    


    @Test
    public void testGetChangeAmountSameValues() {
        System.out.println("getChangeAmount");
        Payment instance = new Payment(10, 10);
        double expResult = 0.0;
        double result = instance.getChangeAmount();
        assertEquals(expResult, result, "Difference between"
                + "same values are not zero.");
    }
    
    @Test
    public void testGetChangeAmountLargerPaid() {
        System.out.println("getChangeAmount");
        Payment instance = new Payment(10, 5);
        double expResult = 5.0;
        double result = instance.getChangeAmount();
        assertEquals(expResult, result, "Difference between"
                + "10 and 5 is not positive 5.");
    }
    
    @Test
    public void testGetChangeAmountZero() {
        System.out.println("getChangeAmount");
        Payment instance = new Payment(0, 0);
        double expResult = 0.0;
        double result = instance.getChangeAmount();
        assertEquals(expResult, result, "Difference between"
                + "0 and 0 is not 0.");
    }
    
    @Test
    public void testGetChangeSmallerPaid() {
        System.out.println("getChangeAmount");
        Payment instance = new Payment(5, 10);
        double expResult = -5.0;
        double result = instance.getChangeAmount();
        assertEquals(expResult, result, "Difference between"
                + "5 and 10 is not negative 5.");
    }
    
    
}
