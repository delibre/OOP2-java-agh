public class Parameter {
    String key;
    String value;
    Parameter(){

    }
    public String toString(){
        return value;
    }
    String getKey(){
        return key;
    }
    String getValue(){
        return value;
    }
    int getInt() throws WrongTypeIniException{
        return 0;
    }
    double getDouble() throws WrongTypeIniException{
        return 0;
    }
    boolean getBoolean() throws WrongTypeIniException{
        return false;
    }
}
