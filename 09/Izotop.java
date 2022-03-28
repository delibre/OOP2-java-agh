public class Izotop {
    char name;
    int a;
    int z;
    public Izotop(Izotop i){
        this.name = i.name;
        this.a = i.a;
        this.z = i.z;
    }
    public Izotop(char name, int a, int z){
        this.name = name;
        this.a = a;
        this.z = z;
    }
    public Izotop(char name){
        this.name = name;
        this.a = 0;
        this.z = 0;
    }
    void set(int a){
        this.a = a;
    }
    public String toString(){
        return a+"";
    }
    public boolean equals(Object o){
        if(this.a == ((Izotop)o).a) return true;
        else return false;
    }
    public Izotop clone(){
        return new Izotop(this);
    }
    public int hashCode(){
        return this.a;
    }
    public int liczbaNeutronow() throws BrakLiczbAZException, UjemnaLiczbaNeutronowException, UjemnaLiczbaAlubZException{
        if (this.a-this.z == 0) throw new BrakLiczbAZException("X="+this.name);
        else if (this.a < 0 || this.z < 0) throw new UjemnaLiczbaAlubZException();
        else if (this.a-this.z < 0) throw new UjemnaLiczbaNeutronowException("X="+this.name);
        return this.a-this.z;
    }
    public void liczbyNeutronowProtonow() throws RuntimeException{
        try{
            int n = liczbaNeutronow();
        }
        catch(Exception ue){
            throw(RuntimeException)
            new RuntimeException(ue.getClass().getName()+": "+ue.getMessage()).initCause(ue);
        }     
    }
}

class BrakLiczbAZException extends Exception{
    public BrakLiczbAZException(){
        super();
    }
    public BrakLiczbAZException(String info){
        super(info);
    }
}

class UjemnaLiczbaAlubZException extends Exception{
    public UjemnaLiczbaAlubZException(){
        super();
    }
}

class UjemnaLiczbaNeutronowException extends Exception{
    public UjemnaLiczbaNeutronowException(){
        super();
    }
    public UjemnaLiczbaNeutronowException(String info){
        super(info);
    }
}
