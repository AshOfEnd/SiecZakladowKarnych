package aktywnoscWiezien;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlacowkaTest {



    @Test
    void getIdPracownika() {
        Placowka placowka=new Placowka();
        String login="xx";
        assertNotEquals(1,placowka.getIdPracownika(login));
    }



    @Test
    void usunWiezniaZIzolatki() {
        Placowka placowka=new Placowka();
        assertEquals(0,placowka.getListaIzolatek().size());
    }
    @Test
    void wyslijWiezniaDoIzolatki( ) {
        Placowka placowka=new Placowka();
        assertEquals(0,placowka.getListaIzolatek().size());
    }
}