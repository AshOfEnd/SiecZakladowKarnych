import java.util.List;

public class Wychowawca extends Pracownik
{
    private List<Kurs> listaKursow;
    private List<Praca> listaPrac;


    public Wychowawca(String imie, String nazwisko, List<Kurs> listaKursow, List<Praca> listaPrac) {
        super(imie, nazwisko);
        this.listaKursow = listaKursow;
        this.listaPrac = listaPrac;
    }

    public void dodajWiezniaDoKursu() {}
    public void usunWiezniaZKursu() {}
    public void przydzielWiezniaDoPracy() {}
    public void usunWiezniaZPracy() {}
    public void wyswietlMenu() {}




    public List<Kurs> getListaKursow() {
        return listaKursow;
    }

    public void setListaKursow(List<Kurs> listaKursow) {
        this.listaKursow = listaKursow;
    }

    public List<Praca> getListaPrac() {
        return listaPrac;
    }

    public void setListaPrac(List<Praca> listaPrac) {
        this.listaPrac = listaPrac;
    }
}
