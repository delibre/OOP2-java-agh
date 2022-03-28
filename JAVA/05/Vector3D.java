public class Vector3D {
    double x, y, z;
    Vector3D(){
        x = 0;
        y = 0;
        z = 0;
    }
    Vector3D(double a, double b, double c){
        x = a;
        y = b;
        z = c;
    }
    public String toString(){
        return "("+x+","+y+","+z+")";
    }
    
    void set(double a, double b, double c){
        x = a;
        y = b;
        z = c;
    }
    void setX(double a){
        x = a;
    }
    void setY(double b){
        y = b;
    }
    void setZ(double c){
        z = c;
    }
    double getX(){
        return x;
    }
    double getY(){
        return y;
    }
    double getZ(){
        return z;
    }
    static Vector3D add(Vector3D v1, Vector3D v2){
        return new Vector3D(v1.x+v2.x, v1.y+v2.y, v1.z+v2.z);
    }
    static Vector3D subtract(Vector3D v1, Vector3D v2){
        return new Vector3D(v1.x-v2.x, v1.y-v2.y, v1.z-v2.z);
    }
    static Vector3D mult(Vector3D v1, double n){
        return new Vector3D(v1.x*n, v1.y*n, v1.z*n);
    }
    static double dotProduct(Vector3D v1, Vector3D v2){
        return v1.x*v2.x + v1.y*v2.y + v1.z*v2.z;
    }
    static Vector3D crossProduct(Vector3D v1, Vector3D v2){
        return new Vector3D(v1.y*v2.z-v1.z*v2.y, v1.z*v2.x-v1.x*v2.z, v1.x*v2.y-v1.y*v2.x);
    }
}
