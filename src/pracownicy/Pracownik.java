package pracownicy;

import aktywnoscWiezien.Skargi;
import aktywnoscWiezien.Wiezien;
import wyposazenie.Archiwum;
import wyposazenie.ZgloszenieUsterki;

import java.io.Serializable;
import java.util.Date;

public class Pracownik implements Serializable
{
    private String imie;
    private String nazwisko;
    private String login;


    public Pracownik(String imie, String nazwisko, String login) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
    }

    public void wypiszInformacje() {
        //gui
    }
    public void zglosSkrage(Wiezien wiezien, String tresc, Date data) {
        Skargi skarga = new Skargi(tresc,data);
        wiezien.dodajSkarge(skarga);
    }
    public void zglosUsterke(Archiwum archiwum,String tresc, Date data) {
        ZgloszenieUsterki zgloszenieUsterki = new ZgloszenieUsterki(tresc,data);
        archiwum.dodajUsterke(zgloszenieUsterki);
    }
    public void wyswietlMenu() {}


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

    public boolean sprawdzCzyToOn(String login)
    {
        if(login == this.login)
            return true;
        return false;
    }
}
