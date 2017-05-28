
package se.kth.iv1305.VehicleInsp.startup;

/**
 *
 * Performs complete startup of the application
 */
public class Main {
    public static void main(String[] args){
        Garage garage= new Garage();
        RegistryCreator creator = new RegistryCreator();
        Printer printer = new Printer();
        PaymentAuthorization paymentAuthorization = new PaymentAuthorization();
        Controller contr = new Controller(garage, creator, printer, paymentAuthorization);
        
        //start new inspection
        System.out.println("StartNewIspection");
        contr.startNewInspection();
        
        //enter license no
        System.out.println("Enter License Number : 456789");
        VehicleLicenseNo vehicleLicenseNo = (456789);
        ListOfInspection listOfInspection = contr.findInspection(vehicleLicenseNo);
        
        // return inspection instructions
        System.out.println("Inspections that needs to be performed are: ");
        for(int i=0; i<listOfInspection.getInspectionListString().size(); i++){
            System.out.println(listOfInspection.getInspectionListString().get(i) + " ");
        }
        
        // specify/return cost of inspection
        System.out.println();
        int cost = contr.getCost(listOfInspection);
        System.out.println("Cost for inpection is: " + cost);
        
        //payment with credit card
        System.out.println("Payment: ");
        String number = "2030203";
        String holder = "Sara Carlson";
        int pin = 11111;
        int cvc = 314;
        Date expirationDate = new Date();
        CreditCard creditCard = new CreditCard(number, holder, pin, cvc, expirationDate);
        boolean paid = contr.payWithCreditCard(creditCard, cost);
        if(paid){
            System.out.println("Successfully paid");
        }else{
            System.out.println("Payment Failed");
        }
        
        //perform Inspection and give inspection results
        System.out.println("Perform Inspection");
        Random result = new Random();
        for(int i=0; i<listOfInspection.getInspectionListString().size(); i++){
            boolean currentResult = result.nextBoolean();
            System.out.println(i + "inspection is" + listOfInspection.getInspectionListString().get(i));
            System.out.println ("Result of Inspection:" + currentResult);
            contr.setResult(listOfInspection.getInspectionListString().get(i),currentResult);
        }
        
        
        
             
        
        
        
        
        
        
        
    }
    
}
