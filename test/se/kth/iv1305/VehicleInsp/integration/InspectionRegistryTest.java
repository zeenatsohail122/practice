/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1305.VehicleInsp.integration;

import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1305.VehicleInsp.model.VehicleLicenseNo;

/**
 *
 * @author ZeenatAli
 */
public class InspectionRegistryTest {
    
    public InspectionRegistryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of findInspection method, of class InspectionRegistry.
     */
    @Test
    public void testFindInspection() {
        System.out.println("findInspection");
        VehicleLicenseNo vehicleLicenseNo = new VehicleLicenseNo(1232432546);
        InspectionRegistry instance = new InspectionRegistry();
        List<String> result = instance.findInspection(vehicleLicenseNo).getInspectionListString();
        List<String> expResult = new ArrayList<String>();
        
        expResult.add("Air Condititioner");
        expResult.add("Locker");
        expResult.add("Battery");
        expResult.add("Exhaust");
        
        assertEquals(expResult, result);
        
    }
    
}
