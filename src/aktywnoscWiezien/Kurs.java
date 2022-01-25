package aktywnoscWiezien;

import java.util.ArrayList;

public class Kurs
{
    private ArrayList<Wiezien> czlonkowieKursu;
    private String nazwaKursu;

    public Kurs(ArrayList<Wiezien> czlonkowieKursu, String nazwaKursu) {
        this.czlonkowieKursu = czlonkowieKursu;
        this.nazwaKursu = nazwaKursu;
    }

    public ArrayList<Wiezien> getCzlonkowieKursu() {
        return czlonkowieKursu;
    }

    public void setCzlonkowieKursu(ArrayList<Wiezien> czlonkowieKursu) {
        this.czlonkowieKursu = czlonkowieKursu;
    }

    public String getNazwaKursu() {
        return nazwaKursu;
    }

    public void setNazwaKursu(String nazwaKursu) {
        this.nazwaKursu = nazwaKursu;
    }
}
