package wyposazenie;

import java.util.Date;

public class Raport
{
    private String imie;
    private String nazwisko;
    private String trescRaportu;
    private int data;

    public Raport(String imie, String nazwisko, String trescRaportu, Date data) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.trescRaportu = trescRaportu;
        this.data = data;
    }

    public void formularzRaportu()
    {
        System.out.println("Formularz raportu");
    }

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

    public String getTrescRaportu() {
        return trescRaportu;
    }

    public void setTrescRaportu(String trescRaportu) {
        this.trescRaportu = trescRaportu;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
