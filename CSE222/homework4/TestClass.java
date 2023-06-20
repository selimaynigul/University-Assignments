/**
 * 
 * @author Selim Aynigul
 */
package homework4;

public class TestClass {

    public static int testNumCount = 1;

    /**
     * Check validation of the officer's username and passwords
     * 
     * @param officer will be checked
     */
    public static boolean tryToEnter(Officer officer) {

        int[] denominations = {4,17,29};    

        System.out.println("\nTest " + testNumCount++ + "... Inputs:");
        System.out.print("Username: \"" + officer.getUsername() + "\"");
        System.out.print(" - Password1: \"" + officer.getPassword1() + "\"");
        System.out.println(" - Password2: \"" + officer.getPassword2() + "\"");
       
        if(Username.checkIfValidUsername(officer.getUsername()) &&
           Password1.checkSize(officer.getPassword1()) &&
           Password1.checkCharacters(officer.getPassword1()) &&
           Password1.checkBrackets(officer.getPassword1()) &&
           Password1.containsUserNameSpirit(officer.getPassword1(),officer.getUsername()) &&
           Password1.isBalancedPassword(officer.getPassword1()) &&
           Password1.isPalindromePossible(officer.getPassword1()) &&
           Password2.checkSize(officer.getPassword2()) &&
           Password2.isExactDivision(officer.getPassword2(),denominations)
          ) 
        {
            System.out.println("The username and passwords are valid. The door is opening, please wait...");
            return true;
        }
        return false;
    }
}