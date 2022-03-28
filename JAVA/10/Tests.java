import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class Tests {
    public Tests() {
        System.out.print("Test 1\n");
    }

    @Test
    public void testInt() {
        System.out.print("(testujemy tablicę int)\n");
        ArrInt A = new ArrInt(1000000, 10);
        assertEquals(A.getAvg(), 5.0, 0.1);

        ArrInt B = new ArrInt(1, 2, 3, 4, 5, 6);
        assertEquals(B.getAvg(), 3.5, 1e-2);
        assertEquals(B.getStd(), 1.7078, 1e-2);
    }

    @Test
    public void testInteger() {
        System.out.print("(testujemy tablicę Integer)\n");
        ArrInteger A = new ArrInteger(1000000, 10);
        assertEquals(A.getAvg(), 5.0, 0.1);

        ArrInteger B = new ArrInteger(1, 2, 3, 4, 5, 6);
        assertEquals(B.getAvg(), 3.5, 1e-2);
        assertEquals(B.getStd(), 1.7078, 1e-2);
    }

    @Test
    public void testT() {
        System.out.print("(testujemy tablicę T)\n");
        Arr<Integer> A = new Arr<>(1000000, 10);
        assertEquals(A.getAvg(), 5.0, 0.1);

        Arr<Integer> B = new Arr<>(1, 2, 3, 4, 5, 6);
        assertEquals(B.getAvg(), 3.5, 1e-2);
        assertEquals(B.getStd(), 1.7078, 1e-2);
    }
}