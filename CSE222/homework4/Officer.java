/**
 * 
 * @author Selim Aynigul
 */
package homework4;

public class Officer {

    String username;
    String password1;
    int password2;

    /**
     * constructor to assign username and passwords values
     * 
     * @param username
     * @param password1
     * @param password2
     */
    public Officer(String username, String password1, int password2) {
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
    }

    /**
     * 
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @return password1
     */
    public String getPassword1() {
        return password1;
    }

    /**
     * @return password2
     */
    public int getPassword2() {
        return password2;
    }
}
