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

    }

    @Test
    public void testTicker(){
        Tabata tabata = new Tabata(4, 5, 10);
        for (int i = 0; i < 100; i++) {
            tabata.tick();
            System.out.println(tabata.toString() + " " + tabata.round);
        }

    }

    @Test
    public void testToggleDisplay(){
        Tabata tabata = new Tabata(4, 10, 20);
        for (int i = 0; i < 100; i++) {
            tabata.tick();
            System.out.println(tabata.toString() + " " + tabata.round);
        }
    }

}