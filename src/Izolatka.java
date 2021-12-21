public class Izolatka {
    private int numerIzolatki;
    private Wiezien wiezien;

    public Izolatka(int numerIzolatki, Wiezien wiezien) {
        this.numerIzolatki = numerIzolatki;
        this.wiezien = wiezien;
    }

    public void przydzielDoIzolatki() {}
    public void usunZIzolatki() {}

    public int getNumerIzolatki() {
        return numerIzolatki;
    }

    public Wiezien getWiezien() {
        return wiezien;
    }

    public void setNumerIzolatki(int numerIzolatki) {
        this.numerIzolatki = numerIzolatki;
    }

    public void setWiezien(Wiezien wiezien) {
        this.wiezien = wiezien;
    }
}
