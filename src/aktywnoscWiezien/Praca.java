package aktywnoscWiezien;

import java.util.ArrayList;

public class Praca
{
    private ArrayList<Wiezien> listaPracownikow;
    private String nazwaPracy;

    public Praca(ArrayList<Wiezien> listaPracownikow, String nazwaPracy) {
        this.listaPracownikow = listaPracownikow;
        this.nazwaPracy = nazwaPracy;
    }

    public ArrayList<Wiezien> getListaPracownikow() {
        return listaPracownikow;
    }

    public void setListaPracownikow(ArrayList<Wiezien> listaPracownikow) {
        this.listaPracownikow = listaPracownikow;
    }

    public String getNazwaPracy() {
        return nazwaPracy;
    }

    public void setNazwaPracy(String nazwaPracy) {
        this.nazwaPracy = nazwaPracy;
    }
}
