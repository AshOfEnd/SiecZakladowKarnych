import java.util.List;

public class Praca
{
    private List<Wiezien> listaPracownikow;
    private String nazwaPracy;

    public Praca(List<Wiezien> listaPracownikow, String nazwaPracy) {
        this.listaPracownikow = listaPracownikow;
        this.nazwaPracy = nazwaPracy;
    }

    public List<Wiezien> getListaPracownikow() {
        return listaPracownikow;
    }

    public void setListaPracownikow(List<Wiezien> listaPracownikow) {
        this.listaPracownikow = listaPracownikow;
    }

    public String getNazwaPracy() {
        return nazwaPracy;
    }

    public void setNazwaPracy(String nazwaPracy) {
        this.nazwaPracy = nazwaPracy;
    }
}
