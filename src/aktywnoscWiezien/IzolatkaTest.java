package aktywnoscWiezien;

import static org.junit.jupiter.api.Assertions.*;

class IzolatkaTest {

    @org.junit.jupiter.api.Test
    void sprawdzCzyJestPusta() {
        var izolatka=new Izolatka();

        assertTrue(izolatka.sprawdzCzyJestPusta());

    }



}