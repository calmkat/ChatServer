package ChatServer;
/**
 * Created by junsookim on 11/1/15.
 */
public class User {
    private String username;
    private String password;
    private SessionCookie cookie;
    public User(String username, String password, SessionCookie cookie) {
        this.username = username;
        this.password = password;
        this.cookie = cookie;
    }
    public String getName() {
        return this.username;
    }
    public boolean checkPassword(String password) {
        if (password.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }
    public SessionCookie getCookie() {
        return cookie;
    }
    public void setCookie(SessionCookie cookie) {
        this.cookie = cookie;
    }
}
