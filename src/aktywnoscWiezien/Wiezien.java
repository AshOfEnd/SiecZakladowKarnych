package aktywnoscWiezien;

import wyposazenie.Lek;

import java.util.ArrayList;
import java.util.Date;

public class Wiezien
{
    private String imie;
    private String nazwisko;
    private String klasa;
    private int wiek;
    private Date dataZwolnienia;
    private ArrayList<Skargi> skargi;
    private ArrayList<Lek> listaLekow;
    private int numerCeli;

    public Wiezien(String imie, String nazwisko, String klasa, int wiek, Date dataZwolnienia, ArrayList<Skargi> skargi, ArrayList<Lek> listaLekow, int numerCeli) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.klasa = klasa;
        this.wiek = wiek;
        this.dataZwolnienia = dataZwolnienia;
        this.skargi = skargi;
        this.listaLekow = listaLekow;
        this.numerCeli = numerCeli;
    }

    public void wyswietlInformacje() {}
    public void przypiszLek() {}
    public void zmienCele() {}
    public void wyswietlSkargi() {}
    public void zmienKlase() {}

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

    public String getKlasa() {
        return klasa;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public Date getDataZwolnienia() {
        return dataZwolnienia;
    }

    public void setDataZwolnienia(Date dataZwolnienia) {
        this.dataZwolnienia = dataZwolnienia;
    }

    public ArrayList<Skargi> getSkargi() {
        return skargi;
    }

    public void setSkargi(ArrayList<Skargi> skargi) {
        this.skargi = skargi;
    }

    public ArrayList<Lek> getListaLekow() {
        return listaLekow;
    }

    public void setListaLekow(ArrayList<Lek> listaLekow) {
        this.listaLekow = listaLekow;
    }

    public int getNumerCeli() {
        return numerCeli;
    }

    public void setNumerCeli(int numerCeli) {
        this.numerCeli = numerCeli;
    }
}
