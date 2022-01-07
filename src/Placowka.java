import java.util.ArrayList;

public class Placowka
{
    private ArrayList<Izolatka> listaIzolatek;
    private ArrayList<Wiezien> listaWiezniow;
    private int numerPlacowki;

    public Placowka(ArrayList<Izolatka> listaIzolatek, ArrayList<Wiezien> listaWiezniow, int numerPlacowki) {
        this.listaIzolatek = listaIzolatek;
        this.listaWiezniow = listaWiezniow;
        this.numerPlacowki = numerPlacowki;
    }

    public Placowka(int id)
    {
        listaIzolatek = new ArrayList<Izolatka>();
        listaWiezniow = new ArrayList<Wiezien>();
        numerPlacowki = id;
    }

    public void wyswietl() {}
    public void przeniesWieznia() {}

    public ArrayList<Izolatka> getListaIzolatek() {
        return listaIzolatek;
    }

    public void setListaIzolatek(ArrayList<Izolatka> listaIzolatek) {
        this.listaIzolatek = listaIzolatek;
    }

    public ArrayList<Wiezien> getListaWiezniow() {
        return listaWiezniow;
    }

    public void setListaWiezniow(ArrayList<Wiezien> listaWiezniow) {
        this.listaWiezniow = listaWiezniow;
    }

    public int getNumerPlacowki() {
        return numerPlacowki;
    }

    public void setNumerPlacowki(int numerPlacowki) {
        this.numerPlacowki = numerPlacowki;
    }
}
