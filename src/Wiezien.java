import java.util.Date;
import java.util.List;

public class Wiezien
{
    private String imie;
    private String nazwisko;
    private String klasa;
    private int wiek;
    private Date dataZwolnienia;
    private List<Skargi> skargi;
    private List<Lek> listaLekow;
    private int numerCeli;

    public Wiezien(String imie, String nazwisko, String klasa, int wiek, Date dataZwolnienia, List<Skargi> skargi, List<Lek> listaLekow, int numerCeli) {
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

    public List<Skargi> getSkargi() {
        return skargi;
    }

    public void setSkargi(List<Skargi> skargi) {
        this.skargi = skargi;
    }

    public List<Lek> getListaLekow() {
        return listaLekow;
    }

    public void setListaLekow(List<Lek> listaLekow) {
        this.listaLekow = listaLekow;
    }

    public int getNumerCeli() {
        return numerCeli;
    }

    public void setNumerCeli(int numerCeli) {
        this.numerCeli = numerCeli;
    }
}
