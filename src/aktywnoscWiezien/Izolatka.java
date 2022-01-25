package aktywnoscWiezien;
//
public class Izolatka {
    private static int numerIzolatki = 0;
    private Wiezien wiezien;

    public Izolatka(int numerIzolatki, Wiezien wiezien) {
        this.numerIzolatki = numerIzolatki;
        this.wiezien = wiezien;
    }
    public Izolatka()
    {
        numerIzolatki++;
        wiezien = null;
    }

    public void przydzielDoIzolatki() {}
    public void usunZIzolatki() {}

    public int getNumerIzolatki() {
        return numerIzolatki;
    }

    public Wiezien getWiezien() {
        return wiezien;
    }

    public void setNumerIzolatki(int numerIzolatki) {
        this.numerIzolatki = numerIzolatki;
    }

    public void setWiezien(Wiezien wiezien) {
        this.wiezien = wiezien;
    }

    public void usunWieznia()
    {
        wiezien = null;
    }

    public boolean sprawdzCzyJestPusta()
    {
        if(wiezien == null)
            return true;
        return false;
    }

    public void dodajWieznia(Wiezien w)
    {
        wiezien = w;
    }
}
