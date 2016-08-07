package Test;

import Modele.Aerobis;import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.Exception;import static org.junit.Assert.*;

public class AerobisTest {
    
private Aerobis a;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
      a = null;
  
    }

    @Test
    public void testAddAndLoadExercice() throws Exception {
        Aerobis a = new Aerobis("ExoMatin","Jogging",10,20);
        a.addExercice();
        Aerobis b = new Aerobis();
        b.loadExercice(a.getId());
        assertEquals(b.getId(),a.getId());
        assertEquals(b.getDesc(),a.getDesc());
        assertEquals(b.getRepetition(),a.getRepetition());
        assertEquals(b.getTitre(),a.getTitre());
    }
}