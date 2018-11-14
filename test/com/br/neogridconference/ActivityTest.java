/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.neogridconference;

import com.br.neogridconference.Activity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author giorgy
 */
public class ActivityTest {
    
    Activity activityTest;
    
    public ActivityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.activityTest = new Activity("shortCourse X", 30 );
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Activity.
     */
    @Test
    public void testGetName() {
        assertEquals("shortCourse X", this.activityTest.getName());
    }

    /**
     * Test of setName method, of class Activity.
     */
    @Test
    public void testSetName() {
        this.activityTest.setName("shortCourse Y");
        assertEquals("shortCourse Y", this.activityTest.getName());

    }

    /**
     * Test of getTime method, of class Activity.
     */
    @Test
    public void testGetTime() {
        assertEquals((int) 30, this.activityTest.getTime());

    }

    /**
     * Test of setTime method, of class Activity.
     */
    @Test
    public void testSetTime() {
        this.activityTest.setTime(45);
        assertEquals(45, this.activityTest.getTime());
    }

    /**
     * Test of toString method, of class Activity.
     */
    @Test
    public void testToString() {
        assertEquals("ActivityObject{name= shortCourse X, time= 30}",this.activityTest.toString());
    }
    
}
