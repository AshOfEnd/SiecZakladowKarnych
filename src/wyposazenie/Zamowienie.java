package wyposazenie;

public class Zamowienie
{
    private int id;
    private String nazwa;
    private int liczba;

    public Zamowienie(int id, String nazwa, int liczba) {
        this.id = id;
        this.nazwa = nazwa;
        this.liczba = liczba;
    }

    public void wyswietlZamowienie() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
