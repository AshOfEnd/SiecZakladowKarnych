package aktywnoscWiezien;

import aktywnoscWiezien.Izolatka;
import pracownicy.Pracownik;
import wyposazenie.Magazyn;

import java.util.ArrayList;

public class Placowka
{
    private ArrayList<Izolatka> listaIzolatek;
    private ArrayList<Wiezien> listaWiezniow;
    private Magazyn magazyn;
    private ArrayList<Pracownik> listaPracownikow;



    public Placowka(ArrayList<Izolatka> listaIzolatek, ArrayList<Wiezien> listaWiezniow) {
        this.listaIzolatek = listaIzolatek;
        this.listaWiezniow = listaWiezniow;
    }

    public Placowka()
    {
        listaIzolatek = new ArrayList<Izolatka>();
        listaWiezniow = new ArrayList<Wiezien>();
        listaPracownikow = new ArrayList<Pracownik>();
        magazyn = new Magazyn();
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

    public void usunWieznia(int id)
    {
        listaWiezniow.remove(id);
    }

    public void usunIzolatke(int id)
    {
        listaIzolatek.remove(id);
    }

    public void wyslijWiezniaDoIzolatki(Wiezien w)
    {
        for(int i=0; i<listaIzolatek.size(); i++)
        {
            if(listaIzolatek.get(i).sprawdzCzyJestPusta())
            {
                listaIzolatek.get(i).dodajWieznia(w);
                return;
            }
        }
    }

    public void dodajPracownika(Pracownik p)
    {
        listaPracownikow.add(p);
    }

    public void usunPracownika(String login)
    {
        listaPracownikow.remove(getIdPracownika(login));
    }


}

/*
    Ludzie :
        pracownicy.Konserwator
        pracownicy.Kucharz
        pracownicy.Lekarz
        pracownicy.Magazynier
        pracownicy.Naczelnik
        pracownicy.Wychowawca

        aktywnoscWiezien.Wiezien
            wyposazenie.Lek
            aktywnoscWiezien.Skargi

    Miejsca :
        aktywnoscWiezien.Placowka
            aktywnoscWiezien.Izolatka
            wyposazenie.Magazyn

    "cos" :
        wyposazenie.Archiwum
        wyposazenie.Formularz
        aktywnoscWiezien.Kurs
        aktywnoscWiezien.Praca
        wyposazenie.Produkt
        wyposazenie.Raport
        wyposazenie.Zamowienie
        wyposazenie.ZgloszenieUsterki

 */