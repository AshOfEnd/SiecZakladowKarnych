import java.util.List;

public class Placowka
{
    private List<Izolatka> listaIzolatek;
    private List<Wiezien> listaWiezniow;
    private int numerPlacowki;

    public Placowka(List<Izolatka> listaIzolatek, List<Wiezien> listaWiezniow, int numerPlacowki) {
        this.listaIzolatek = listaIzolatek;
        this.listaWiezniow = listaWiezniow;
        this.numerPlacowki = numerPlacowki;
    }

    public void wyswietl() {}
    public void przeniesWieznia() {}

    public List<Izolatka> getListaIzolatek() {
        return listaIzolatek;
    }

    public void setListaIzolatek(List<Izolatka> listaIzolatek) {
        this.listaIzolatek = listaIzolatek;
    }

    public List<Wiezien> getListaWiezniow() {
        return listaWiezniow;
    }

    public void setListaWiezniow(List<Wiezien> listaWiezniow) {
        this.listaWiezniow = listaWiezniow;
    }

    public int getNumerPlacowki() {
        return numerPlacowki;
    }

    public void setNumerPlacowki(int numerPlacowki) {
        this.numerPlacowki = numerPlacowki;
    }
}
