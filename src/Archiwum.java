import java.util.List;

public class Archiwum
{
    private List<Raport> listaRaportow;
    private List<ZgloszenieUsterki> listaZgloszonychUsterek;

    public Archiwum(List<Raport> listaRaportow, List<ZgloszenieUsterki> listaZgloszonychUsterek) {
        this.listaRaportow = listaRaportow;
        this.listaZgloszonychUsterek = listaZgloszonychUsterek;
    }

    public void dodajRaport() {}
    public void wyswietlZgloszenie() {}
    public void zmienStanZgloszenie() {}

    public List<Raport> getListaRaportow() {
        return listaRaportow;
    }

    public void setListaRaportow(List<Raport> listaRaportow) {
        this.listaRaportow = listaRaportow;
    }

    public List<ZgloszenieUsterki> getListaZgloszonychUsterek() {
        return listaZgloszonychUsterek;
    }

    public void setListaZgloszonychUsterek(List<ZgloszenieUsterki> listaZgloszonychUsterek) {
        this.listaZgloszonychUsterek = listaZgloszonychUsterek;
    }
}
