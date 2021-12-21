public class Pracownik
{
    private String imie;
    private String nazwisko;


    public Pracownik(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public void wypiszInformacje() {}
    public void zglosSkrage() {}
    public void zglosUsterke() {}
    public void wyswietlMenu() {}


    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}
