/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitteststat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hashan
 */
public class jblink_statsTest {
    
    ArrayList<Integer> testDataIntegers = new ArrayList<>(Arrays.asList(9,2,7,4,5,6,3,8,1,10));
    ArrayList<Double> testDataDoubles = new ArrayList<>(Arrays.asList(2.2, 100.0, 17.5, 30.2, 31.1));
    
    public jblink_statsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of average method, of class jblink_stats.
     */
    @Test
    public void testAverage() {
        
        System.out.println("average");
        double expResult = 5.5;
        double result = jblink_stats.average(testDataIntegers, true);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of sum method, of class jblink_stats.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        double expResult = 55;
        double result = jblink_stats.sum(testDataIntegers, true);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of median method, of class jblink_stats.
     */
    @Test
    public void testMedian() {
        System.out.println("median");
        double expResult = 5.5;
        double result = jblink_stats.median(testDataIntegers);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of standardDeviation method, of class jblink_stats.
     */
    @Test
    public void testStandardDeviation() {
        System.out.println("standardDeviation");
        double expResult = 3.03;
        double result = jblink_stats.standardDeviation(testDataIntegers);
        assertEquals(expResult, result, 0.01);
    }
    
    @Test
    public void testAverage2() {
        
        System.out.println("average-2");
        double expResult = 36.2;
        double result = jblink_stats.average(testDataDoubles, true);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of sum method, of class jblink_stats.
     */
    @Test
    public void testSum2() {
        System.out.println("sum-2");
        double expResult = 181;
        double result = jblink_stats.sum(testDataDoubles, true);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of median method, of class jblink_stats.
     */
    @Test
    public void testMedian2() {
        System.out.println("median-2");
        double expResult = 30.2;
        double result = jblink_stats.median(testDataDoubles);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of standardDeviation method, of class jblink_stats.
     */
    @Test
    public void testStandardDeviation2() {
        System.out.println("standardDeviation-2");
        double expResult = 37.54;
        double result = jblink_stats.standardDeviation(testDataDoubles);
        assertEquals(expResult, result, 0.01);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAverageException() {
        
        ArrayList<Integer> testDataException = new ArrayList<>(Arrays.asList(-9,-2,-7,-4,-5,-6,-3,-8,-1,-10));
        
        System.out.println("average-exception");
        double expResult = 36.2;
        double result = jblink_stats.average(testDataException, false);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of sum method, of class jblink_stats.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSumException() {
        ArrayList<Integer> testDataException = new ArrayList<>(Arrays.asList());
        System.out.println("sum-exception");
        double expResult = 181;
        double result = jblink_stats.sum(testDataException, false);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of standardDeviation method, of class jblink_stats.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testStandardDeviationException() {
        ArrayList<Integer> testDataException = new ArrayList<>(Arrays.asList());
        System.out.println("standardDeviation-exception");
        double expResult = 37.54;
        double result = jblink_stats.standardDeviation(testDataException);
        assertEquals(expResult, result, 0.01);
    }
    
    
    
}
