package my.oktmo.lab3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    private OktmoData data;

    @Before
    public void setUp() throws Exception {
        String filename = "data-201710.csv",
                encoding = "cp1251";
        data = new OktmoData();

        OktmoReader testReader = new OktmoReader();
        testReader.readPlacesFunconality(filename, encoding, data);
    }


    @Test
    public void countMOinRB() {
        assertEquals(63, data.getCountMOinRB());
    }

    @Test
    public void countSelsovetInRBRayon() {
        assertEquals("Альшеевский район", 20,       data.getCountSelsovetInRBRayon(80602000000L));
        assertEquals("Давлекановский район", 17,    data.getCountSelsovetInRBRayon(80622000000L));
    }

}