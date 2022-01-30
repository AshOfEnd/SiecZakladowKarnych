package pracownicy;

import java.io.Serializable;

public class Lekarz extends Pracownik implements Serializable
{

    public Lekarz(String imie, String nazwisko)
    {
        super(imie, nazwisko,"login");
    }

    public void przepiszLek() {}
    public void zamowZaopatrzenie() {}
    public void wyswietlMenu() {}
}
