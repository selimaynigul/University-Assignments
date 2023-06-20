/**
 * 
 * @author Selim Aynigul
 */
package homework4;

public class Username {

    /**
     * check if username has at least 1 character or contains just letters
     * 
     * @param username will be checked
     * @return if username has at least 1 character or contains just letters return true, otherwise return false
     */
    public static boolean checkIfValidUsername(String username) {
        // Base case 1: Check if username is null or empty
        if (username == null || username.isEmpty()) {
            System.out.println("The username is invalid. It should have at least 1 character.");
            return false;
        }

        // Base case 2: Check if the first character is a letter
        char ch = username.charAt(0);
        if (!(ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            System.out.println("The username is invalid. It should have letters only.");
            return false;
        }

        // Base case 3: If the username has only one character and it is a letter, it is valid
        if (username.length() == 1) {
            return true;
        }

        // Recursion case:  check the rest of the username
        return checkIfValidUsername(username.substring(1));
    }
}