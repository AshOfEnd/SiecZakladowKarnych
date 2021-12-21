public class Skargi
{
    private String tresc;
    private Wiezien wiezien;

    public Skargi(String tresc, Wiezien wiezien) {
        this.tresc = tresc;
        this.wiezien = wiezien;
    }

    public void wyswietlSkarge() {}
    public void wyslij() {}

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Wiezien getWiezien() {
        return wiezien;
    }

    public void setWiezien(Wiezien wiezien) {
        this.wiezien = wiezien;
    }
}
