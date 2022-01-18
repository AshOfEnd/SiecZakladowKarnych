import java.util.ArrayList;

public class Placowka
{
    private ArrayList<Izolatka> listaIzolatek;
    private ArrayList<Wiezien> listaWiezniow;
    private Magazyn magazyn;
    private ArrayList<Pracownik> listaPracownikow;



    public Placowka(ArrayList<Izolatka> listaIzolatek, ArrayList<Wiezien> listaWiezniow, int numerPlacowki) {
        this.listaIzolatek = listaIzolatek;
        this.listaWiezniow = listaWiezniow;
    }

    public Placowka()
    {
        listaIzolatek = new ArrayList<Izolatka>();
        listaWiezniow = new ArrayList<Wiezien>();
        listaPracownikow = new ArrayList<Pracownik>();
    }

    public void wyswietl() {}
    public void przeniesWieznia() {}

    public ArrayList<Izolatka> getListaIzolatek() {
        return listaIzolatek;
    }

    public void setListaIzolatek(ArrayList<Izolatka> listaIzolatek) {
        this.listaIzolatek = listaIzolatek;
    }

    public ArrayList<Wiezien> getListaWiezniow() {
        return listaWiezniow;
    }

    public void setListaWiezniow(ArrayList<Wiezien> listaWiezniow) {
        this.listaWiezniow = listaWiezniow;
    }

    public int getIdPracownika(String login)
    /*
        Przyjmuje login szukanego pracownika i zwraca numer pod jakim jest w liscie pracownikow
    */
    {
        for(int i=0; i<listaPracownikow.size();i++)
            if(listaPracownikow.get(i).sprawdzCzyToOn(login))
                return i;
        return 0;
    }

    public void dodajIzolatke()
    {
        listaIzolatek.add(new Izolatka());
    }
    public void dodajWieznia(Wiezien w)
    {
        listaWiezniow.add(w);
    }

}

/*
    Ludzie :
        Konserwator
        Kucharz
        Lekarz
        Magazynier
        Naczelnik
        Wychowawca

        Wiezien
            Lek
            Skargi

    Miejsca :
        Placowka
            Izolatka
            Magazyn

    "cos" :
        Archiwum
        Formularz


        Kurs
        Praca
        Produkt
        Raport
        Zamowienie
        ZgloszenieUsterki

 */