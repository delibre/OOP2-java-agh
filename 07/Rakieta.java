public abstract class Rakieta implements PojazdKosmiczny{
    public static String producent(){
        return "NASA";
    }
    public void ustawCiag(int i){};
    public void startuj(){};
    public Apollo ladownikApollo(){
        return new Apollo(this);
    }

    static public class Zaloga{

    }
    public class Ladownik implements PojazdKosmiczny{
        public void ustawCiag(int i){};
        public void startuj(){};
    }

}
