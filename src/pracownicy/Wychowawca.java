package pracownicy;

import aktywnoscWiezien.Kurs;
import aktywnoscWiezien.Praca;
import aktywnoscWiezien.Wiezien;
import pracownicy.Pracownik;

import java.util.ArrayList;

public class Wychowawca extends Pracownik
{
    private ArrayList<Kurs> listaKursow;
    private ArrayList<Praca> listaPrac;


    public Wychowawca(String imie, String nazwisko, ArrayList<Kurs> listaKursow, ArrayList<Praca> listaPrac) {
        super(imie, nazwisko,"login");
        this.listaKursow = listaKursow;
        this.listaPrac = listaPrac;
    }

    public void dodajWiezniaDoKursu(Wiezien wiezien,Kurs kurs) {
        kurs.dodajDoKursu(wiezien);
    }
    public void usunWiezniaZKursu(Kurs kurs,Wiezien wiezien) {
        kurs.usunZKursu(wiezien);
    }
    public void usunWiezniaZPracy() {}
    public void wyswietlMenu() {}
    public void dodajPracownika(Wiezien wiezien, int i)
    {
        Praca.getListaPracownikow().add(wiezien);
    }

    public ArrayList<Kurs> getListaKursow() {
        return listaKursow;
    }

    public void setListaKursow(ArrayList<Kurs> listaKursow) {
        this.listaKursow = listaKursow;
    }

    public ArrayList<Praca> getListaPrac() {
        return listaPrac;
    }

    public void setListaPrac(ArrayList<Praca> listaPrac) {
        this.listaPrac = listaPrac;
    }
}
