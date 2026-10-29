import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexNumberTest {

    ComplexNumber c1;
    ComplexNumber c2;
    ComplexNumber c3;
    ComplexNumber c4;
    ComplexNumber c5;

    @Before
    public void setUp() throws Exception {
        c1 = new ComplexNumber(3,4);
        c2 = new ComplexNumber(3,-4);
        c3 = new ComplexNumber(-3,4);
        c4 = new ComplexNumber(-3,-4);
        c5 = new ComplexNumber(-9,-40);
    }

    @Test
    public void testGetReal() {
        c1 = new ComplexNumber(3,4);
        c2 = new ComplexNumber(3,-4);
        c3 = new ComplexNumber(-3,4);
        c4 = new ComplexNumber(-3,-4);
        c5 = new ComplexNumber(-9,-40);
        assertEquals(3,c1.getReal(),.00001);
        assertEquals(3,c2.getReal(),.00001);
        assertEquals(-3,c3.getReal(),.00001);
        assertEquals(-3,c4.getReal(),.00001);
    }

    @Test
    public void testGetImaginary() {
        c1 = new ComplexNumber(3,4);
        c2 = new ComplexNumber(3,-4);
        c3 = new ComplexNumber(-3,4);
        c4 = new ComplexNumber(-3,-4);
        c5 = new ComplexNumber(-9,-40);
        assertEquals(4,c1.getImaginary(),.00001);
        assertEquals(-4,c2.getImaginary(),.00001);
        assertEquals(4,c3.getImaginary(),.00001);
        assertEquals(-4,c4.getImaginary(),.00001);
    }

    @Test
    public void testToString() {
        c1 = new ComplexNumber(3,4);
        c2 = new ComplexNumber(3,-4);
        c3 = new ComplexNumber(-3,4);
        c4 = new ComplexNumber(-3,-4);
        c5 = new ComplexNumber(-9,-40);
        assertEquals("3.0+4.0i",c1.toString());
        assertEquals("3.0-4.0i",c2.toString());
        assertEquals("-3.0+4.0i",c3.toString());
        assertEquals("-3.0-4.0i",c4.toString());
        ComplexNumber zeroReal = new ComplexNumber(0,42);
        assertEquals("42.0i",zeroReal.toString());
        ComplexNumber zeroImaginary = new ComplexNumber(42,0);
        assertEquals("42.0",zeroImaginary.toString());
    }

    @Test
    public void testPlus() {
        c1 = new ComplexNumber(3,4);
        c2 = new ComplexNumber(3,-4);
        c3 = new ComplexNumber(-3,4);
        c4 = new ComplexNumber(-3,-4);
        c5 = new ComplexNumber(-9,-40);
        assertEquals(new ComplexNumber(6,0),c1.plus(c2));
        assertEquals(new ComplexNumber(6,8),c1.plus(c1));
        assertEquals(new ComplexNumber(6,-8),c2.plus(c2));
        assertEquals(new ComplexNumber(-6,-8),c4.plus(c4));
        assertEquals(new ComplexNumber(-6,0),c4.plus(c3));
    }

    @Test
    public void testTimes() {
        c1 = new ComplexNumber(3,4);
        c2 = new ComplexNumber(3,-4);
        c3 = new ComplexNumber(-3,4);
        c4 = new ComplexNumber(-3,-4);
        c5 = new ComplexNumber(-9,-40);
        assertEquals(new ComplexNumber(-7,24),c1.times(c1));
        assertEquals(new ComplexNumber(25,0),c1.times(c2));
        assertEquals(new ComplexNumber(-7,-24),c2.times(c2));
        assertEquals(new ComplexNumber(-25,0),c1.times(c3));
        assertEquals(new ComplexNumber(7,24),c2.times(c3));
    }

    @Test
    public void testDividedBy() {
        c1 = new ComplexNumber(3,4);
        c2 = new ComplexNumber(3,-4);
        c3 = new ComplexNumber(-3,4);
        c4 = new ComplexNumber(-3,-4);
        c5 = new ComplexNumber(-9,-40);
        assertEquals(new ComplexNumber(-0.28,0.96),c1.dividedBy(c2));
        assertEquals(new ComplexNumber(1,0),c1.dividedBy(c1));
    }

    @Test
    public void testPowInt() {
        c1 = new ComplexNumber(3,4);
        c2 = new ComplexNumber(3,-4);
        c3 = new ComplexNumber(-3,4);
        c4 = new ComplexNumber(-3,-4);
        c5 = new ComplexNumber(-9,-40);
        assertEquals(new ComplexNumber(3,4),c1.pow(1));
        assertEquals(new ComplexNumber(-7,24),c1.pow(2));
        assertEquals(new ComplexNumber(-117,44),c1.pow(3));
    }

    @Test
    public void testGetModulus() {
        c1 = new ComplexNumber(3,4);
        c2 = new ComplexNumber(3,-4);
        c3 = new ComplexNumber(-3,4);
        c4 = new ComplexNumber(-3,-4);
        c5 = new ComplexNumber(-9,-40);
        assertEquals(5.0,c1.getModulus(),.0001);
        assertEquals(5.0,c2.getModulus(),.0001);
        assertEquals(5.0,c3.getModulus(),.0001);
        assertEquals(5.0,c4.getModulus(),.0001);
        assertEquals(41.0,c5.getModulus(),.0001);
    }

    @Test
    public void testGetConjugate() {
        c1 = new ComplexNumber(3,4);
        c2 = new ComplexNumber(3,-4);
        c3 = new ComplexNumber(-3,4);
        c4 = new ComplexNumber(-3,-4);
        c5 = new ComplexNumber(-9,-40);
        assertEquals(new ComplexNumber(3,-4),c1.getConjugate());
        assertEquals(new ComplexNumber(3,4),c2.getConjugate());
        assertEquals(new ComplexNumber(-3,-4),c3.getConjugate());
        assertEquals(new ComplexNumber(-3,4),c4.getConjugate());
    }
}
