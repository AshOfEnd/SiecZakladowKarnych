public class Formularz
{
    private String nazwa;
    private int liczba;

    public Formularz(String nazwa, int liczba) {
        this.nazwa = nazwa;
        this.liczba = liczba;
    }

    public void wyswietlFormularz() {}
    public void wyslij() {}

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getLiczba() {
        return liczba;
    }

    public void setLiczba(int liczba) {
        this.liczba = liczba;
    }
}
