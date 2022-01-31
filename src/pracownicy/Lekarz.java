package pracownicy;

import aktywnoscWiezien.Wiezien;
import wyposazenie.Magazyn;
import wyposazenie.Zamowienie;

import java.io.Serializable;

public class Lekarz extends Pracownik implements Serializable
{

    public Lekarz(String imie, String nazwisko)
    {
        super(imie, nazwisko,"login");
    }

    public void przepiszLek(Wiezien wiezien, String nazwa, String dawka) {
        wiezien.przypiszLek(nazwa,dawka);
    }
    public void zglosZamowienie(Magazyn magazyn, int id, String nazwa, int liczba) {
        Zamowienie zamowienie = new Zamowienie(id,nazwa,liczba);
        magazyn.dodajZamowienie(zamowienie);
    }
    public void wyswietlMenu() {

    }
}
