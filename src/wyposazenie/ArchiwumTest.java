package wyposazenie;

import aktywnoscWiezien.Izolatka;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ArchiwumTest {

    @Test
    void dodajRaport() throws ParseException {
        var izolatka=new Archiwum();
        String data="10/10/2020";
        Date data1=new SimpleDateFormat("dd/MM/yyyy").parse(data);
        Raport raport=new Raport("aa","ss","aaaa",data1);
        assertEquals(1,izolatka.dodajRaport(raport));
    }
    @Test
    void wyswietlZgloszenie() throws ParseException {
        var izolatka=new Archiwum();

        assertEquals(0,izolatka.wyswietlZgloszenie());
    }



}