/**
 * 
 * @author Selim Aynigul
 */
package homework4;

import java.util.Stack;

public class Password1 {

    /**
     * check if password1 has at least 8 characters
     * 
     * @param password1 will be checked
     * @return is password1 has at least 8 characters return true, otherwise return false
     */
    public static boolean checkSize(String password1) {
        if (password1.length() < 8) {
            System.out.println("The password1 is invalid. It should have at least 8 characters.");
            return false;
        }
        return true;
    }

    /**
     * check if password1 has at least 1 letter
     * 
     * @param password1 will be checked
     * @return if password1 has at least 1 letter return true, otherwise return false
     */
    public static boolean checkCharacters(String password1) 
    {
        int size = password1.length();
        for(int i = 0; i < size; ++i) {
            char ch = password1.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                return true;
            }
        } 
        System.out.println("The password1 is invalid. It should have letters too.");
        return false;
    }

    /**
     * check if password1 has at least 2 brackets
     * 
     * @param password1 will be checked
     * @return if password1 has at least 2 brackets return true, otherwise return false
     */
    public static boolean checkBrackets(String password1) 
    {
        int counter = 0;
        int size = password1.length();
        // count brackets
        for(int i = 0; i < size; ++i) {
            char c = password1.charAt(i);
            if(c == '(' || c == ')' || c == '[' || 
               c == ']' || c == '{' || c == '}') 
            {
                counter++;
            }
        }
        if(counter < 2) {
            System.out.println("The password1 is invalid. It should have at least 2 brackets.");
            return false;
        }
        return true;
    }
    
     /**
     * check if password1 contains any letter from username
     * 
     * @param password1 will be compared with username
     * @param username
     * @return if password1 contains any letter from username return true, otherwise return false
     */
    public static boolean containsUserNameSpirit(String password1, String username) 
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < username.length(); i++) {
            stack.push(username.charAt(i));
        }

        for(int i = 0; i < username.length(); ++i) {
            char charOfUsername = stack.pop();
            for(int j = 0; j < password1.length(); ++j) {
                if(password1.charAt(j) == charOfUsername)
                    return true;
            }
        }
        System.out.println("The password1 is invalid. It should have at least 1 character from the username.");
        return false;
    }

    /**
     * check if password has valid paranthesis
     * 
     * @param password1
     * @return if password1 has valid paranthesis return true, otherwise return false
     */
    public static boolean isBalancedPassword(String password1) 
    {    
        Stack<Character> stack = new Stack<Character>();
        for (char c : password1.toCharArray()) {
            if(c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}') 
            {       
                if (c == '(')
                stack.push(')');
                else if (c == '{')
                stack.push('}');
                else if (c == '[')
                stack.push(']');

                else if (stack.isEmpty() || stack.pop() != c) {
                    System.out.println("The password1 is invalid. It should be balanced.");
                    return false;
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        else {
            System.out.println("The password1 is invalid. It should be balanced.");
            return false;
        }
    }

    /**
     * check if it is possible to rearrange password1 to a form of palindrome string
     * 
     * @param password1
     * @return boolean
     */
    public static boolean isPalindromePossible(String password1) {
        /*
         * Removing Brackets
         */
        char[] charArray = password1.toCharArray();
        int keepCount = 0;
        // count characters except brackets
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '(' && charArray[i] != ')' && charArray[i] != '{' && 
                charArray[i] != '}' && charArray[i] != '[' && charArray[i] != ']') 
            {
                keepCount++;
            }
        }
        char[] newCharArray = new char[keepCount];
        int j = 0;
        // copy characters except brackets to new char array
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '(' && charArray[i] != ')' && charArray[i] != '{' && 
                charArray[i] != '}' && charArray[i] != '[' && charArray[i] != ']') 
            {
                newCharArray[j++] = charArray[i];
            }
        }
        // convert char array to string
        String newStr = new String(newCharArray);

        // check new password string without paranthesis
        if(isPalindromePossibleHelper("", newStr))
            return true;
        else {
            System.out.println("The password1 is invalid. It should be possible to obtain a palindrome from the password1.");
            return false;
        }
    }

    /**
     * create all possible combinations of given string and check if any of them is a palindrome.
     * 
     * @param firstPart create new string combinations assigning remanining letters in different orders to this parameter. should be blank at first call
     * @param secondPart original string to create other combinations
     * @return boolean
     */
    private static boolean isPalindromePossibleHelper(String firstPart, String secondPart) 
    {
        int length = secondPart.length();
        // base case: if all the letters are moved to the firstPart and created a new string combination, return if it is a palindrome
        if (length == 0) {
            return isPalindrome(firstPart);
        } 
        else {
            for (int i = 0; i < length; i++) {
                // recursive case: try creating different combinations of given string
                if(isPalindromePossibleHelper(firstPart + secondPart.charAt(i), secondPart.substring(0, i) + secondPart.substring(i + 1, length))) 
                    return true;
            }
            // if none of the created combinations of the string is a palindrome, return false
            return false;
        }
    }

    /**
     * check if given string is a palindrome recursively
     * 
     * @param str will be checked
     * @return if given string is a palindrome return true, otherwise return false
     */
    private static boolean isPalindrome(String s) {

        if(s.length() == 0 || s.length() == 1)
            return true; 

        if(s.charAt(0) == s.charAt(s.length()-1))
            return isPalindrome(s.substring(1, s.length()-1));

        return false;
    }
}
