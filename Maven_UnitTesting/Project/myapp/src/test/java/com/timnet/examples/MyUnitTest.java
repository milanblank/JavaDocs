package com.timnet.examples;

import com.timnet.MyUnit;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Created by Milan.Stojiljkovic on 7/10/2017.
 */
public class MyUnitTest {

    @Test
    public void testConcatenate(){
        MyUnit myUnit = new MyUnit();

        String result = myUnit.concatenate("one","two");

        assertEquals("onetwo", result);
    }

    @Test
    public void testConcatenateNulls(){
        MyUnit myUnit = new MyUnit();

        String result = myUnit.concatenate(null,null);

        assertEquals(null, result);

        result = myUnit.concatenate("one",null);

        assertNotNull(result);
        assertEquals("one", result);

        result = myUnit.concatenate(null,"two");

        assertNotNull(result);
        assertEquals("two", result);
    }

    @Test
    public void testGetBoolean(){
        MyUnit myUnit = new MyUnit();

        assertNotNull(myUnit.getBoolean());

        assertTrue((Boolean)myUnit.getBoolean() instanceof Boolean);

        assertThat(123, is(123));

        assertThat("a", not(is("b")));

    }
}
