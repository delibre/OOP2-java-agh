class BladFunkcji extends ArithmeticException{}

public enum Funkcja implements FunkcjaLambda{
    X2{
        public double wartosc(double x){ return x*x; }
    },
    SQRT{
        public double wartosc(double x){ 
            if (x < 0) throw new BladFunkcji();
            return Math.sqrt(x); 
        }
    },
    EXP{
        public double wartosc(double x){ return Math.exp(x); }
    };
    public double wartosc(double x){ return 0.0; }
}
