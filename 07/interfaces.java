interface PojazdKosmiczny extends Latajacy, Odrzutowy{
    String BAZA = "Kennedy Space Center";
}

interface Latajacy{
    public void startuj();
}

interface Odrzutowy{
    public void ustawCiag(int i);
}

interface Jezdzi{
    public void skrecKola();
}
