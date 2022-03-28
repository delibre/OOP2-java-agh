public class KrawedzWazona<T> extends Krawedz<T>{
    double weight;
    KrawedzWazona(T a, T b, double w) {
        super(a, b);
        weight = w;
    }
}
