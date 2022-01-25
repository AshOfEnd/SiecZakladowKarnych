package pracownicy;

import pracownicy.Pracownik;

public class Konserwator extends Pracownik
{
    public Konserwator(String imie, String nazwisko) {
        super(imie, nazwisko,"login");
    }

    public void zglosZamowienie() {}
    public void zlozRaport() {}
    public void odczytajZgloszenie() {}
    public void wyswietlMenu() {}
}
