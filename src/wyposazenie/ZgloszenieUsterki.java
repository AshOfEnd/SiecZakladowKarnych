package wyposazenie;

import java.util.Date;

public class ZgloszenieUsterki
{
    private String tresc;
    private Date data;
    private boolean stan;

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
