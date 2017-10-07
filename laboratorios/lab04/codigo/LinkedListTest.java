import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test class. Took from teacher Mauricio's repository:
 * https://github.com/mauriciotoro/ST0245-Eafit/blob/master/laboratorios/lab04/codigo/Java/Laboratorio3/src/LinkedListMauricioTest.java
 * Date: 6-10-2017
 *
 * Tener en cuenta que los tests en JUnit solo compilarán si se adicionan
 * las bibliotecas de JUnit y Hamcrest. Aquí no fue realizado por limpieza,
 * sin embargo, si se desea comprobar, tendría que ser realaizado en algún IDE.
 */
public class LinkedListTest {

    @Test
    public void testAdd() {
        LinkedList<Integer> list = new LinkedList();
        list.add(0, 5);
        list.add(0, 4);
        list.add(0, 3);
        list.add(0, 2);
        list.add(0, 1);
        for (int i = 0; i < list.getSize(); i++) {
            int x;
            assertEquals(x = list.get(0), 1);
            assertEquals(x = list.get(1), 2);
            assertEquals(x = list.get(2), 3);
            assertEquals(x = list.get(3), 4);
            assertEquals(x = list.get(4), 5);
        }
    }

    @Test
    public void testRemove() {
        LinkedList list = new LinkedList();
        list.add(0, 5);
        list.add(0, 4);
        list.add(0, 3);
        list.add(0, 2);
        list.add(0, 1);
        assertTrue(list.contains(3));
        list.remove(2);
        assertFalse(list.contains(3));
    }

    @Test
    public void testContains() {
        LinkedList list = new LinkedList();
        list.add(0, 5);
        list.add(0, 4);
        list.add(0, 3);
        list.add(0, 2);
        list.add(0, 1);
        assertTrue(list.contains(3));
        assertFalse(list.contains(10));
    }
}
