import java.util.Date;

public class ZgloszenieUsterki
{
    private String tresc;
    private Date data;
    private boolean stan;

    public ZgloszenieUsterki(String tresc, Date data, boolean stan) {
        this.tresc = tresc;
        this.data = data;
        this.stan = stan;
    }

    public void wyswietlFormularz() {}
    public void wyslij() {}

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isStan() {
        return stan;
    }

    public void setStan(boolean stan) {
        this.stan = stan;
    }
}
