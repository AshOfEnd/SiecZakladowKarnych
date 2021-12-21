import java.util.List;

public class Kurs
{
    private List<Wiezien> czlonkowieKursu;
    private String nazwaKursu;

    public Kurs(List<Wiezien> czlonkowieKursu, String nazwaKursu) {
        this.czlonkowieKursu = czlonkowieKursu;
        this.nazwaKursu = nazwaKursu;
    }

    public List<Wiezien> getCzlonkowieKursu() {
        return czlonkowieKursu;
    }

    public void setCzlonkowieKursu(List<Wiezien> czlonkowieKursu) {
        this.czlonkowieKursu = czlonkowieKursu;
    }

    public String getNazwaKursu() {
        return nazwaKursu;
    }

    public void setNazwaKursu(String nazwaKursu) {
        this.nazwaKursu = nazwaKursu;
    }
}
