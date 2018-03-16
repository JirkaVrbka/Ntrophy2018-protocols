/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import protocol.enums.EAction;
import protocol.enums.EAttributes;
import protocol.enums.EType;
import protocol.objects.SpaceObject;

/**
 *
 * @author Ondrej Urbanovsky
 */
public class UniverseTest {
    private Universe uni = new Universe();
    private List <EAttributes> astAttr = new ArrayList<>();
    private List <EAttributes> astmissing = new ArrayList<>();
    
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
        astAttr.add(EAttributes.RESOURCES);
        uni.CreateObj(EType.ASTEROID, astAttr, astmissing);
        result = uni.removeObj(objectID);
        assertEquals(true, result);
        assertTrue(uni.getObjects().size() == 5);        
    }

    /**
     * Test of evalAction method, of class Universe.
     */
    @Test
    public void testEvalAction() {
        assertEquals("Body za těžbu zdrojů: 3", uni.evalAction(EAction.GATHER_RESOURCES, 0));
        astmissing.add(EAttributes.RESOURCES);
        astmissing.add(EAttributes.FAST);
        astmissing.add(EAttributes.BIGGER);
        astmissing.add(EAttributes.ACT_WEAPON);
        astmissing.add(EAttributes.WEAPONS);
        astmissing.add(EAttributes.COMUNICATES);
        astmissing.add(EAttributes.LIFE);
        uni.CreateObj(EType.ASTEROID, astAttr, astmissing);
        assertEquals("Nelze vyhodnotit není specifikováno dostatek atributů", uni.evalAction(EAction.SHOOT, 5));
        
    }

    /**
     * Test of ask method, of class Universe.
     */
    @Test
    public void testAsk() {
        assertTrue(uni.ask(EAttributes.LIFE, 1));
        assertTrue(uni.ask(EAttributes.RESOURCES, 0));
        assertTrue(uni.ask(EAttributes.WEAPONS, 2));
        assertTrue(uni.ask(EAttributes.BIGGER, 4));
        assertFalse(uni.ask(EAttributes.WEAPONS, 4));
        astAttr.add(EAttributes.RESOURCES);
        astmissing.add(EAttributes.BIGGER);
        uni.CreateObj(EType.ASTEROID, astAttr, astmissing);
        assertFalse(uni.ask(EAttributes.BIGGER, 5));
    }
    @Test 
    public void testCreateAll() {
        uni.createAll();
        assertTrue(uni.getObjects().size() > 50);
    }
}
