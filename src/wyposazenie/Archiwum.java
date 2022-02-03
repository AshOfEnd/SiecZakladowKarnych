package wyposazenie;

import java.util.ArrayList;

public class Archiwum
{
    private ArrayList<Raport> listaRaportow;
    private ArrayList<ZgloszenieUsterki> listaZgloszonychUsterek;

    public Archiwum()
    {
        listaRaportow = new ArrayList<>();
        listaZgloszonychUsterek = new ArrayList<>();
    }

    public Archiwum(ArrayList<Raport> listaRaportow, ArrayList<ZgloszenieUsterki> listaZgloszonychUsterek) {
        this.listaRaportow = listaRaportow;
        this.listaZgloszonychUsterek = listaZgloszonychUsterek;
    }

    public short dodajRaport(Raport raport)
    {
        listaRaportow.add(raport);
        return 0;
    }
    public void dodajUsterke(ZgloszenieUsterki zgloszenieUsterki)
    {
        listaZgloszonychUsterek.add(zgloszenieUsterki);
    }
    public short wyswietlZgloszenie()
    {
        System.out.println("Wyswietl zgloszenie usterki"+listaZgloszonychUsterek);
        return 0;
    }


    public ArrayList<Raport> getListaRaportow() {
        return listaRaportow;
    }

    public void setListaRaportow(ArrayList<Raport> listaRaportow) {
        this.listaRaportow = listaRaportow;
    }

    public ArrayList<ZgloszenieUsterki> getListaZgloszonychUsterek() {
        return listaZgloszonychUsterek;
    }

    public void setListaZgloszonychUsterek(ArrayList<ZgloszenieUsterki> listaZgloszonychUsterek) {
        this.listaZgloszonychUsterek = listaZgloszonychUsterek;
    }
}


