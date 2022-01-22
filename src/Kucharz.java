import java.io.Serializable;

public class Kucharz extends Pracownik implements Serializable
{

    public Kucharz(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    public void zlozZamowienie() {}
    public void wyswietlMenu() {}
}
