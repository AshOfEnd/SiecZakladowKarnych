import java.util.ArrayList;

public class Magazyn
{
    private ArrayList<Produkt> listaProduktów;
    private ArrayList<Zamowienie> listaZamowien;

    public Magazyn(ArrayList<Produkt> listaProduktów, ArrayList<Zamowienie> listaZamowien) {
        this.listaProduktów = listaProduktów;
        this.listaZamowien = listaZamowien;
    }

    public Magazyn()
    {
        listaProduktów = new ArrayList<>();
        listaZamowien = new ArrayList<>();
    }

    public void dodajZamowienie(Zamowienie zam) {}
    public void edytujZamowienie(Zamowienie zam) {}
    public void wydajTowar() {}
    public void dodajDoMagazynu() {}

    public ArrayList<Produkt> getListaProduktów() {
        return listaProduktów;
    }

    public void setListaProduktów(ArrayList<Produkt> listaProduktów) {
        this.listaProduktów = listaProduktów;
    }

    public ArrayList<Zamowienie> getListaZamowien() {
        return listaZamowien;
    }

    public void setListaZamowien(ArrayList<Zamowienie> listaZamowien) {
        this.listaZamowien = listaZamowien;
    }
}
