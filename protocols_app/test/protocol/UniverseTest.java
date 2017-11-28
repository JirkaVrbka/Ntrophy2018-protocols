/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import protocol.enums.Action;
import protocol.enums.Attributes;

/**
 *
 * @author Ondrej Urbanovsky
 */
public class UniverseTest {
    private Universe uni = new Universe();
    private List <Attributes> astAttr = new ArrayList<>();
    private List <Attributes> astmissing = new ArrayList<>();
    
    @Before
    public void setUp() throws Exception {
        
    }        
    


    /**
     * Test of CreateObj method, of class Universe.
     */
    /*
    @Test
    public void testCreateObj() throws Exception {
        
    }*/

    /**
     * Test of removeObj method, of class Universe.
     */
    @Test
    public void testRemoveObj() {
        System.out.println("removeObj");
        int objectID = 0;
        Universe instance = new Universe();
        boolean expResult = false;
        boolean result = instance.removeObj(objectID);
        assertEquals(expResult, result);
        objectID = 5;
        astAttr.add(Attributes.RESOURCES);
        uni.CreateObj(Type.ASTEROID, astAttr, astmissing);
        result = uni.removeObj(objectID);
        assertEquals(true, result);
        assertTrue(uni.getObjects().size() == 5);        
    }

    /**
     * Test of evalAction method, of class Universe.
     */
    @Test
    public void testEvalAction() {
        assertEquals("Body za těžbu zdrojů: 3", uni.evalAction(Action.GATHER_RESOURCES, 0));
        astmissing.add(Attributes.RESOURCES);
        astmissing.add(Attributes.FAST);
        astmissing.add(Attributes.BIGGER);
        astmissing.add(Attributes.ACT_WEAPON);
        astmissing.add(Attributes.WEAPONS);
        astmissing.add(Attributes.COMUNICATES);
        astmissing.add(Attributes.LIFE);
        uni.CreateObj(Type.ASTEROID, astAttr, astmissing);
        assertEquals("Nelze vyhodnotit není specifikováno dostatek atributů", uni.evalAction(Action.SHOOT, 5));
        
    }

    /**
     * Test of ask method, of class Universe.
     */
    @Test
    public void testAsk() {
        assertTrue(uni.ask(Attributes.LIFE, 1));
        assertTrue(uni.ask(Attributes.RESOURCES, 0));
        assertTrue(uni.ask(Attributes.WEAPONS, 2));
        assertTrue(uni.ask(Attributes.BIGGER, 4));
        assertFalse(uni.ask(Attributes.WEAPONS, 4));
        astAttr.add(Attributes.RESOURCES);
        astmissing.add(Attributes.BIGGER);
        uni.CreateObj(Type.ASTEROID, astAttr, astmissing);
        assertFalse(uni.ask(Attributes.BIGGER, 5));
      
        
        
        
    }
    
}
