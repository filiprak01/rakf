package Tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StringCalculatorTests {

    StringCalculator calculator = new StringCalculator();


    @org.junit.jupiter.api.Test
    void zeroElement() throws Exception{
            assertEquals(0, calculator.retNumber(""));
    }
    @org.junit.jupiter.api.Test
    void oneNUmber()throws Exception{
            assertEquals(1, calculator.retNumber("1"));
    }
    @org.junit.jupiter.api.Test
    void twoNumbers() throws Exception{
            assertEquals(7, calculator.retNumber("2,5"));
            assertEquals(15, calculator.retNumber("5\n10"));
    }
    @org.junit.jupiter.api.Test
    void negativeNumber(){
        Exception e  = assertThrows(Exception.class, () -> {
            calculator.retNumber("-5");
        });
        assertEquals("Negative number", e.getMessage());
    }
    @org.junit.jupiter.api.Test
    void threeNumbers() throws Exception{
        assertEquals(304, calculator.retNumber("100,200,4"));
        assertEquals(120, calculator.retNumber("100\n20"));
    }
    @org.junit.jupiter.api.Test
    void delimiterBeginning() throws Exception{
        assertEquals(400, calculator.retNumber("#200,200"));
    }
    @org.junit.jupiter.api.Test
    void nonThousands() throws Exception{
        assertEquals(200, calculator.retNumber("1000,200"));
    }
}
