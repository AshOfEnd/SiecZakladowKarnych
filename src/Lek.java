public class Lek
{
    private String nazwa;
    private String dawka;

    public Lek(String nazwa, String dawka) {
        this.nazwa = nazwa;
        this.dawka = dawka;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getDawka() {
        return dawka;
    }

    public void setDawka(String dawka) {
        this.dawka = dawka;
    }
}
