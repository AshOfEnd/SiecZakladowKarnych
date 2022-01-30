package pracownicy;

import java.io.Serializable;

public class Magazynier extends Pracownik implements Serializable
{

    public Magazynier(String imie, String nazwisko) {
        super(imie, nazwisko,"login");
    }

    public void edytujZamowienie() {}
    public void wydajTowar() {}
    public void zlozZamowienie() {}
    public void wyswietlMenu() {}
    public String getName()
    {
        return getImie();
    }
}
