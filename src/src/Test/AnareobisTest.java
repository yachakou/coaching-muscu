package Test;

import Modele.Anareobis;import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.Exception;import static org.junit.Assert.*;

public class AnareobisTest {

    private Anareobis a;
    
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    a = null;
    }

    @Test
    public void testAddAndLoadExercice() throws Exception {
        Anareobis a = new Anareobis("ExoAnaerobis","Jogging",10,20);
        a.addExercice();
        Anareobis b = new Anareobis();
        b.loadExercice(a.getId());
        assertEquals(b.getId(),a.getId());
        assertEquals(b.getDesc(),a.getDesc());
        assertEquals(b.getRepetition(),a.getRepetition());
        assertEquals(b.getTitre(),a.getTitre());
    }
}