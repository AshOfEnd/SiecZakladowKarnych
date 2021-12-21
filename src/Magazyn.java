import java.util.List;

public class Magazyn
{
    private List<Produkt> listaProduktów;
    private List<Zamowienie> listaZamowien;

    public Magazyn(List<Produkt> listaProduktów, List<Zamowienie> listaZamowien) {
        this.listaProduktów = listaProduktów;
        this.listaZamowien = listaZamowien;
    }

    public void dodajZamowienie(Zamowienie zam) {}
    public void edytujZamowienie(Zamowienie zam) {}
    public void wydajTowar() {}
    public void dodajDoMagazynu() {}

    public List<Produkt> getListaProduktów() {
        return listaProduktów;
    }

    public void setListaProduktów(List<Produkt> listaProduktów) {
        this.listaProduktów = listaProduktów;
    }

    public List<Zamowienie> getListaZamowien() {
        return listaZamowien;
    }

    public void setListaZamowien(List<Zamowienie> listaZamowien) {
        this.listaZamowien = listaZamowien;
    }
}
