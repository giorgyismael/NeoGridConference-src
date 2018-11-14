/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.neogridconference;

import com.br.neogridconference.Activity;
import com.br.neogridconference.ReadActivityFile;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author giorgy
 */
public class ReadActivityFileTest {

    protected 
        String pathFileTest = "src/com/br/neogridconference/inputTest00.txt";
        ReadActivityFile activityFileTest;

    public ReadActivityFileTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.activityFileTest = new ReadActivityFile();
        this.activityFileTest.startReadActivityFile(this.pathFileTest);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of startReadActivityFile method, of class ReadActivityFile.
     */
    @Test
    public void testStartReadActivityFile() {
        ReadActivityFile resultExpecteds = new ReadActivityFile();
        resultExpecteds.addActivity("Writing Fast Tests Against Enterprise Rails", 60);

        assertArrayEquals(resultExpecteds.getActivitiesList(),  activityFileTest.getActivitiesList());
  
    }

    /**
     * Test of dividerNameEndTime method, of class ReadActivityFile.
     */
    @Test
    public void testDividerNameEndTime() {

    }

    /**
     * Test of addActivity method, of class ReadActivityFile.
     */
    @Test
    public void testAddActivity_String_int() {

    }

    /**
     * Test of addActivity method, of class ReadActivityFile.
     */
    @Test
    public void testAddActivity_Activity() {

    }

    /**
     * Test of removeActivity method, of class ReadActivityFile.
     */
    @Test
    public void testRemoveActivity() {

    }

    /**
     * Test of getActivitiesList method, of class ReadActivityFile.
     */
    @Test
    public void testGetActivitiesList() {

    }

    /**
     * Test of getByIdInActivitiesList method, of class ReadActivityFile.
     */
    @Test
    public void testGetByIdInActivitiesList() {

    }

    /**
     * Test of getLongerTimeActivity method, of class ReadActivityFile.
     */
    @Test
    public void testGetLongerTimeActivity() {

    }

    /**
     * Test of getShorterTimeActivity method, of class ReadActivityFile.
     */
    @Test
    public void testGetShorterTimeActivity() {

    }

    /**
     * Test of getTimeActivityWith30Min method, of class ReadActivityFile.
     */
    @Test
    public void testGetTimeActivityWith30Min() {

    }

    /**
     * Test of printList method, of class ReadActivityFile.
     */
    @Test
    public void testPrintList() {

    }

    private void assertArrayEquals(List<Activity> activitiesList, List<Activity> activitiesList0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
