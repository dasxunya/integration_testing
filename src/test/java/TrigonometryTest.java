import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import functions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;

public class TrigonometryTest {

    private static final double DELTA = 0.0001;

    @DisplayName("Test Sec (cos-mock)")
    @Test
    public void testSec() {
        Cos cos = Mockito.spy(Cos.class);
        Sec sec = new Sec(cos);

        Mockito.when(cos.calculate(eq(0d), anyDouble())).thenReturn(1.0);
        Mockito.when(cos.calculate(eq(Math.PI / 2), anyDouble())).thenReturn(1.0);
        Mockito.when(cos.calculate(eq(Math.PI), anyDouble())).thenReturn(-1.0);
        Mockito.when(cos.calculate(eq(3 * Math.PI / 2), anyDouble())).thenReturn(0.0);
        Mockito.when(cos.calculate(eq(2 * Math.PI), anyDouble())).thenReturn(1.0);

        Mockito.when(cos.calculate(eq(Math.PI / 4), anyDouble())).thenReturn(Math.sqrt(2) / 2);
        Mockito.when(cos.calculate(eq(Math.PI / 3), anyDouble())).thenReturn(0.5);
        Mockito.when(cos.calculate(eq(Math.PI / 6), anyDouble())).thenReturn(Math.sqrt(3) / 2);
        Mockito.when(cos.calculate(eq(-5.27), anyDouble())).thenReturn(0.529160608);

        assertEquals(Double.NaN, sec.calculate(Math.PI / 2, DELTA));
        assertEquals(Double.NaN, sec.calculate(-Math.PI / 2, DELTA));

        assertEquals(1.0, sec.calculate(0d, DELTA), DELTA);
        assertEquals(1.0, sec.calculate(Math.PI * 2, DELTA), DELTA);
        assertEquals(-1.0, sec.calculate(Math.PI, DELTA), DELTA);
        assertEquals(-1.0, sec.calculate(-Math.PI, DELTA), DELTA);

        assertEquals(-2.0, sec.calculate(2 * Math.PI / 3, DELTA), DELTA);
        assertEquals(2.0, sec.calculate(Math.PI / 3, DELTA), DELTA);
        assertEquals(Math.sqrt(2), sec.calculate(Math.PI / 4, DELTA), DELTA);
        assertEquals(2 * Math.sqrt(3) / 3, sec.calculate(Math.PI / 6, DELTA), DELTA);
        assertEquals(1.88978, sec.calculate(-5.27, DELTA), DELTA);
    }

    @DisplayName("Test Csc (sin-mock)")
    @Test
    public void testCsc() {
        Sin sin = Mockito.spy(Sin.class);
        Csc csc = new Csc(sin);

        Mockito.when(sin.calculate(eq(0d), anyDouble())).thenReturn(0.0);
        Mockito.when(sin.calculate(eq(Math.PI), anyDouble())).thenReturn(0.0);
        Mockito.when(sin.calculate(eq(2 * Math.PI), anyDouble())).thenReturn(0.0);
        Mockito.when(sin.calculate(eq(Math.PI / 2), anyDouble())).thenReturn(1.0);
        Mockito.when(sin.calculate(eq(3 * Math.PI / 2), anyDouble())).thenReturn(-1.0);

        Mockito.when(sin.calculate(eq(Math.PI / 4), anyDouble())).thenReturn(Math.sqrt(2) / 2);
        Mockito.when(sin.calculate(eq(Math.PI / 3), anyDouble())).thenReturn(Math.sqrt(3) / 2);
        Mockito.when(sin.calculate(eq(Math.PI / 6), anyDouble())).thenReturn(0.5);
        Mockito.when(sin.calculate(eq(-Math.PI / 6), anyDouble())).thenReturn(-0.5);
        Mockito.when(sin.calculate(eq(-5.27), anyDouble())).thenReturn(0.8485216);

        assertEquals(Double.NaN, csc.calculate(0d, DELTA));
        assertEquals(Double.NaN, csc.calculate(Math.PI, DELTA));
        assertEquals(Double.NaN, csc.calculate(2 * Math.PI, DELTA));

        assertEquals(1.0, csc.calculate(Math.PI / 2, DELTA), DELTA);
        assertEquals(-1.0, csc.calculate(3 * Math.PI / 2, DELTA), DELTA);
        assertEquals(1.4142, csc.calculate(Math.PI / 4, DELTA), DELTA);
        assertEquals(1.1547, csc.calculate(Math.PI / 3, DELTA), DELTA);
        assertEquals(2.0, csc.calculate(Math.PI / 6, DELTA), DELTA);
        assertEquals(-2.0, csc.calculate(-Math.PI / 6, DELTA), DELTA);

        assertEquals(1.17852, csc.calculate(-5.27, DELTA), DELTA);

    }

