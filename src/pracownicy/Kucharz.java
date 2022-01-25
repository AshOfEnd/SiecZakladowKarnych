package pracownicy;

import java.io.Serializable;

public class Kucharz extends Pracownik implements Serializable
{

    public Kucharz(String imie, String nazwisko) {
        super(imie, nazwisko,"login");
    }

    public void zlozZamowienie() {}
    public void wyswietlMenu() {}
}
