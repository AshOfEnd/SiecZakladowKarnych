package pracownicy;

import wyposazenie.Magazyn;
import wyposazenie.Produkt;
import wyposazenie.Zamowienie;

import java.io.Serializable;

public class Magazynier extends Pracownik implements Serializable
{

    public Magazynier(String imie, String nazwisko) {
        super(imie, nazwisko,"login");
    }

    public void edytujZamowienie(Zamowienie zamowienie,int id,int liczba,String nazwa) {
        zamowienie.setId(id);
        zamowienie.setLiczba(liczba);
        zamowienie.setNazwa(nazwa);
    }
    public void zlozZamowienie(Magazyn magazyn, Produkt produkt) {
        magazyn.dodajDoMagazynu(produkt);
    }
    public void wyswietlMenu() {}
    public String getName()
    {
        return getImie();
    }
}