    @DisplayName("Test Tan and Cot (sin/cos-mock)")
    @Test
    public void testTanAndCot() {
        Sin sin = Mockito.spy(Sin.class);
        Cos cos = Mockito.spy(Cos.class);

        Tan tan = new Tan(cos, sin);
        Cot cot = new Cot(cos, sin);

        //sin
        Mockito.when(sin.calculate(eq(0d), anyDouble())).thenReturn(0.0);
        Mockito.when(sin.calculate(eq(Math.PI), anyDouble())).thenReturn(0.0);
        Mockito.when(sin.calculate(eq(2 * Math.PI), anyDouble())).thenReturn(0.0);
        Mockito.when(sin.calculate(eq(Math.PI / 2), anyDouble())).thenReturn(1.0);
        Mockito.when(sin.calculate(eq(3 * Math.PI / 2), anyDouble())).thenReturn(-1.0);
        Mockito.when(sin.calculate(eq(Math.PI / 4), anyDouble())).thenReturn(Math.sqrt(2) / 2);
        Mockito.when(sin.calculate(eq(Math.PI / 3), anyDouble())).thenReturn(Math.sqrt(3) / 2);
        Mockito.when(sin.calculate(eq(Math.PI / 6), anyDouble())).thenReturn(0.5);
        Mockito.when(sin.calculate(eq(-Math.PI / 6), anyDouble())).thenReturn(-0.5);
        Mockito.when(sin.calculate(eq(-5.27), anyDouble())).thenReturn(0.8485216);

        //cos
        Mockito.when(cos.calculate(eq(0d), anyDouble())).thenReturn(1.0);
        Mockito.when(cos.calculate(eq(Math.PI), anyDouble())).thenReturn(-1.0);
        Mockito.when(cos.calculate(eq(2 * Math.PI), anyDouble())).thenReturn(1.0);
        Mockito.when(cos.calculate(eq(Math.PI / 2), anyDouble())).thenReturn(0.0);
        Mockito.when(cos.calculate(eq(3 * Math.PI / 2), anyDouble())).thenReturn(0.0);
        Mockito.when(cos.calculate(eq(Math.PI / 4), anyDouble())).thenReturn(Math.sqrt(2) / 2);
        Mockito.when(cos.calculate(eq(Math.PI / 3), anyDouble())).thenReturn(0.5);
        Mockito.when(cos.calculate(eq(Math.PI / 6), anyDouble())).thenReturn(Math.sqrt(3) / 2);
        Mockito.when(cos.calculate(eq(-Math.PI / 6), anyDouble())).thenReturn(0.866025403);
        Mockito.when(cos.calculate(eq(-5.27), anyDouble())).thenReturn(0.529160608);

        //tan
        assertEquals(0d, tan.calculate(0, DELTA), DELTA);
        assertEquals(0d, tan.calculate(Math.PI, DELTA), DELTA);
        assertEquals(0d, tan.calculate(2 * Math.PI, DELTA), DELTA);
        assertEquals(Double.NaN, tan.calculate(Math.PI / 2, DELTA));
        assertEquals(Double.NaN, tan.calculate(3 * Math.PI / 2, DELTA));
        assertEquals(1d, tan.calculate(Math.PI / 4, DELTA), DELTA);
        assertEquals(Math.sqrt(3), tan.calculate(Math.PI / 3, DELTA), DELTA);
        assertEquals(1 / Math.sqrt(3), tan.calculate(Math.PI / 6, DELTA), DELTA);
        assertEquals(-Math.sqrt(3) / 3, tan.calculate(-Math.PI / 6, DELTA), DELTA);
        assertEquals(1.6035239, tan.calculate(-5.27, DELTA), DELTA);

        //cot
        assertEquals(Double.NaN, cot.calculate(0, DELTA));
        assertEquals(Double.NaN, cot.calculate(Math.PI, DELTA));
        assertEquals(Double.NaN, cot.calculate(2 * Math.PI, DELTA), DELTA);
        assertEquals(0d, cot.calculate(Math.PI / 2, DELTA), DELTA);
        assertEquals(0d, cot.calculate(3 * Math.PI / 2, DELTA), DELTA);
        assertEquals(1d, cot.calculate(Math.PI / 4, DELTA), DELTA);
        assertEquals(1 / Math.sqrt(3), cot.calculate(Math.PI / 3, DELTA), DELTA);
        assertEquals(Math.sqrt(3), cot.calculate(Math.PI / 6, DELTA), DELTA);
        assertEquals(-Math.sqrt(3), cot.calculate(-Math.PI / 6, DELTA), DELTA);
        assertEquals(0.6236264, cot.calculate(-5.27, DELTA), DELTA);
    }

    @DisplayName("Test Cos (sin-mock)")
    @Test
    public void testCos() {

    }

    @DisplayName("Test Sin ")
    @Test
    public void testSin() {
        Sin sin = new Sin();

        assertEquals(0d, sin.calculate(0d, DELTA), DELTA);
        assertEquals(0d, sin.calculate(Math.PI, DELTA), DELTA);
        assertEquals(0d, sin.calculate(2 * Math.PI, DELTA), DELTA);
        assertEquals(1d, sin.calculate(Math.PI / 2, DELTA), DELTA);
        assertEquals(-1d, sin.calculate(3 * Math.PI / 2, DELTA), DELTA);
        assertEquals(1d, sin.calculate(-3 * Math.PI / 2, DELTA), DELTA);




    }

    @DisplayName("Test All (sin-mock)")
    @Test
    public void testAllFunctions() {

    }

    @DisplayName("Test All (without mock)")
    @Test
    public void testAllFunctionsWithoutMock() {

    }
}
