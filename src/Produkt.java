public class Produkt
{
    private int liczba;
    private String nazwa;

    public Produkt(int liczba, String nazwa) {
        this.liczba = liczba;
        this.nazwa = nazwa;
    }

    public int getLiczba() {
        return liczba;
    }

    public void setLiczba(int liczba) {
        this.liczba = liczba;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
