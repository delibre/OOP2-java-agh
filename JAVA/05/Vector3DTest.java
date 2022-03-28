import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Vector3DTest {
    
    Vector3D v1 = new Vector3D(1, 2, 3);
    Vector3D v2 = new Vector3D(1, 1, 1);
    Vector3D v3 = new Vector3D(-0.5, -1.5, -2.5);
    Vector3D v4 = new Vector3D(0.1, 1, 1.5);
    
    void compare(Vector3D a, Vector3D b){
        assertEquals(a.x, b.x, 1e-10);
        assertEquals(a.y, b.y, 1e-10);
        assertEquals(a.z, b.z, 1e-10);
    }

    @Test
    void testSet(){
        Vector3D temp = new Vector3D();
        temp.set(1, 2, 3);
        assertEquals("(1.0,2.0,3.0)", temp.toString());
    }
    @Test
    void testSetX(){
        Vector3D temp = new Vector3D();
        temp.setX(5.2);
        assertEquals("(5.2,0.0,0.0)", temp.toString());
    }
    @Test
    void testSetY(){
        Vector3D temp = new Vector3D();
        temp.setY(-2.5);
        assertEquals("(0.0,-2.5,0.0)", temp.toString());
    }
    @Test
    void testSetZ(){
        Vector3D temp = new Vector3D();
        temp.setZ(0.01);
        assertEquals("(0.0,0.0,0.01)", temp.toString());
    }
    @Test
    void testGetX(){
        Vector3D temp = new Vector3D(1.0, 1.5, 1.75);
        assertEquals(1.0, temp.getX(), 1e-10);
    }
    @Test
    void testGetY(){
        Vector3D temp = new Vector3D(1.0, 1.5, 1.75);
        assertEquals(1.5, temp.getY(), 1e-10);
    }
    @Test
    void testGetZ(){
        Vector3D temp = new Vector3D(1.0, 1.5, 1.75);
        assertEquals(1.75, temp.getZ(), 1e-10);
    }
    @Test
    void testAdd(){
        Vector3D sol1 = new Vector3D(2, 3, 4);
        Vector3D sol2 = new Vector3D(-0.4, -0.5, -1);

        compare(Vector3D.add(v1,v2), sol1);
        compare(Vector3D.add(v3,v4), sol2);
    }
    @Test
    void testSubtract(){
        Vector3D sol1 = new Vector3D(0, 1, 2);
        Vector3D sol2 = new Vector3D(-0.6, -2.5, -4);
        compare(sol1, Vector3D.subtract(v1,v2));
        compare(sol2, Vector3D.subtract(v3,v4));
    }
    @Test
    void testMult(){
        Vector3D sol1 = new Vector3D(2.5, 5, 7.5);
        Vector3D sol2 = new Vector3D(0.25, 2.5, 3.75);
        double n = 2.5;
        compare(sol1, Vector3D.mult(v1,n));
        compare(sol2, Vector3D.mult(v4,n));
    }
    @Test
    void testDotProduct(){
        assertEquals(6.0, Vector3D.dotProduct(v1,v2), 1e-10);
        assertEquals(-5.3, Vector3D.dotProduct(v3,v4), 1e-10);
    }
    @Test
    void testCrossProduct(){
        Vector3D sol1 = new Vector3D(-1, 2, -1);
        Vector3D sol2 = new Vector3D(0.25, 0.5, -0.35);
        compare(sol1, Vector3D.crossProduct(v1,v2));
        compare(sol2, Vector3D.crossProduct(v3,v4));
    }
}
