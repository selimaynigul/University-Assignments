/**
 * 
 * @author Selim Aynigul
 */
package homework4; 

public class Password2 {

    /**
     * check if password2's value is between boundries
     * 
     * @param password2 will be checked
     * @return if password's value is between 10 and 10000 return true, otherwise return false
     */
    public static boolean checkSize(int password2) {

        if(password2 < 10 || password2 > 10000) {
            System.out.println("The password2 is invalid. It should be between 10 and 10,000.");
            return false;
        }
        return true;
    }

    /**
     * check if it is possible to obtain password2 with given denominations
     * 
     * @param password2 will be checked
     * @param denominations 
     * @return if it is possible to obtain password2 with denominations return true, otherwise return false
     */
    public static boolean isExactDivision(int password2, int[] denominations) {
        // Call the helper function to check if exact division is possible
        if(isExactDivisionHelper(denominations, 0, password2))
            return true;
        else {
            System.out.println("The password2 is invalid. It is not compatible with the denominations.");
            return false;
        }
    }
    
    /**
     * 
     * @param target
     * @param denominations
     * @param start
     * @return
     */
    private static boolean isExactDivisionHelper(int[] denominations, int start, int target) {
        // Base case: the target has been reached, so return true
        if (target == 0) return true;
        
        // Recursive case: try subtracting each denomination from the target
        for (int i = start; i < denominations.length; i++) {
            if (denominations[i] <= target) {
                // If the denomination is less than or equal to the target, subtract it and call the function recursively
                if (isExactDivisionHelper(denominations, i, target - denominations[i])) 
                    return true;
            }
        }
        // If no exact division is possible, return false
        return false;
    }
}