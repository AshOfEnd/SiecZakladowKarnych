package wyposazenie;

import java.util.Date;

public class ZgloszenieUsterki
{
    private String tresc;
    private Date data;
    private boolean stan;

    public ZgloszenieUsterki(String tresc, Date data) {
        this.tresc =tresc;
        this.data =data;
        this.stan = false; //false oznacza że usterka nie została naprawiona
    }

    public void wyswietlFormularz()
    {
        System.out.println("Wyswietl Formularz");
    }
    public void zmienStanZgloszenie(boolean stan)
    {
        if(stan == true)
        {
            stan = false;
        }
        stan = true;
    }
}
