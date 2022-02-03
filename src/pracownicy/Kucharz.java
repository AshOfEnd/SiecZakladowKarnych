package pracownicy;

import wyposazenie.Magazyn;
import wyposazenie.Zamowienie;

import java.io.Serializable;

public class Kucharz extends Pracownik implements Serializable
{

    public Kucharz(String imie, String nazwisko) {
        super(imie, nazwisko,"login");
    }

    public void zglosZamowienie(Magazyn magazyn, int id, String nazwa, int liczba) {
        Zamowienie zamowienie = new Zamowienie(id,nazwa,liczba);
        magazyn.dodajZamowienie(zamowienie);
    }

}
