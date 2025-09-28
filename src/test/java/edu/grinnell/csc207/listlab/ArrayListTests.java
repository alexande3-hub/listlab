package edu.grinnell.csc207.listlab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class ArrayListTests {
    @Test
    public void emptyListTest() {
        ArrayList list = new ArrayList();
        assertEquals(0, list.size());
    }

    @Test
    public void listAddSize10() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(10, list.size());
    }

    @Test
    public void get2() {
        ArrayList list = new ArrayList();
        list.add(3);
        list.add(4);
        list.add(5);
        assertEquals(5, list.get(2));
    }

    @Test
    public void remove1() {
        ArrayList list = new ArrayList();
        list.add(3);
        list.add(4);
        list.add(5);
        assertEquals(4, list.remove(1));
    }

    @Property
    public boolean listAddSize(@ForAll @IntRange(min = 0, max = 1000) int sz) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < sz; i++) {
            list.add(i);
        }
        return list.size() == sz;
    }

    @Property
    public boolean listGet(@ForAll @IntRange(min = 0, max = 1000) int sz) {
        ArrayList list = new ArrayList();
        int getSum = 0;
        list.add(3);
        list.add(4);
        list.add(5);
        getSum = list.get(0) + list.get(1) + list.get(2);
        return getSum == 12;
    }

}
