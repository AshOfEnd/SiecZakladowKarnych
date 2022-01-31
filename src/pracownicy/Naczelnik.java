package pracownicy;

import aktywnoscWiezien.Izolatka;
import aktywnoscWiezien.Placowka;
import aktywnoscWiezien.Wiezien;

public class Naczelnik extends Pracownik
{

    public Naczelnik(String imie, String nazwisko) {
        super(imie, nazwisko,"login");
    }

    public void przydzielWiezniaDoCeli(Wiezien wiezien,int numerCeli) {
        wiezien.zmienCele(numerCeli);
    }
    public void odczytajSkarge() {
        //gui
    }
    public void zmienKlaseWieznia(Wiezien wiezien,String klasa) {
        wiezien.zmienKlase(klasa);
    }
    public void transferujWieznia(Placowka placowka1, Placowka placowka2, Wiezien wiezien) {
        placowka1.przeniesWieznia(wiezien);
    }
    public void przydzielDoIzolatki(Izolatka izolatka,Wiezien wiezien) {
        izolatka.przydzielDoIzolatki(wiezien);
    }
    public void usunZIzolatki(Izolatka izolatka) {
        izolatka.usunZIzolatki();
    }
    public void wyswietlMenu() {
        //gui
    }

}
