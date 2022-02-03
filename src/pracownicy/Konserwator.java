package pracownicy;

import pracownicy.Pracownik;
import wyposazenie.Archiwum;
import wyposazenie.Magazyn;
import wyposazenie.Raport;
import wyposazenie.Zamowienie;

import java.util.Date;


public class Konserwator extends Pracownik
{
    public Konserwator(String imie, String nazwisko) {
        super(imie, nazwisko,"login");
    }

    public void zglosZamowienie(Magazyn magazyn,int id,String nazwa, int liczba) {
        Zamowienie zamowienie = new Zamowienie(id,nazwa,liczba);
        magazyn.dodajZamowienie(zamowienie);
    }
    public void zlozRaport(Archiwum archiwum,String imie, String nazwisko, String trescRaportu, Date data) {
        Raport raport = new Raport(imie,nazwisko,trescRaportu,data);

    }


}
