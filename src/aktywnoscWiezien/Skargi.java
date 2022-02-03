package aktywnoscWiezien;

import aktywnoscWiezien.Wiezien;

import java.util.Date;

public class Skargi
{
    private String tresc;
    private Date data;

    public Skargi(String tresc, Date data) {
        this.tresc = tresc;
    }



    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

}
