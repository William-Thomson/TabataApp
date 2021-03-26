package au.edu.jcu.cp3406.tabataApp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testConstructor(){
        Tabata tabata = new Tabata(2, 70, 20);
        assertTrue(tabata.workSeconds == 10);

    }

    @Test
    public void testTicker(){
        Tabata tabata = new Tabata(4, 70, 20);
        for (int i = 0; i < 20; i++) {
            tabata.tick();
            tabata.toString();
        }

    }
}