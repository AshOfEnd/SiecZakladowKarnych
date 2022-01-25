import java.util.ArrayList;

public class Placowka
{
    private Magazyn magazyn;
    private ArrayList<Wiezien> listaWiezniow;
    private ArrayList<Pracownik> listaPracownikow;
    private ArrayList<Skargi> listaSkarg;
    private ArrayList<Wiezien> listaKursantow;
    private ArrayList<Kurs> listaKursow;
    private ArrayList<Zamowienie> listaZamowien;
    private ArrayList<Produkt> listaProdoktow;
    private ArrayList<Praca> listaPrac;
    private ArrayList<Raport> listaRaportow;
    private ArrayList<ZgloszenieUsterki> listaZgloszonychUsterek;



    public Placowka( ArrayList<Wiezien> listaWiezniow,ArrayList<Pracownik> listaPracownikow) {
        this.listaWiezniow = listaWiezniow;
        this.listaPracownikow=listaPracownikow;
    }

    public Placowka()
    {

        listaWiezniow = new ArrayList<Wiezien>();
        listaPracownikow = new ArrayList<Pracownik>();
        listaSkarg=new ArrayList<Skargi>();
        listaKursantow=new ArrayList<Wiezien>();
        listaKursow=new ArrayList<Kurs>();
        listaZamowien=new ArrayList<Zamowienie>();
        listaProdoktow=new ArrayList<Produkt>();
        listaPrac=new ArrayList<Praca>();
        listaRaportow=new ArrayList<Raport>();
        listaZgloszonychUsterek=new ArrayList<ZgloszenieUsterki>();



        magazyn = new Magazyn();
    }
    public void dodajRaport(Raport r)
    {
        listaRaportow.add(r);
    }

    public void dodajSkargi (Skargi s)
    {
        listaSkarg.add(s);
    }
    public void dodajKurs (Kurs k)
    {
        listaKursow.add(k);
    }

    public void wyswietl() {}
    public void przeniesWieznia() {}





    public ArrayList<Wiezien> getListaWiezniow() {
        return listaWiezniow;
    }
    public ArrayList<Pracownik> getListaPracownikow(){
        return listaPracownikow;
    }
    public ArrayList<Skargi> getListaSkarg(){
        return listaSkarg;
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


    public void dodajWieznia(Wiezien w)
    {
        listaWiezniow.add(w);
    }

    public void usunWieznia(int id)
    {
        listaWiezniow.remove(id);
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